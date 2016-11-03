package com.james;

import java.util.List;


public class User {
    protected String name;
    protected List notifications;
    protected List appointments;

    public User() {
        //TODO: Add User()
        //Maybe initialize notifications and appointments lists here.
    }

    /**
     * Set the name of this User.
     * @param name String containing the new name of this User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of this User.
     * @return String containing the name of this User.
     */
    public String getName() {
        return name;
    }

    public void addNotification(Notification n ) {
        //TODO: Add addNotification()
    }

    public void getNotification(Notification n) {
        //TODO: Add getNotification()
    }

    public void removeNotification(Notification n ) {
        //TODO: Add removeNotification()
    }

    public List getNotificationList() {
        //TODO: Add getNotificationList()
        return null;
    }

    public Appointment getAppointments(Appointment a ) {
        //TODO: Add getAppointments()
        return null;
    }

    public void removeAppointment(Appointment a) {
        //TODO: Add removeAppointment()

    }

    public List getAppointmentsList() {
        //TODO: Add getAppointmentsList()
        return null;
    }
}
