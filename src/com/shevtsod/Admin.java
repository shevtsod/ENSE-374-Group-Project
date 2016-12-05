/*
 * FILENAME:        Admin.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

/**
 * <h1>class Admin</h1>
 *
 * Concrete extension of class User. This class defines a User who signs into the
 * application as an administrator. This class allows a user to access exclusive features
 * of the program such as managing the list of Users of the program.
 *
 * @author          Daniel Shevtsov
 */
public class Admin extends User {


    /**
     *  Constructor. Initializes an Admin that extends User.
     */
    public Admin(String name) {
        // The Admin is not intended to participate as a typical User, so all of its lists are empty
        super(name, null, null, null, UserType.Admin);
    }
}
