package Final.CheckOutMachine;
import Final.Ticket;
import java.util.List;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Final.CheckOutSystem;
import Final.MainMenu;

public class TicketCheckOut implements CheckOutSystem {
    private Scanner keyboard = new Scanner(System.in);
    private LocalTime entryTimeFormat;
    private LocalTime exitTimeFormat;
    private Random random = new Random();
    private boolean ticketsFound;
    private int parkingCost = 0;
    private int totalTicketCount = 0;
    private double totalMoney = 0.00;


    public TicketCheckOut() {
    }

    @Override
    public void outSystemStuff(List<Ticket> tickets, List<Ticket> tickets2) {
        do{
            System.out.println("Please Enter Your TicketID:");
            String ticketID = keyboard.nextLine();
            int ID = Integer.parseInt(ticketID);
            for (Ticket ticket: tickets){
                if (ID == ticket.getID()){
                    ticketsFound = true;
                    parkingCost = 5;
                    //Time output format
                    int exitTime = (random.nextInt(12) + 11);
                    int timeDiff = (exitTime - ticket.getEntryTime());

                    if (timeDiff > 3){
                        parkingCost += (timeDiff - 3);
                    }else if (parkingCost > 15)
                    {
                        parkingCost = 15;
                    }

                    for (Ticket ticket1: tickets2){
                        if (ID == ticket1.getID()){
                            ticket1.setCost(parkingCost);
                        }
                    }
                    totalMoney +=parkingCost;
                    System.out.println("Heres what ya owe.... $" + parkingCost);
                    try {
                        Thread.sleep(3000);
                        System.out.println("Transaction Completed");
                    } catch (InterruptedException ignore) {
                    }
                    tickets.remove(ticket);
                    totalTicketCount++;
                    break;
                }else {
                    ticketsFound = false;
                    System.out.println("Hmmm, seems like there isn't a ticket with that ID.\n" +
                            " Please try again");
                }
            }
        } while (!ticketsFound);
    }

    @Override
    public double getSalesTotal() {
        return totalMoney;
    }

    @Override
    public int getVisitorTotal() {
        return totalTicketCount;
    }

    @Override
    public void displayInfo() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.GarageLogo();
        System.out.println(
                "============Receipt===========\n" +
                        "Hours Parked: " + entryTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                        " - " + exitTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                        "\nYou have paid: $" + parkingCost + ".\n " + "Have a nice day!");
    }
}
