package com.epam;

import com.epam.reader.ReadValue;
import org.testng.annotations.DataProvider;

public class ServiceTestData {

    @DataProvider(name="getDataForCalculator")
    public static Object[][] getDataForCalculator(){
        return new Object[][]{
                {ReadValue.getValue("firstValue"), ReadValue.getValue("secondValue")}
        };
    }

    @DataProvider(name="getDataForPercentageOperation")
    public static Object[][] getDataForPercentageOperation(){
        return new Object[][]{
                {ReadValue.getValue("firstValue"), ReadValue.getValue("percentage")}
        };
    }

}
