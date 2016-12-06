/*
 * FILENAME:        Prescription.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.Date;

/**
 * <h1>class Prescription</h1>
 *
 * Implements a data type to store the information of a prescription assigned by a doctor to a patient.
 * Currently, a prescription consists of a drug and the date of the prescription, but more member variables
 * can be added to extend the capabilities of this class and allow for more detailed prescriptions.
 *
 * @author          Daniel Shevtsov
 */
public class Prescription {

    private Drug drug;
    private Patient patient;
    private Doctor doctor;
    private Date date;


    /**
     * Constructor. Creates a new Prescription object and initializes it from the given parameters
     * @param dr        The Drug that was assigned to the Patient
     * @param p         The Patient that the Prescription is assigned to
     * @param d         The Doctor that assigned the Prescription
     * @param dt        The Date of the Prescription
     */
    public Prescription(Drug dr, Patient p, Doctor d, Date dt) {
        drug = dr;
        patient = p;
        doctor = d;
        date =  dt;
    }

    /**
     * @return The Drug that was assigned to the Patient
     */
    public Drug getDrug() {
        return drug;
    }

    /**
     * @return The Patient that the Prescription is assigned to
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @return The Doctor that assigned the Prescription
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @return The Date of the Prescription
     */
    public Date getDate() {
        return date;
    }

}
