/*
 * FILENAME:        Patient.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.List;

/**
 * <h1>class Patient</h1>
 *
 * Concrete extension of class User. This class defines a User who signs into the
 * application as a patient. This class allows a user to access exclusive features
 * of the program such as managing a list of drugs
 *
 * @author          Daniel Shevtsov
 */
public class Patient extends User {

    private List<Drug> drugs;

    /**
     * Constructor. Creates a new Patient object and initializes it from the given parameters
     * @param name          Name of this User instance
     * @param n_list        Initial list of Notifications for this Patient
     * @param a_list        Initial list of Appointments for this Patient
     * @param pr_list       Initial list of Prescriptions for this Patient
     * @param d_list        Initial list of Drugs for this Patient
     */
    public Patient(String name,
                   List<Notification> n_list,
                   List<Appointment> a_list,
                   List<Prescription> pr_list,
                   List<Drug> d_list) {
        super(name, n_list, a_list, pr_list, UserType.Patient);
        drugs = d_list;
    }

}
