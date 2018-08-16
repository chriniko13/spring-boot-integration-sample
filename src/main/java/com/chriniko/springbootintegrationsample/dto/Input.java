package com.chriniko.springbootintegrationsample.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Input implements Serializable {

    private String someString;
    private Boolean someBoolean;
    private Double someDouble;

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
}
