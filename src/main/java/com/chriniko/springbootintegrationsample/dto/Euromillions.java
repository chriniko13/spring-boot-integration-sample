package com.chriniko.springbootintegrationsample.dto;

import java.util.List;

public class Euromillions extends Ticket {

    private List<String> numbers;

    private String raffle;

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public String getRaffle() {
        return raffle;
    }

    public void setRaffle(String raffle) {
        this.raffle = raffle;
    }

    @Override
    public String toString() {
        return "Euromillions{" +
                "numbers=" + numbers +
                ", raffle='" + raffle + '\'' +
                ", id='" + id + '\'' +
                ", drawNumber=" + drawNumber +
                ", outcome='" + outcome + '\'' +
                '}';
    }
}
