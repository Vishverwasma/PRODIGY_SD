package TemperatureConversionTask;

import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Float> f = new ArrayList<Float>();
        ArrayList<Float> c = new ArrayList<Float>();
        ArrayList<Float> k = new ArrayList<Float>();
        int choice = 1;
        do{

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        switch (unit) {
            case 'C':
                c.add((float)temperature);
                convertFromCelsius(temperature,f,k);
                break;
            case 'F':
            f.add((float)temperature);
                convertFromFahrenheit(temperature,c,k);
                break;
            case 'K':
            k.add((float)temperature);
                convertFromKelvin(temperature,f,c);
                break;
            default:
                System.out.println("Invalid unit. Please enter C, F, or K.");
                break;
        }
        System.out.println("What do you want to do : 1. Convert , 2. Nothing");

        choice = scanner.nextInt();
        }while(choice == 1);

        System.out.println("Okay! Had Fun Converting temperatures , Hope You too had fun");
        System.out.println("So in total , The Conversions made for record are : ");
        System.out.println(" Fahrenheit - Celcius - Kelvin");
        for(int i = 0 ; i < f.size() ; i++){
            System.out.println(f.get(i) + " - " + c.get(i) + " - " + k.get(i));
        }
        scanner.close();
    }

    public static void convertFromCelsius(double celsius,ArrayList<Float> f,ArrayList<Float> k) {
        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;
        f.add((float)fahrenheit);
        k.add((float)kelvin);
        System.out.printf("Celsius: %.2f°C\n", celsius);
        System.out.printf("Fahrenheit: %.2f°F\n", fahrenheit);
        System.out.printf("Kelvin: %.2f K\n", kelvin);
    }

    public static void convertFromFahrenheit(double fahrenheit,ArrayList<Float> c,ArrayList<Float> k) {
        double celsius = (fahrenheit - 32) * 5/9;
        double kelvin = celsius + 273.15;
        c.add((float)celsius);
        k.add((float)kelvin);
        System.out.printf("Fahrenheit: %.2f°F\n", fahrenheit);
        System.out.printf("Celsius: %.2f°C\n", celsius);
        System.out.printf("Kelvin: %.2f K\n", kelvin);
    }

    public static void convertFromKelvin(double kelvin,ArrayList<Float> f,ArrayList<Float> c) {
        double celsius = kelvin - 273.15;
        double fahrenheit = (celsius * 9/5) + 32;
        c.add((float)celsius);
        f.add((float)fahrenheit);
        System.out.printf("Kelvin: %.2f K\n", kelvin);
        System.out.printf("Celsius: %.2f°C\n", celsius);
        System.out.printf("Fahrenheit: %.2f°F\n", fahrenheit);
    }
}
