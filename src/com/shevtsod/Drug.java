/*
 * FILENAME:        Drug.java
 * COURSE:          ENSE 374
 * AUTHOR:          Daniel Shevtsov
 */

package com.shevtsod;

import java.util.Date;

/**
 * <h1>class Drug</h1>
 *
 * Implements a data type to store the information of a drug.
 *
 * @author          Daniel Shevtsov
 */
public class Drug {

    private String name;
    private int id;
    private Date purchaseDate;
    private Date refillDate;

    private static int idcounter;


    /**
     * Constructor. Initializes members of this Drug object
     * @param name Name of this drug
     * @param pd The date when this drug was prescribed
     * @param rd The date when this drug is due to be refilled
     */
    public Drug(String name, Date pd, Date rd) {
        this.name = name;
        id = Drug.idcounter++;
        purchaseDate = pd;
        refillDate = rd;
    }

    /**
     * @return The name of this drug
     */
    public String getDrugName() {
        return name;
    }

    /**
     * @return The ID of this drug
     */
    public int getId() {
        return id;
    }

    /**
     * @return The date on which this drug was prescribed
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @return The date when this drug is due to be refilled
     */
    public Date getRefillDate() {
        return refillDate;
    }
}
