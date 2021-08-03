package com.test.demo.entity;

public enum Status {

    ORDERED("Ordered"),
    SENT("Sent"),
    RETURNED("Returned"),
    FINISHED("Finished");

    private final String displayValue;
    
    private Status(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
    

}
