/*
 * FILENAME:        StateManager.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

/**
 * <h1>class StateManager</h1>
 *
 * Manages the state of the program, assists SessionManager in handling the
 * actions of a user and managing application state.
 *
 * @author          Daniel Shevtsov
 */
public class StateManager {
    private StateType currentState;

    /**
     * Default constructor. Initializes an object of StateManager.
     */
    StateManager() {
        //The default state for this application is the login screen.
        currentState = StateType.Login;
    }

    /**
     * Sets the current state of this state manager.
     * @param s New StateType that this StateManager will hold.
     */
    public void setState(StateType s) {
        currentState = s;
    }

    /**
     * Gets the current state of this state manager.
     * @return current StateType of this StateManager.
     */
    public StateType getState() {
        return currentState;
    }
}
