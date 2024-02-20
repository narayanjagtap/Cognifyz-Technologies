import java.util.Scanner;

public class TemperatureConverter {
    
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("---------------------");
        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();
        
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);
        
        double convertedTemperature;
        if (unit == 'C') {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemperature);
        } else if (unit == 'F') {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemperature);
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }
        
    }
}
