package com.chriniko.springbootintegrationsample.dto;

import java.util.List;

public class Output {

    private List<Pair> results;

    public List<Pair> getResults() {
        return results;
    }

    public void setResults(List<Pair> results) {
        this.results = results;
    }

    public static class Pair {
        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}
