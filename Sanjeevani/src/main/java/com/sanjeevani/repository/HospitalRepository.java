package com.sanjeevani.repository;




public interface HospitalRepository  extends MongoRepository<Hospital,ObjectId> {


    Integer countByHospitalName(String hospitalName);
    List<Hospital> findByHospitalName(String hospitalName);
    List<Hospital> findByLocation(String location);
    List<Hospital> findByLocationNear(String location);
    Integer countCapacityByHospitalName(String hospitalName);
    Integer countOccupiedByHospitalName(String hospitalName);
    Integer countAvailableByHospitalName(String hospitalName);

}
