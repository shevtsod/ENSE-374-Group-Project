/*
 * FILENAME:        Appointment.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.Date;

/**
 * <h1>class Appointment</h1>
 *
 * Implements a data type to store the information of an appointment between a patient and a doctor.
 *
 * @author          Daniel Shevtsov
 */
public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private Date date;


    /**
     * Constructor. Creates a new Appointment object and initializes it from the given parameters
     * @param p         The Patient to which the Appointment is assigned
     * @param d         The Doctor that assigned the Appointment
     * @param dt        The Date of the Appointment
     */
    public Appointment(Patient p, Doctor d, Date dt) {
        patient = p;
        doctor = d;
        date = dt;
    }

    /**
     * @return The Patient to which the Appointment is assigned
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @return The Dcctor that assigned the Appointment
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @return The Date of the Appointment
     */
    public Date getDate() {
        return date;
    }

}
