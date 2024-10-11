package com.sanjeevani.service;

import com.sanjeevani.model.Ambulance;
import com.sanjeevani.model.Location;
import com.sanjeevani.model.Patient;
import com.sanjeevani.repository.AmbulanceRepository;
import com.sanjeevani.util.AmbulanceRequest;
import com.sanjeevani.util.DistanceCalculator;
import com.sanjeevani.util.EmergencyClassifier;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class AmbulanceService {

    @Autowired
    private AmbulanceRepository ambulanceRepository;

    private PriorityQueue<AmbulanceRequest> requestQueue = new PriorityQueue<>(
            Comparator.comparingInt(AmbulanceRequest::getUrgencyLevel)
    );

    public void create(Ambulance ambulance) {
        ambulanceRepository.save(ambulance);
    }

    public List<Ambulance> getAmbulance() {
        return ambulanceRepository.findAll();
    }

    public void addAmbulanceRequest(Patient patient, String emergencyDescription) {
        Integer urgencyLevel = EmergencyClassifier.classifyUrgency(emergencyDescription);
        AmbulanceRequest request = new AmbulanceRequest(urgencyLevel, patient);
        requestQueue.offer(request);
        System.out.println("Added request with urgency level: " + urgencyLevel);
    }

    public void processRequests() {
        while (!requestQueue.isEmpty()) {
            AmbulanceRequest request = requestQueue.poll();
            if (request != null) {
                bookAmbulance(request.getPatient());
            }
        }
    }

    public void bookAmbulance(Patient patient) {
        Integer urgencyLevel = EmergencyClassifier.classifyUrgency(patient.getEmergencyDescription());
        System.out.println("Processing booking for urgency level: " + urgencyLevel);
        List<Ambulance> availableAmbulances = findAvailableAmbulances(patient.getLocation());
        if (availableAmbulances.isEmpty()) {
            System.out.println("No ambulances available.");
            return;
        }

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (Ambulance ambulance : availableAmbulances) {
            CompletableFuture<Void> future = sendBookingRequest(ambulance, patient);
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join(); // Wait for all responses
        processResponses(new HashMap<>()); // Pass an empty map or the actual responses
    }

    public List<Ambulance> findAvailableAmbulances(Location patientLocation) {
        List<Ambulance> ambulances = ambulanceRepository.findAvailableAmbulances();
        ambulances.sort(Comparator.comparingDouble(ambulance -> calculateDistance(patientLocation, ambulance.getLocation())));
        return ambulances.subList(0, Math.min(ambulances.size(), 5)); // Get top 5 nearest ambulances
    }

    @Async
    public CompletableFuture<Void> sendBookingRequest(Ambulance ambulance, Patient patient) {
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000); // Simulate ambulance response time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            boolean accepted = Math.random() < 0.5; // Simulate 50% chance of acceptance
            System.out.println("Ambulance " + ambulance.getId() + " responded: " + (accepted ? "Accepted" : "Declined"));
            if (accepted) {
                // Further processing if accepted
                // Logic to handle accepted response can go here
                cancelOtherRequests(ambulance);
            }
        });
    }

    @Cacheable("ambulanceDistances")
    public double calculateDistance(Location patientLocation, Location ambulanceLocation) {
        return DistanceCalculator.calculateDistance(patientLocation, ambulanceLocation);
    }

    private void processResponses(Map<Ambulance, Boolean> responses) {
        Ambulance nearestAcceptedAmbulance = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Map.Entry<Ambulance, Boolean> entry : responses.entrySet()) {
            if (entry.getValue()) { // If accepted
                double distance = DistanceCalculator.calculateDistance(entry.getKey().getLocation(), entry.getKey().getLocation());
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestAcceptedAmbulance = entry.getKey();
                }
            }
        }

        if (nearestAcceptedAmbulance != null) {
            System.out.println("Booking confirmed with Ambulance " + nearestAcceptedAmbulance.getId());
        } else {
            System.out.println("No ambulances accepted the request.");
        }
    }

    public void updateName(ObjectId id, String name) {
        ambulanceRepository.updateName(id, name);
    }

    public void updateLocation(ObjectId id, Location location) {
        ambulanceRepository.updateLocation(id, location);
    }

    public void updateStatus(ObjectId id, String status) {
        ambulanceRepository.updateStatus(id, status);
    }

//    public void updateDriverPhone(ObjectId id, String driverPhone) {
//        ambulanceRepository.updateDriverPhone(id, driverPhone);
//    }

    private void cancelOtherRequests(Ambulance acceptedAmbulance) {
        requestQueue.removeIf(request -> !request.getPatient().equals(acceptedAmbulance));
    }

    public void delete(ObjectId id) {
        ambulanceRepository.deleteById(id);
    }


//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    public void updateDriverPhone(ObjectId ambulanceId, String newPhone) {
//        Query query = new Query(Criteria.where("_id").is(ambulanceId));
//        Update update = new Update().set("driverPhone", newPhone);
//        mongoTemplate.updateFirst(query, update, Ambulance.class);
//    }


}