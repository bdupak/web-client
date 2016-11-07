package com.epam.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "result", propOrder = {"result"})
public class Result {

    protected Double result;

    public Double getResult() {
        return result;
    }

    public void setResult(Double value) {
        this.result = value;
    }

    public Double getValue(){
        return result;
    }
}
