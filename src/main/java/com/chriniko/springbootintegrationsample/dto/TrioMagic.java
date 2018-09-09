package com.chriniko.springbootintegrationsample.dto;

import java.util.List;

public class TrioMagic extends Ticket {

    private List<String> numbers;

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "TrioMagic{" +
                "numbers=" + numbers +
                ", id='" + id + '\'' +
                ", drawNumber=" + drawNumber +
                ", outcome='" + outcome + '\'' +
                '}';
    }
}
