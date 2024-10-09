package com.sanjeevani.repository;




public interface AmbulanceRepository extends MongoRepository<Ambulance , ObjectId> {


    List<Ambulance>  findAvailableAmbulances();
    List<Ambulance>  findAmbulancesByLocationNearBy(String location);
    List<Ambulance>  findAmbulancesByHospital(String hospital);
    List<Ambulance>  findAmbulancesByDriver(String driver);
    List<Ambulance>  findAmbulancesByStatus(String status);
    List<Ambulance>  findAmbulancesByLocationAndStatus(String location,String status);


}
