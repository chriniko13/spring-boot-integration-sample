package com.chriniko.springbootintegrationsample.dto;

import java.util.List;

public class DbgResult {

    private DrawInfo drawInfo;

    private List<Ticket> winTickets;

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
}
