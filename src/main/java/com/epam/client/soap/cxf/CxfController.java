package com.epam.client.soap.cxf;

import com.epam.client.soap.wsimport.Calculator;
import com.epam.client.soap.wsimport.CalculatorService;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CxfController {
    public void test() {
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//
//        factory.setServiceClass(Calculator.class);
//        factory.setAddress("http://localhost:8080/calc?wsdl");
//        factory.getInInterceptors().add(new LoggingInInterceptor());
//        factory.getOutInterceptors().add(new LoggingOutInterceptor());
//        Calculator calc = (Calculator) factory.create();
//        System.out.println(calc.add("5", "10"));

        CalculatorService service = new CalculatorService();
        service.getPorts();
    }
    public void oneMoreTest(){

    }
}
