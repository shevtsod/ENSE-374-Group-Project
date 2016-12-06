/*
 * FILENAME:        SessionManager.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private StateManager sm;
    private List<Patient> patientList;
    private List<Doctor> doctorList;


    /**
     * Default constructor. Initializes a new SessionManager, asking the user
     * to login and provide their user type.
     */
    public SessionManager() {
        sm = new StateManager();
        // StateManager should initialize with Login, but just in case.
        sm.setState(StateType.Login);
        patientList = new ArrayList<Patient>();
        doctorList = new ArrayList<Doctor>();

        // Move the program to perform the actions in the Welcome state.
        Login();
    }

    /**
     * Based on character input, returns whether a certain operation is allowed for the current user
     * This function can be used to regulate access to different features of the program and restrict them
     * to different UserTypes
     * @param op The char containing the operation to be checked
     * @return The result of the check - true if operation is allowed
     */
    private boolean isAllowed(char op) {
        UserType type = currentUser.getUserType();
        switch(op) {
            case 'D':   //Drugs
                return (type == UserType.Patient);
            case 'A':   //Appointments
            case 'R':   //Prescriptions
                return (type == UserType.Patient || type == UserType.Doctor);
            case 'P':   //Patients
                return(type == UserType.Doctor);
            case 'M':   //Admin
                return(type == UserType.Admin);
            case 'Q':   //Quit
                return true;
            default:
                return false;
        }
    }

    /**
     * Returns the current user of the program
     * @return Object extending User that is currently using the program.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Prints an interface corresponding to the current state of the program and the user type.
     */
    private void drawInterface() {
        switch(sm.getState()) {
            case Login:
                // ASCII text generated using http://patorjk.com/software/taag/
                System.out.println(
                        "***********************************************************\n" +
                        "  __  __          _ _           _           _       \n" +
                        " |  \\/  |        | (_)         | |         | |      \n" +
                        " | \\  / | ___  __| |_  ___ __ _| | ___ _ __| |_ ___ \n" +
                        " | |\\/| |/ _ \\/ _` | |/ __/ _` | |/ _ \\ '__| __/ __|\n" +
                        " | |  | |  __/ (_| | | (_| (_| | |  __/ |  | |_\\__ \\\n" +
                        " |_|  |_|\\___|\\__,_|_|\\___\\__,_|_|\\___|_|   \\__|___/\n" +
                        "\n***********************************************************\n" +
                        "Track your medical alerts and manage your" +
                        " doctor's appointments.\n" +
                        "LOGIN:\nEnter your username and user type separated " +
                        "by a " +
                        "space (i.e. JohnDoe P):\n" +
                        "Valid user types:\n" +
                        "\tP\t- Patient\n" +
                        "\tD\t- Doctor\n" +
                        "\tA\t- Admin"
                );
                break;

            case Main:
                System.out.println(
                        "\nHello, " + currentUser.getName() + "\n" +
                        "Logged in as " + currentUser.getUserType().toString() + "\n" +
                        "***********************************************************\n" +
                        "YOUR NOTIFICATIONS:");
                currentUser.printNotifications();
                System.out.println(
                        "***********************************************************\n" +
                        "YOUR APPOINTMENTS:");
                currentUser.printAppointments();
                System.out.println(
                        "***********************************************************\n" +
                                "SELECT AN ACTION:"
                );

                //Print list of actions depending on UserType
                if(isAllowed('D'))
                    System.out.println("\tD\t - View list of drugs");
                if(isAllowed('A'))
                    System.out.println("\tA\t - View list of appointments");
                if(isAllowed('R'))
                    System.out.println("\tR\t - View list of prescriptions");
                if(isAllowed('P'))
                    System.out.println("\tP\t - View list of patients");
                if(isAllowed('M'))
                    System.out.println("\tM\t - Manage list of users");
                System.out.println("\tQ\t - Quit program");
                break;

            case Drugs:
                //TODO: Revise output when added Drugs state
                System.out.print("DRUGS: Work In Progress. Press ENTER to return" +
                        " to main screen.");
                break;

            case Appointments:
                //TODO: Revise output when added Appointments state
                System.out.print("APPOINTMENTS: Work In Progress. Press ENTER to return" +
                        " to main screen.");
                break;

            case Prescriptions:
                System.out.println(
                        "*** PRESCRIPTIONS MANAGER ***\n" +
                        "View and remove prescriptions.\n Doctors can also assign prescriptions for their " +
                        "patients.\n" +
                        "***********************************************************\n" +
                        "YOUR PRESCRIPTIONS:"
                );
                currentUser.printPrescriptions();
                if(currentUser.getUserType() == UserType.Doctor) {
                    System.out.println(
                            "***********************************************************\n" +
                            "YOUR PATIENTS:"
                    );
                    //Convert currentUser to a Doctor to invoke printPatients()
                    Doctor docUser = (Doctor)currentUser;
                    docUser.printPatients();
                }

                System.out.println(
                        "***********************************************************\n" +
                                "SELECT AN ACTION:\n" +
                                "\tR\t - Remove a prescription"
                );
                if(currentUser.getUserType() == UserType.Doctor)
                    System.out.print("\tA\t - Add a prescription\n");
                System.out.print("\tB\t - Back to main menu\n");
                break;

            case Patients:
                System.out.println(
                        "*** PATIENTS MANAGER ***\n" +
                        "View, add, and remove patients.\n" +
                        "***********************************************************\n" +
                        "YOUR PATIENTS:"
                );
                //Convert currentUser to a Doctor to invoke printPatients()
                Doctor docUser = (Doctor)currentUser;
                docUser.printPatients();
                System.out.print(
                        "***********************************************************\n" +
                                "SELECT AN ACTION:\n" +
                                "\tR\t - Remove a patient\n" +
                                "\tA\t - Add a patient\n" +
                                "\tB\t - Back to main menu\n"
                );
                break;

            case Admin:
                //TODO: Revise output when added Appointments state
                System.out.print("ADMIN: Work In Progress. Press ENTER to return" +
                        " to main screen.");
                break;

            default:
                System.out.print("ERROR: Invalid program state! Terminating");
        }
    }

    /*--------------------------------------------------
     *  LOGIC FOR INDIVIDUAL STATES
     *-------------------------------------------------/

    /**
     * Processes input for the Login state.
     */
    private void Login() {
        //In Login, we want the user to supply their name and user type.
        drawInterface();

        //Scanner to capture user input to console
        Scanner input = new Scanner(System.in, "UTF-8");
        boolean correctInput = false;
        String userName;
        char userType;

        //Initialize several lists to pass to the new User object we create
        List<Notification> n_list = new ArrayList<Notification>();
        List<Appointment> a_list = new ArrayList<Appointment>();
        List<Prescription> pr_list = new ArrayList<Prescription>();
        List<Drug> d_list = new ArrayList<Drug>();
        List<Patient> p_list = new ArrayList<Patient>();

        do {
            //Query user for input in format:
            //[USERNAME] [USER-TYPE]
            //Loop until correct input is given.
            System.out.print("INPUT: ");
            userName = input.next();
            userType = input.next().charAt(0);
            //Skip remaining input in this line
            input.nextLine();
            //Check that UserType matches one of the known types:
            switch(Character.toUpperCase(userType)) {
                case 'P':
                    currentUser = new Patient(userName, n_list, a_list, pr_list, d_list);
                    patientList.add((Patient)currentUser);
                    correctInput = true;
                    break;

                case 'D':
                    currentUser = new Doctor(userName, n_list, a_list, pr_list, p_list);
                    doctorList.add((Doctor)currentUser);
                    correctInput = true;
                    break;

                case 'A':
                    currentUser = new Admin(userName);
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
        Scanner input = new Scanner(System.in, "UTF-8");
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
            //Check if this UserType is allowed to perform this operation
            if(!isAllowed(Character.toUpperCase(nextState))) {
                System.out.println("ERROR: Invalid action");
                continue;
            }
            switch(Character.toUpperCase(nextState)) {
                //Valid state characters
                case 'D': case 'A': case 'R': case 'P': case 'M': case 'Q':
                    correctInput = true;
                    break;
                //Invalid state character
                default:
                    System.out.println("ERROR: Invalid action");
                    break;

            }
        } while(!correctInput);

        //If reach here, input is correct. Move to the appropriate next state.
        switch(Character.toUpperCase(nextState)) {
            case 'D':
                sm.setState(StateType.Drugs);
                Drugs();
                break;
            case 'A':
                sm.setState(StateType.Appointments);
                Appointments();
                break;
            case 'R':
                sm.setState(StateType.Prescriptions);
                Prescriptions();
                break;
            case 'P':
                sm.setState(StateType.Patients);
                Patients();
                break;
            case 'M':
                sm.setState(StateType.Admin);
                Admin();
                break;
            case 'Q':
                System.out.println("Closing program.");
                input.close();
                System.exit(0);
                break;
        }
    }

    /**
     * Processes input for the Drugs state.
     */
    private void Drugs() {
        // In Drugs, we want to allow a user to view Drugs. If the user is a Doctor, they can also add
        // and remove Drugs from their Patients' 'drugs' lists.
        //TODO: Add this state
        drawInterface();

        //Scanner to capture user input to console
        Scanner input = new Scanner(System.in, "UTF-8");

        String temp = input.nextLine();

        sm.setState(StateType.Main);
        MainState();
    }

    /**
     * Processes input for the Appointments state.
     */
    private void Appointments() {
        // In Appointments, we want to allow a user to view their appointments
        // and remove appointments. A user designated as a Doctor will also
        // be able to add appointments.
        //TODO: Add this state
        Drugs();
    }

    /**
     * Processes input for the Prescriptions state.
     */
    private void Prescriptions() {
        // In Prescriptions, we want to allow a user to view their prescriptions
        // and remove prescriptions. A user designated as a Doctor will also
        // be able to add prescriptions.
        drawInterface();

        //Scanner to capture user input to console
        Scanner input = new Scanner(System.in, "UTF-8");
        boolean correctInput = false;
        char operation;

        do {
            //Query user for input in format:
            //[OPERATION]
            //Loop until correct input is given.
            System.out.print("INPUT: ");
            operation = input.next().charAt(0);
            //Skip remaining input in this line
            input.nextLine();

            //Validate input
            switch(Character.toUpperCase(operation)) {
                //Valid operations
                case 'A': case 'R': case 'B':
                    correctInput = true;
                    break;
                //Invalid operation
                default:
                    System.out.println("ERROR: Invalid action");
                    break;
            }
        } while(!correctInput);

        //TODO: Complete this part of the Prescriptions state
        //Perform the requested action
        switch(Character.toUpperCase(operation)) {
            //Add a prescription
            case 'A':
                //Input from the user which patient they would like to add the prescription for
                //TODO: Add user input code here

                //p contains the Patient object that the doctor selected
                //TODO: Replace this with an actual Patient selected by the doctor
                Patient p = new Patient("default-patient", null, null, null, null);

                //Capture the time when this prescription was created
                Date dt = new Date(); //This constructor initializes the object with the current time

                //Create a new drug and populate it with information from user input

                //Input from the user the name of the drug
                //TODO: Replace this with an actual name from user input
                String name = "default-drug";

                //Input from the user the refill date of the drug
                //TODO: Replace this with an actual date from user input
                Date rd = new Date();
                rd.setTime(rd.getTime() + 100000); //Temporary value (current time + 100000ms)

                Drug d = new Drug(name, dt, rd);

                //Create a new Prescription and populate it with the relevant information
                //The Doctor of the prescription


                Prescription pres = new Prescription(d, p, (Doctor)currentUser, dt);

                //Add this prescription to both the patient and doctor's lists of prescriptions
                p.addDrug(d);
                p.addPrescription(pres);
                currentUser.addPrescription(pres);

                //Return to prescription manager
                Prescriptions();

                break;

            //Remove a prescription
            case 'R':
                //Search the list of prescriptions for one that matches the user input and remove it if
                //it exists, otherwise print an error.

                //TODO: Remove this temporary code
                System.out.println("Work In Progress. Press ENTER to return" +
                                " to main screen.");
                String temp = input.nextLine();

                sm.setState(StateType.Main);
                MainState();
                break;

            //Return to main menu
            case 'B':
                sm.setState(StateType.Main);
                MainState();
                break;
        }
    }

    /**
     * Processes input for the Patients state.
     */
    private void Patients() {
        // In Patients, we want to allow a Doctor to view, add, and remove Patients by managing their
        // 'patients' List.
        //TODO: Add this state
        Drugs();
    }

    /**
     * Processes input for the Admin state.
     */
    private void Admin() {
        // In Admin, we want to allow an Admin to view, add, and remove Users by managing the
        // 'patientList' and 'doctorList' of this class.
        //TODO: Add this state
        Drugs();
    }
}