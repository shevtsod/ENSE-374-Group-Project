/*
 * FILENAME:        Main.java
 * COURSE:          ENSE 374
 * AUTHOR:          Group 9
 */

package com;

import com.shevtsod.SessionManager;

/**
 * class Main
 *
 * Serves as primary entry point for program.
 * Initializes SessionManager, Database, and BackupManager objects to control
 * the application's data and logic flow.
 *
 * @author          Group 9
 */
public class Main {
    /**
     * Primary entry point of the program.
     *
     * @param args Arguments passed through the console (unused)
     */
    public static void main(String[] args) {
        //Create object of SessionManager and pass control of the program to it.
        SessionManager currentSession = new SessionManager();
    }
}