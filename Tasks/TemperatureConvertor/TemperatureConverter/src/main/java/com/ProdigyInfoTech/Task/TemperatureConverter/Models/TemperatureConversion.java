package TemperatureConvertor.TemperatureConverter.src.main.java.com.ProdigyInfoTech.Task.TemperatureConverter.Models;

public class TemperatureConversion {

    private double temperature;
    private String fromUnit;
    private String toUnit;
    private double convertedTemperature;

    // Getters and Setters

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public double getConvertedTemperature() {
        return convertedTemperature;
    }

    public void setConvertedTemperature(double convertedTemperature) {
        this.convertedTemperature = convertedTemperature;
    }
}

