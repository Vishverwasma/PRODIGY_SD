package com.ProdigyInfoTech.Task.TemperatureConverter.Models;

import java.util.HashMap;

public class TemperatureConversion {

    private double temperature;
    private String fromUnit;
    private String toUnit;
    private double convertedTemperature;
    private static HashMap<String,String> fromHistory = new HashMap<>();
    private static HashMap<String,String> toHistory = new HashMap<>();

    // Getters and Setters

    public void addToHistory() {
    	fromHistory.put(temperature + " " + fromUnit, convertedTemperature + " " + toUnit);
        toHistory.put(temperature + " " + fromUnit, convertedTemperature + " " + toUnit);
    }
    
    public static void clearHistory() {
        fromHistory.clear();
        toHistory.clear();
    }

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

	public static HashMap<String, String> getFromHistory() {
		return fromHistory;
	}

	public static void setFromHistory(HashMap<String, String> fromHistory) {
		TemperatureConversion.fromHistory = fromHistory;
	}

	public static HashMap<String, String> getToHistory() {
		return toHistory;
	}

	public static void setToHistory(HashMap<String, String> toHistory) {
		TemperatureConversion.toHistory = toHistory;
	}

	public TemperatureConversion() {
		super();
	}

	public TemperatureConversion(double temperature, String fromUnit, String toUnit, double convertedTemperature) {
		super();
		this.temperature = temperature;
		this.fromUnit = fromUnit;
		this.toUnit = toUnit;
		this.convertedTemperature = convertedTemperature;
	}
    
}

