package com.chriniko.springbootintegrationsample.dto;

public class Ticket {

    protected String id;
    protected Integer drawNumber;
    protected String outcome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(Integer drawNumber) {
        this.drawNumber = drawNumber;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
