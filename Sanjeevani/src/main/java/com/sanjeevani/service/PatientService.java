package com.sanjeevani.service;




public class PatientService {


    @Autowired
    private PatientRepository patientRepository;



    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }


}
