package com.epam;

import com.epam.chooser.ClientType;
import com.epam.chooser.ServiceSelector;
import com.epam.chooser.ServiceType;
import com.epam.client.Client;
import com.epam.model.DataHolder;
import com.epam.reader.ReadValue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorServiceTest {
    private ServiceSelector selector;
    private Client client;
    private DataHolder data = DataHolder.getInstance();

    @BeforeClass
    public void init() {
        selector = new ServiceSelector();
        client = selector.getService(ServiceType.SOAP, ClientType.SOAP_UI);
    }

    @Test(dataProvider = "getDataForCalculator",
            dataProviderClass = ServiceTestData.class)
    public void addTest(String firstValue, String secondValue) {
        setData(firstValue, secondValue);
        assertEquals(client.add(),
                client.getDouble(ReadValue.getValue("addResult")));
    }

    @Test(dataProvider = "getDataForCalculator",
            dataProviderClass = ServiceTestData.class)
    public void subtractTest(String firstValue, String secondValue) {
        setData(firstValue, secondValue);
        assertEquals(client.subtract(),
                client.getDouble(ReadValue.getValue("subtractResult")));
    }

    @Test(dataProvider = "getDataForCalculator",
            dataProviderClass = ServiceTestData.class)
    public void divideTest(String firstValue, String secondValue) {
        setData(firstValue, secondValue);
        assertEquals(client.divide(),
                client.getDouble(ReadValue.getValue("divideResult")));
    }

    @Test(dataProvider = "getDataForCalculator",
            dataProviderClass = ServiceTestData.class)
    public void multiplyTest(String firstValue, String secondValue) {
        setData(firstValue, secondValue);
        assertEquals(client.multiply(),
                client.getDouble(ReadValue.getValue("multiplyResult")));
    }

    @Test(dataProvider = "getDataForPercentageOperation",
            dataProviderClass = ServiceTestData.class)
    public void percentTest(String firstValue, String secondValue) {
        data.setFirstValue(firstValue);
        data.setPercentage(secondValue);
        assertEquals(client.percentage(),
                client.getDouble(ReadValue.getValue("percentageResult")));
    }

    private void setData(String firstValue, String secondValue){
        data.setFirstValue(firstValue);
        data.setSecondValue(secondValue);
    }
}
