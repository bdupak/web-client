package com.epam.model;

public class DataHolder {

    private static DataHolder instance = new DataHolder();
    private String firstValue;
    private String secondValue;
    private String percentage;

    private DataHolder() {
    }

    public static DataHolder getInstance(){
        return instance;
    }

    public String getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public String getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "DataHolder{" +
                "firstValue='" + firstValue + '\'' +
                ", secondValue='" + secondValue + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}
