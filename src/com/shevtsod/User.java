/*
 * FILENAME:        User.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.Iterator;
import java.util.List;


/**
 * <h1>class User</h1>
 *
 * Abstract class. This class defines a User with features that any extension of User should include.
 * Classes that inherit from this class become valid Users with different specializations.
 *
 * @author          Daniel Shevtsov
 */
public abstract class User {

    protected String name;
    protected List<Notification> notifications;
    protected List<Appointment> appointments;
    protected List<Prescription> prescriptions;
    protected UserType type;


    /**
     * Constructor. Creates a new User object and initializes it from the given parameters
     * @param n             Name of this User instance
     * @param n_list        Initial list of Notifications for this User
     * @param a_list        Initial list of Appointments for this User
     * @param pr_list       Initial list of Prescriptions for this User
     * @param t             UserType of this User instance
     */
    public User(String n,
                List<Notification> n_list,
                List<Appointment> a_list,
                List<Prescription> pr_list,
                UserType t) {
        name = n;
        notifications = n_list;
        appointments = a_list;
        prescriptions = pr_list;
        type = t;
    }

    /**
     * @return The String containing the name of this User
     */
    public String getName() {
        return name;
    }

    /**
     * @return The UserType of this User object
     */
    public UserType getUserType() {
        return type;
    }

    /**
     * Add a new Notification to the list of Notifications for this User object
     * @param n The Notification to be added to the list
     */
    public void addNotification(Notification n) {
        if(notifications == null)
            System.out.println(" - ERROR: Could not add notification");
        else
            notifications.add(n);
    }

    /**
     * Add a new Appointment to the list of Appointments for this User object
     * @param a The Appointment to be added to the list
     */
    public void addAppointment(Appointment a) {
        if(appointments == null)
            System.out.println(" - ERROR: Could not add notification");
        else
            appointments.add(a);
    }

    /**
     * Add a new Prescription to the list of Prescriptions for this User object
     * @param pr The Prescription to be added to the list
     */
    public void addPrescription(Prescription pr) {
        if(prescriptions == null)
            System.out.println(" - ERROR: Could not add prescription (" + this + ")");
        else
            prescriptions.add(pr);
    }

    /**
     * Get the current list of Notifications for this object. Useful to search the list for a Notification
     * and remove it using removeNotification()
     * Note: Returns null if List does not exist
     * @return The current List of Notifications
     */
    public List<Notification> getNotificationsList() {
        return notifications;
    }

    /**
     * Get the current list of Appointments for this object. Useful to search the list for an Appointment
     * and remove it using removeAppointment()
     * Note: Returns null if List does not exist
     * @return The current List of Appointments
     */
    public List<Appointment> getAppointmentsList() {
        return appointments;
    }

    /**
     * Get the current list of Prescriptions for this object. Useful to search the list for a Prescription
     * and remove it using removePrescription()
     * Note: Returns null if List does not exist
     * @return The current List of Prescriptions
     */
    public List<Prescription> getPrescriptionsList() {
        return prescriptions;
    }

    /**
     * Remove a given Notification from this User object's List of Notifications
     * @param n The Notification to be removed from the List
     */
    public void removeNotification(Notification n) {
        if(notifications != null && !notifications.isEmpty() && notifications.contains(n)) {
            notifications.remove(n);
            System.out.println(" - Successfully removed notification");
        } else {
            System.out.println(" - ERROR: Could not remove notification");
        }
    }

    /**
     * Remove a given Appointment from this User object's List of Appointments
     * @param a The Appointment to be removed from the List
     */
    public void removeAppointment(Appointment a) {
        if(appointments != null && !appointments.isEmpty() && appointments.contains(a)) {
            appointments.remove(a);
            System.out.println(" - Successfully removed appointment");
        } else {
            System.out.println(" - ERROR: Could not remove appointment");
        }
    }

    /**
     * Remove a given Prescription from this User object's List of Prescriptions
     * @param pr The Prescription to be removed from the List
     */
    public void removePrescription(Prescription pr) {
        if(prescriptions != null && !prescriptions.isEmpty() && prescriptions.contains(pr)) {
            prescriptions.remove(pr);
            System.out.println(" - Successfully removed prescription");
        } else {
            System.out.println(" - ERROR: Could not remove prescription");
        }
    }

    /**
     * Formats and prints the list of Notifications to the console
     */
    public void printNotifications() {
        if(notifications == null || notifications.isEmpty()) {
            System.out.println(" - There are no notifications.");
            return;
        }

        Iterator<Notification> i = notifications.iterator();
        while(i.hasNext()) {
            Notification curr = i.next();
            System.out.println(
                    " - " + curr.getNotification()
            );
        }
    }

    /**
     * Formats and prints the list of Appointments to the console
     */
    public void printAppointments() {
        if(appointments == null || appointments.isEmpty()) {
            System.out.println(" - There are no appointments.");
            return;
        }

        Iterator<Appointment> i = appointments.iterator();
        while(i.hasNext()) {
            Appointment curr = i.next();
            System.out.println(
                    " - Appointment at " + curr.getDate() + "(" + curr.getPatient()
                    + ", " + curr.getDoctor() + ")"
            );
        }
    }

    /**
     * Formats and prints the list of Prescriptions to the console
     */
    public void printPrescriptions() {
        if(prescriptions == null || prescriptions.isEmpty()) {
            System.out.println(" - There are no prescriptions.");
            return;
        }

        Iterator<Prescription> i = prescriptions.iterator();
        int index = 1;
        while(i.hasNext()) {
            Prescription curr = i.next();
            System.out.println(
                    " " + (index++) + ". Prescription by " + curr.getDoctor().getName() + " to "
                    + curr.getPatient().getName()
                    + " of drug " + curr.getDrug().getDrugName() + " assigned on " +
                    curr.getDate().toString()
            );
        }
    }

}
