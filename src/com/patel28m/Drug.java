package com.patel28m;

import java.sql.Date;

public class Drug {

    private String name;
    private int id;
    private Date purchaseDate;
    private Date refillDate;

    public Drug (String name, int id, Date purchaseDate, Date refillDate)
    {
	this.name = name;
	this.id = id;
	this.purchaseDate = purchaseDate;
	this.refillDate = refillDate;
    }

    public String getDrugName()
    {
	return name;
    }

    public Date getPurchaseDate()
    {
	return purchaseDate;
    }

    public Date getRefillDate()
    {
        return refillDate;
    }

}
