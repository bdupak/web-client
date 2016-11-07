package com.epam.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {"summary", "result"})
public class Response {

    @XmlElement(required = true, namespace = "http://model.service.epam.com/")
    private Summary summary;
    @XmlElement(required = true, namespace = "http://model.service.epam.com/")
    private Result result;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary value) {
        this.summary = value;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result value) {
        this.result = value;
    }

}