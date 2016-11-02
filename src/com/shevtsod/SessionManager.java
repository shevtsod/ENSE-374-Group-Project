/*
 * FILENAME:        SessionManager.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.Scanner;

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
    private StateManager sm;

    /**
     * Default constructor. Initializes a new SessionManager, asking the user
     * to login and provide their user type.
     */
    public SessionManager() {
        sm = new StateManager();
        //StateManager should initialize with Login, but just in case.
        sm.setState(StateType.Login);
        //Move the program to perform the actions in the Welcome state.
        Login();
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
     * @return Object extending User that is currently using the program.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Prints an interface corresponding to the current state of the program.
     */
    private void drawInterface() {
        switch(sm.getState()) {
            case Login:
                //ASCII text generated using http://patorjk.com/software/taag/
                System.out.println(
                        "***********************************************************\n" +
                        "  __  __          _ _           _           _       \n" +
                        " |  \\/  |        | (_)         | |         | |      \n" +
                        " | \\  / | ___  __| |_  ___ __ _| | ___ _ __| |_ ___ \n" +
                        " | |\\/| |/ _ \\/ _` | |/ __/ _` | |/ _ \\ '__| __/ __|\n" +
                        " | |  | |  __/ (_| | | (_| (_| | |  __/ |  | |_\\__ \\\n" +
                        " |_|  |_|\\___|\\__,_|_|\\___\\__,_|_|\\___|_|   \\__|___/\n" +
                        "\n***********************************************************\n"
                );
                System.out.println(
                        "Track your medical alerts and manage your" +
                        " doctor's appointments.\n"
                );
                System.out.println(
                        "LOGIN:\nEnter your username and user type separated " +
                        "by a " +
                        "space (i.e. JohnDoe P):\n" +
                        "Valid user types:\n" +
                        "\tP\t- Patient\n" +
                        "\tD\t- Doctor"
                );
                break;
            case Main:
                System.out.println(
                        "\nHello, User Name Here" //TODO: Replace with User name
                );
                System.out.println(
                        "***********************************************************\n" +
                        "YOUR ALERTS:");
                //TODO: Print User's list of alerts here
                System.out.println(
                        "***********************************************************\n" +
                        "YOUR APPOINTMENTS:");
                //TODO: Print User's list of appointments here
                System.out.println(
                        "***********************************************************\n" +
                        "SELECT AN ACTION: " +
                        "\tD\t - View list of drugs\n" +
                        "\tA\t - View list of appointments\n" +
                        "\tB\t - Backup/Restore menu\n" +
                        "\tQ\t - Quit program");
                break;
            case Drugs:
                //TODO: Revise output when added Drugs state
                System.out.print("Work In Progress. Press ENTER to return" +
                        " to main screen.");
                break;
            case Appointments:
                //TODO: Revise output when added Appointments state
                System.out.print("Work In Progress. Press ENTER to return" +
                        " to main screen.");
                break;
            case Backup:
                //TODO: Revise output when added Backup state
                System.out.println("Work In Progress. Press ENTER to return" +
                        " to main screen.");
                break;
            default:
                System.out.print("ERROR: Invalid program state! Terminating");
        }
    }

    /**************************************************
     *  LOGIC FOR INDIVIDUAL STATES
     **************************************************/

    /**
     * Processes input for the Login state.
     */
    private void Login() {
        drawInterface();

        //Scanner to capture user input to console
        Scanner input = new Scanner(System.in);
        boolean correctInput = false;
        String tempName;
        char tempType;

        //In Welcome, we want the user to supply their name and user type.
        do {
            //Query user for input in format:
            //[USERNAME] [USER-TYPE]
            //Loop until correct input is given.
            System.out.print("INPUT: ");
            tempName = input.next();
            tempType = input.next().charAt(0);
            //Skip remaining input in this line
            input.nextLine();
            //Check that UserType matches one of the known types:
            switch(Character.toUpperCase(tempType)) {
                case 'P':
                    //TODO: Initialize currentUser as Patient here
                    //currentUser = new Patient();
                    correctInput = true;
                    break;
                case 'D':
                    //TODO: Initialize currentUser as Doctor here
                    //currentUser = new Doctor();
                    correctInput = true;
                    break;
                default:
                    System.out.println("ERROR: Invalid user type");
            }

        } while(!correctInput);

        //If reach here, the login was successful. Proceed to Main state
        System.out.println("Logged in successfully.");
        sm.setState(StateType.Main);
        MainState();
    }

    /**
     * Processes input for the Main state.
     */
    private void MainState() {
        drawInterface();

        //Scanner to capture user input to console
        Scanner input = new Scanner(System.in);
        boolean correctInput = false;
        char nextState;

        do {
            //Query user for input in format:
            //[NEXT-STATE]
            //Loop until correct input is given.
            System.out.print("INPUT: ");
            nextState = input.next().charAt(0);
            //Skip remaining input in this line
            input.nextLine();
            switch(Character.toUpperCase(nextState)) {
                case 'D':
                case 'A':
                case 'B':
                case 'Q':
                    correctInput = true;
                    break;
                default:
                    System.out.println("ERROR: Invalid action");
                    break;

            }
        } while(!correctInput);

        //If reach here, input is correct. Move to the appropriate next state.
        switch(nextState) {
            case 'D':
                sm.setState(StateType.Drugs);
                Drugs();
                break;
            case 'A':
                sm.setState(StateType.Appointments);
                Appointments();
                break;
            case 'B':
                sm.setState(StateType.Backup);
                Backup();
                break;
            case 'Q':
                System.exit(0);
                break;
        }
    }

    /**
     * Processes input for the Drugs state.
     */
    private void Drugs() {
        drawInterface();
    }

    /**
     * Processes input for the Appointments state.
     */
    private void Appointments() {
        drawInterface();
    }

    /**
     * Processes input for the Backup state.
     */
    private void Backup() {
        drawInterface();

        //Scanner to capture user input to console
        Scanner input = new Scanner(System.in);

        //TODO: Add this state
        while(input.hasNextLine()) {
            sm.setState(StateType.Main);
            MainState();
        }
    }
}