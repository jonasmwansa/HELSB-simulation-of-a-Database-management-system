/*

 *          NAME : Jonas Mwansa
 * 
 *          SIN  : 17118239
 *          
 *          DEPARTMENT: Computer Engineering
 * 
 *          Filename:  TemperatureConversion.java
 *          
 *          IDE used: visual studio code
 *          
 */

import java.util.Scanner;

public class TemperatureConversion
{
    public static void main(String args []) 
    {
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("Enter choice to perform: (-1 to exit)");
            System.out.println("[1].\tFind Temperature in celcius from fahnrenheit");
            System.out.println("[2].\tFind Temperature in fahnrenheit from celcius");
            System.out.print(">>");
            option = input.nextInt();

            System.out.println();
        
        switch (option)
        {
            case 1:

            System.out.print("Enter fahrenheit temperature:>> ");            
            System.out.printf("\nTemperature in celcius is: %.2f\n\n", celcius(input.nextDouble()));
            break;

            case 2:
            System.out.print("Enter the celcius temperature:>> ");
            System.out.printf("\nTemperature in fahnrenheits is: %.2f\n\n", fahrenheit(input.nextDouble()));
            break;
        }
    } while(option != -1);
}


    //get temperature in celcius
    private static double celcius(double fahrenheit)
    {
       return ( 5.0 / 9.0 ) * ( fahrenheit - 32);   
    } 

    //get temperature in fahnrenheit
    private static double fahrenheit(double celsius)
    {
        return ( 9.0 / 5.0 ) *  celsius + 32;
    }   

}