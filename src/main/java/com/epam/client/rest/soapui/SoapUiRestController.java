package com.epam.client.rest.soapui;

import com.epam.reader.ReadValue;
import com.eviware.soapui.config.RestServiceConfig;
import com.eviware.soapui.config.impl.RestServiceConfigImpl;
import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.rest.RestService;
import com.eviware.soapui.impl.rest.RestServiceFactory;
import com.eviware.soapui.impl.rest.support.WadlImporter;
import com.eviware.soapui.impl.wadl.WadlDefinitionContext;
import com.eviware.soapui.impl.wadl.support.GeneratedWadlDefinitionLoader;
import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.teststeps.registry.RestRequestStepFactory;
import com.eviware.soapui.model.iface.Interface;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;



public class SoapUiRestController {
    public String getResponse(String url) throws XmlException, IOException, SoapUIException, ScriptException {
//        WadlDefinitionContext wadlDefinition = new WadlDefinitionContext(url);

//        WsdlProject project = new WsdlProject();
//        RestServiceFactory factory = new RestServiceFactory();
//        factory.createNew(project, "test");
//        RestService rest = new RestService(project,(RestServiceConfig)project.getConfig().addNewInterface().changeType( RestServiceConfig.type ));
//        rest.setWadlUrl(ReadValue.getValue("addUrl" + "2&10"));
//        GeneratedWadlDefinitionLoader wadl = new
//        RestService restService = wadlDefinition.getInterface();
//        System.out.println(restService.toString());

//        SoapUiRestClient client =
//        RestRequestStepFactory restRequestStepFactory = new RestRequestStepFactory();
//        WsdlProject project = new WsdlProject();
//        RestServiceConfig restServiceConfig = new RestServiceConfigImpl(SchemaType);

//
//        ScriptEngineManager factory = new ScriptEngineManager();
//        ScriptEngine engine = factory.getEngineByName("groovy");
//
//        String groovyCode = "import com.eviware.soapui.impl.wsdl.teststeps.registry.RestRequestStepFactory\n" +
//                "import com.eviware.soapui.impl.rest.RestMethod\n" +
//                "import com.eviware.soapui.impl.rest.RestResource\n" +
//                "import com.eviware.soapui.impl.rest.RestService\n" +
//                "import com.eviware.soapui.config.RestMethodConfig.Factory\n" +
//                "import com.eviware.soapui.config.RestResourceConfig\n" +
//                "import com.eviware.soapui.config.RestServiceConfig\n" +
//                "\n" +
//                "RestRequestStepFactory rest = new RestRequestStepFactory()\n" +
//                "\n" +
//                "def project = testRunner.testCase.testSuite.project\n" +
//                "def restServiceConfig = RestServiceConfig.Factory.newInstance()\n" +
//                "\n" +
//                "restServiceConfig.setType(\"restrequest\")\n" +
//                "RestService restService = new RestService(project, restServiceConfig)\n" +
//                "restService.setName(\"test\")\n" +
//                "\n" +
//                "RestResource restResource = restService.addNewResource(serviceName," +  url+")\n" +
//                "RestMethod restMethod = restResource.addNewMethod(\"POST\")\n" +
//                "\n" +
//                "rest.buildTestStep(testRunner.testCase, rest.createNewTestStep(restMethod, \"test\"), false)";
//
//        engine.eval(groovyCode);


        WsdlProject project = new WsdlProject();
        RestService service = (RestService) project.addNewInterface("REST Service", RestServiceFactory.REST_TYPE);
//        WadlImporter importer = new WadlImporter(service);
//        importer.initFromWadl(url);

        service.setWadlUrl(url);
        System.out.println(service.getWadlUrl());
        service.release();
        service.afterLoad();
        System.out.println(service.getInterfaceType());
        System.out.println(project.getInterfaceList().get(0));
        Interface interfaceSoap = project.getInterfaceList().get(0);
        //WsdlInterface iface = WsdlInterfaceFactory.importWsdl(project, wsdl, true)[0];

//        System.out.println(interfaceSoap);

        return null;
    }
}
