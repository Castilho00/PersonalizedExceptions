package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = input.nextInt();
        System.out.print("Check-in date: ");
        Date checkIn = sdf.parse(input.next());
        System.out.print("Check-out date: ");
        Date checkOut = sdf.parse(input.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter the data to update the reservation:\n");
            System.out.print("Check-in date: ");
            checkIn = sdf.parse(input.next());
            System.out.print("Check-out date: ");
            checkOut = sdf.parse(input.next());


            String error = reservation.updateDates(checkIn, checkOut); //atribui a resposta que virá do método
            if (error != null){
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println(reservation);
            }
        }

        input.close();
    }

}