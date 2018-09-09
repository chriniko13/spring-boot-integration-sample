package com.chriniko.springbootintegrationsample.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Input implements Serializable {

    private String someString;
    private Boolean someBoolean;
    private Double someDouble;

    public Input(String someString, Boolean someBoolean, Double someDouble) {
        this.someString = someString;
        this.someBoolean = someBoolean;
        this.someDouble = someDouble;
    }

    public Input() {
    }

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public Boolean getSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(Boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public Double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(Double someDouble) {
        this.someDouble = someDouble;
    }

    @Override
    public String toString() {
        return "Input{" +
                "someString='" + someString + '\'' +
                ", someBoolean=" + someBoolean +
                ", someDouble=" + someDouble +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Input input = (Input) o;
        return Objects.equals(someString, input.someString) &&
                Objects.equals(someBoolean, input.someBoolean) &&
                Objects.equals(someDouble, input.someDouble);
    }

    @Override
    public int hashCode() {

        return Objects.hash(someString, someBoolean, someDouble);
    }
}
