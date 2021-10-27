/*

 *          NAME : Jonas Mwansa
 *
 *          SIN  : 17118239
 *
 *          DEPARTMENT: Computer Engineering
 *
 *          Filename:  ParkingCharges.java
 *
 *          IDE used: visual studio code
 *
 */
import java.util.Scanner;

public class ParkingCharges
{
    private static final double baseCharge = 2.00;
    private static final double fixedHourlyCharge = 0.50;
    private static final double maximumCharge = 10.00;

    private static double total = 0.0f;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        double time = 0.0f;

        System.out.println("Threshold charge for parking on a slot is K2.00");
        do
        {
            System.out.print("\nEnter the hours parked (-1 to exit): ");
             time = input.nextDouble();

            if(time > 0)
                System.out.printf("Charges are : K %.2f\n", calculateCharges(time));

        } while(time!=-1); //we set the sentinel value

        System.out.printf("\n\nTotal charges for the day are :K %.2f\n", total);

    }


    public static double calculateCharges(double time)
    {
        if(time > 3.0)
        {
            // we use Math.ceil to ensure an increase only for each additional hour
            double fee = baseCharge + (fixedHourlyCharge * Math.ceil(time - 3.0));

            // return the minimum of charge and maximum charge to ensure daily cost
            // exceed the specification

            total += Math.min(fee, maximumCharge);
            return Math.min(fee, maximumCharge);
        }
        
        //if time hasn't exceeded the threshold 3 hours then increment total by the base charge of K 2.00
        else
        {
            total += baseCharge;
            return baseCharge;
        }
    }
}
