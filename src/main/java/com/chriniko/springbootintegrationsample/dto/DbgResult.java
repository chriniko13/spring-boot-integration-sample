package com.chriniko.springbootintegrationsample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DbgResult {

    private DrawInfo drawInfo;

    private List<Ticket> tickets;

    private Map<String, List<Ticket>> groupingByOutcome;

    public DrawInfo getDrawInfo() {
        return drawInfo;
    }

    public void setDrawInfo(DrawInfo drawInfo) {
        this.drawInfo = drawInfo;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Map<String, List<Ticket>> getGroupingByOutcome() {
        return groupingByOutcome;
    }

    public void setGroupingByOutcome(Map<String, List<Ticket>> groupingByOutcome) {
        this.groupingByOutcome = groupingByOutcome;
    }
}
