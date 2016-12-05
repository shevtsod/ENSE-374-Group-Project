/*
 * FILENAME:        Doctor.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.List;

/**
 * <h1>class Doctor</h1>
 *
 * Concrete extension of class User. This class defines a User who signs into the
 * application as a doctor. This class allows a user to access exclusive features
 * of the program such as managing a list of patients.
 *
 * @author          Daniel Shevtsov
 */
public class Doctor extends User {

    private List<Patient> patients;


    /**
     * Constructor. Creates a new Doctor object and initializes it from the given parameters
     * @param name          Name of this User instance
     * @param n_list        Initial list of Notifications for this Doctor
     * @param a_list        Initial list of Appointments for this Doctor
     * @param pr_list       Initial list of Prescriptions for this Doctor
     * @param p_list        Initial list of Patients for this Doctor
     */
    public Doctor(String name,
                  List<Notification> n_list,
                  List<Appointment> a_list,
                  List<Prescription> pr_list,
                  List<Patient> p_list) {
        super(name, n_list, a_list, pr_list, UserType.Doctor);
        patients = p_list;
    }

    public void addPatient(Patient p) {

    }

    public List getPatientsList() {
        return null;
    }

    public void removePatient(Patient p) {

    }
}
