package com.ProdigyInfoTech.Task.TemperatureConverter.Services;

import org.springframework.stereotype.Service;

import com.ProdigyInfoTech.Task.TemperatureConverter.Models.TemperatureConversion;

@Service
public class TemperatureConverterService {


    public TemperatureConversion convert(TemperatureConversion conversion) {
        double convertedTemperature;


        if (conversion.getFromUnit().equalsIgnoreCase(conversion.getToUnit())) {
            convertedTemperature = conversion.getTemperature();
        } else {
            switch (conversion.getFromUnit().toLowerCase()) {
            case "celsius":
                if (conversion.getToUnit().equalsIgnoreCase("fahrenheit")) {
                    convertedTemperature = (conversion.getTemperature() * 9/5) + 32;
                } else if (conversion.getToUnit().equalsIgnoreCase("kelvin")) {
                    convertedTemperature = conversion.getTemperature() + 273.15;
                } else {
                    throw new IllegalArgumentException("Invalid target unit. Please use 'Fahrenheit' or 'Kelvin'.");
                }
                break;

            case "fahrenheit":
                if (conversion.getToUnit().equalsIgnoreCase("celsius")) {
                    convertedTemperature = (conversion.getTemperature() - 32) * 5/9;
                } else if (conversion.getToUnit().equalsIgnoreCase("kelvin")) {
                    convertedTemperature = (conversion.getTemperature() - 32) * 5/9 + 273.15;
                } else {
                    throw new IllegalArgumentException("Invalid target unit. Please use 'Celsius' or 'Kelvin'.");
                }
                break;

            case "kelvin":
                if (conversion.getToUnit().equalsIgnoreCase("celsius")) {
                    convertedTemperature = conversion.getTemperature() - 273.15;
                } else if (conversion.getToUnit().equalsIgnoreCase("fahrenheit")) {
                    convertedTemperature = (conversion.getTemperature() - 273.15) * 9/5 + 32;
                } else {
                    throw new IllegalArgumentException("Invalid target unit. Please use 'Celsius' or 'Fahrenheit'.");
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid source unit. Please use 'Celsius', 'Fahrenheit', or 'Kelvin'.");
        }
        }


        conversion.setConvertedTemperature(convertedTemperature);
        conversion.addToHistory();
        return conversion;
    }
}
