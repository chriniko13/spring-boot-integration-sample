package com.chriniko.springbootintegrationsample.dto;

import java.util.List;

public class SwissLotto extends Ticket {

    private List<String> boardOneNumbers;

    private List<String> boardTwoNumbers;

    public List<String> getBoardOneNumbers() {
        return boardOneNumbers;
    }

    public void setBoardOneNumbers(List<String> boardOneNumbers) {
        this.boardOneNumbers = boardOneNumbers;
    }

    public List<String> getBoardTwoNumbers() {
        return boardTwoNumbers;
    }

    public void setBoardTwoNumbers(List<String> boardTwoNumbers) {
        this.boardTwoNumbers = boardTwoNumbers;
    }

    @Override
    public String toString() {
        return "SwissLotto{" +
                "boardOneNumbers=" + boardOneNumbers +
                ", boardTwoNumbers=" + boardTwoNumbers +
                ", id='" + id + '\'' +
                ", drawNumber=" + drawNumber +
                ", outcome='" + outcome + '\'' +
                '}';
    }
}
