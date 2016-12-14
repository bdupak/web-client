package com.epam.client.soap.wsimport;

import com.epam.model.Response;
import com.epam.model.Result;
import com.epam.model.Summary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName resultQName =
            new QName("http://model.service.epam.com/", "result");
    private final static QName summaryQName =
            new QName("http://model.service.epam.com/", "summary");

    public ObjectFactory() {
    }

    public Result createResult() {
        return new Result();
    }

    public Summary createSummary() {
        return new Summary();
    }

    public Response createResponse() {
        return new Response();
    }

    @XmlElementDecl(namespace = "http://model.service.epam.com/",
            name = "result")
    public JAXBElement<Result> createResult(Result value) {
        return new JAXBElement<Result>(resultQName,
                Result.class, null, value);
    }

    @XmlElementDecl(namespace = "http://model.service.epam.com/",
            name = "summary")
    public JAXBElement<Summary> createSummary(Summary value) {
        return new JAXBElement<Summary>(summaryQName,
                Summary.class, null, value);
    }

}
