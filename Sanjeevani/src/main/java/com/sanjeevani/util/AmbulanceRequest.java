package com.sanjeevani.util;

import com.sanjeevani.model.Patient;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AmbulanceRequest {



    private Integer UrgencyLevel;
    private Patient patient;

    public AmbulanceRequest(Integer urgencyLevel, Patient patient) {
        UrgencyLevel = urgencyLevel;
        this.patient = patient;
    }

    public Integer getUrgencyLevel() {
        return UrgencyLevel;
    }

    public void setUrgencyLevel(Integer urgencyLevel) {
        UrgencyLevel = urgencyLevel;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
