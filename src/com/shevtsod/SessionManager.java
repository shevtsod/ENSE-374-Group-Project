/*
 * FILENAME:        SessionManager.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

/**
 * <h1>class SessionManager</h1>
 *
 * Manages a user's session by sending messages between different objects and
 * updating the UI and application state according to the user's actions.
 *
 * @author          Daniel Shevtsov
 */
public class SessionManager {

    private User currentUser;
    private UserType currentUserType;

    /**
     * Default constructor. Initializes a new SessionManager, asking the user
     * to login and provide their user type.
     */
    public SessionManager() {

    }

    /**
     * Allows to set the current User of the program.
     * @param u The new object extending User that will use the program.
     */
    public void setCurrentUser(User u) {
        currentUser = u;
    }

    /**
     * Returns the current user of the program
     * @param u Object extending User that is currently using the program.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Prints an interface corresponding to the current state of the program.
     * @param sm StateManager holding the current state of the program.
     */
    private void drawInterface(StateManager sm) {
        //TODO: Add drawInterface()
    }

    /**************************************************
     *  LOGIC FOR INDIVIDUAL STATES
     **************************************************/

    /**
     * Processes input for the Backup state.
     * @param sm StateManager to update state of based on user input.
     */
    public void Backup(StateManager sm) {
        //TODO: Add Backup()
    }

    /**
     * Processes input for the Login state.
     * @param sm StateManager to update state of based on user input.
     */
    public void Login(StateManager sm) {
        //TODO: Add Login()
    }

    /**
     * Processes input for the Main state.
     * @param sm StateManager to update state of based on user input.
     */
    public void Main(StateManager sm) {
        //TODO: Add Main()
    }

    /**
     * Processes input for the Appointments state.
     * @param sm StateManager to update state of based on user input.
     */
    public void Appointments(StateManager sm) {
        //TODO: Add Appointments()
    }

    /**
     * Processes input for the Drugs state.
     * @param sm StateManager to update state of based on user input.
     */
    public void Drugs(StateManager sm) {
        //TODO: Add Drugs()
    }
}