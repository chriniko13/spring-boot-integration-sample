package com.chriniko.springbootintegrationsample.dto;

public class DrawInfo {

    private int drawNumber;

    public int getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(int drawNumber) {
        this.drawNumber = drawNumber;
    }

    @Override
    public String toString() {
        return "DrawInfo{" +
                "drawNumber=" + drawNumber +
                '}';
    }
}
