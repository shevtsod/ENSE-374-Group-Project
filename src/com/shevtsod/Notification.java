/*
 * FILENAME:        Notification.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

/**
 * <h1>class Notification</h1>
 *
 * Implements a data type to store a string containing a standard notification for the user.
 * This Notification class only implements 2 different notifications at the moment, but more can be added to
 * extend the functionality of this class.
 *
 * @author          Daniel Shevtsov
 */
public class Notification {

    private String text;


    /**
     * Default Constructor. Creates a new Notification object and initializes it with default values.
     */
    public Notification() {
        text = " - ERROR: Unspecified Notification";
    }

    /**
     * Set this Notification to hold a reminder to a user to take a drug
     * @param d The Drug to be taken
     * @return The new String of this Notification
     */
    public String takeDrug(Drug d) {
        return (" - Remember to take " + d.getDrugName() + " (ID: " + d.getId() + ") today!");
    }

    /**
     * Set this Notification to hold a drug refill reminder for the user
     * @param d The Drug to be refilled
     * @return The new String of this Notification
     */
    public String refillDrug(Drug d) {
        text = " - Remember to refill " + d.getDrugName() + "(ID: " + d.getId()
                + "by " + d.getRefillDate().toString();
        return text;
    }

    /**
     * @return The current String of this Notification
     */
    public String getNotification() {
        return text;
    }

}
