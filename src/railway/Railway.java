/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package railway;

import java.util.Scanner;

/**
 *
 * @author Chandirasegaran
 * 
 *         Write an application for booking railway ticket reservation system.
 *         The application should have four functionalities.
 * 
 *         Book
 *         Cancel
 *         Print booked tickets (details with summary)
 *         Print available tickets (details with summary)
 *         Conditions for booking:
 * 
 *         There are a total of 63 berths for 63 confirmed tickets, 9 berths for
 *         18 RAC tickets and 10 tickets in waiting-list. If the waiting-list
 *         ticket count goes above 10, print as ‘No tickets available’. The
 *         following passenger details should be obtained from the user.
 * 
 *         Name
 *         Age
 *         Gender
 *         Berth Preference
 *         The tickets should not be allocated for children below age 5.But,
 *         their details should be stored. Lower berth should be allocated for
 *         persons whose age is above 60 and ladies with children if available.
 *         Side-lower berths should be allocated for RAC passengers.
 * 
 *         Conditions for cancelling:
 * 
 *         Whenever a ticket is cancelled, a ticket from RAC should be confirmed
 *         and a waiting-list ticket should move to RAC.
 * 
 *         Conditions for printing booked tickets:
 * 
 *         Print all the tickets that are filled along with the passenger
 *         details and at the end, print the total number of tickets that are
 *         filled.
 * 
 *         Conditions for printing available tickets:
 * 
 *         Print all the tickets that are unoccupied and at the end, print the
 *         total number of tickets that are unoccupied.
 */
public class Railway {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************");

        System.out.println("Welcome to Railway Reservation System");
        while (true) {
            System.out.println("**************************************");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Print Booked Tickets");
            System.out.println("4. Print Available Tickets");
            System.out.println("5. Exit");
            System.out.println("**************************************");
            System.out.println("Enter your choice:");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    
                    BookTicket bookTicket = new BookTicket();
                    if(!bookTicket.ticketAvailable()){
                        System.out.println("No Tickets Available");
                        break;
                    }
                    System.out.println("Enter the Name:");
                    String name = input.nextLine();

                    System.out.println("Enter the Age:");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.println("Choose Gender \n1. Male\n2. Female");
                    int genderChoice = input.nextInt();
                    String gender;
                    if (genderChoice == 1) {
                        gender="male";
                       
                    } else {
                        gender="female";
                    }
                    System.out.println("Choose Berth Preference \n1. Upper\n2. Middle\n3. Lower");
                    int berthChoice = input.nextInt();
                    String berthPreference;
                    if (berthChoice == 1) {
                        berthPreference="upper";
                    } else if (berthChoice == 2) {
                        berthPreference="middle";
                    } else {
                        berthPreference="lower";
                    }
                    System.out.println("Have you any children below 5 years? \n1. Yes\n2. No");
                    int childChoice = input.nextInt();
                    String hasChild = "no";
                    if (childChoice == 1) {
                        hasChild = "yes";
                    }
                    System.out.println("**************************************");

                    if (bookTicket.booking(name,age,gender,berthPreference,hasChild)){
                        System.out.println("Ticket Booked Successfully, Enjoy your Journey");
                    } else {
                        System.out.println("Ticket Booking Failed, Please try again");
                    }
                    
                    break;
                case 2:
                    CancelTicket cancelTicket = new CancelTicket();
                    System.out.println("Enter the Ticket ID:");
                    int ticketId = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter the Name:");
                    String name1 = input.nextLine();
                    System.out.println("**************************************");

                    cancelTicket.cancelTicket(ticketId, name1);
                    break;
                case 3:
                    PrintTickets printTickets = new PrintTickets();
                    System.out.println("**************************************");

                    printTickets.printBookedTickets();
                    break;
                case 4:
                    PrintTickets printTickets1 = new PrintTickets();
                    System.out.println("**************************************");

                    printTickets1.printAvailableTickets();
                    break;
                case 5:
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

}
