/*
 * FILENAME:        Doctor.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.Iterator;
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

    /**
     * Add a new Patient to the list of Patients for this Doctor object
     * @param p The Patient to be added to the list
     */
    public void addPatient(Patient p) {
        if(patients == null)
            System.out.println(" - ERROR: Could not add patient");
        else
            patients.add(p);
    }

    /**
     * Get the current list of Patients for this object. Useful to search the list for a Patient
     * and remove it using removePatient()
     * Note: Returns null if List does not exist
     * @return The current List of Patients
     */
    public List<Patient> getPatientsList() {
        return patients;
    }

    /**
     * Remove a given Patient from this Doctor object's List of Patients
     * @param p The Patient to be removed from the List
     */
    public void removePatient(Patient p) {
        if(patients != null && !patients.isEmpty() && patients.contains(p)) {
            patients.remove(p);
            System.out.println(" - Successfully removed patient " + p.getName());
        } else {
            System.out.println(" - ERROR: Could not remove patient " + p.getName());
        }
    }

    /**
     * Formats and prints the list of Patients to the console
     */
    public void printPatients() {
        if(patients == null || patients.isEmpty()) {
            System.out.println(" - There are no patients.");
            return;
        }

        Iterator<Patient> i = patients.iterator();
        int index = 1;
        while(i.hasNext()) {
            Patient curr = i.next();
            System.out.println(
                    " " + (index++) + ". " + curr.getName()
            );
        }
    }
}
