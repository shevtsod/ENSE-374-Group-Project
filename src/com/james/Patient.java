package com.james;

import java.util.List;

public class Patient extends User {
    private List drugsList;

    public Patient(String name) {
        this.name = name;
    }

    public Patient (String name, List notification, List appointments, List drugs) {
        //TODO: Add overloaded Patient()
    }

    public void addDrug(Drug d) {
        //TODO: Add addDrug()
    }

    public Drug getDrug(Drug d) {
        //TODO: Add getDrug()
        return null;
    }

    public List getDrugsList() {
        //TODO: Add getDrugsList()
        return drugsList;
    }

    public Drug removeDrug(Drug d) {
        //TODO: Add removeDrug()
        return null;
    }
}
