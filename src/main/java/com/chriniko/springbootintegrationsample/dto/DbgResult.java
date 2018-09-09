package com.chriniko.springbootintegrationsample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DbgResult {

    private DrawInfo drawInfo;

    private List<Ticket> winTickets;

    private Map<String, List<Ticket>> groupingByOutcome;

    public DrawInfo getDrawInfo() {
        return drawInfo;
    }

    public void setDrawInfo(DrawInfo drawInfo) {
        this.drawInfo = drawInfo;
    }

    public List<Ticket> getWinTickets() {
        return winTickets;
    }

    public void setWinTickets(List<Ticket> winTickets) {
        this.winTickets = winTickets;
    }

    public Map<String, List<Ticket>> getGroupingByOutcome() {
        return groupingByOutcome;
    }

    public void setGroupingByOutcome(Map<String, List<Ticket>> groupingByOutcome) {
        this.groupingByOutcome = groupingByOutcome;
    }
}
