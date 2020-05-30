package Final.CheckOutMachine;
import java.util.List;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import Final.Ticket;
import Final.CheckOutSystem;
import Final.MainMenu;
public class CheckOutNoTicket implements CheckOutSystem{
    private LocalTime entryTimeFormat;
    private LocalTime exitTimeFormat;
    private Random random = new Random();
    private int lostTicketCost = 25;
    private int lostTicketCount = 0;
    private double totalLostMoney = 0.00;

    @Override
    public void outSystemStuff(List<Ticket> tickets, List<Ticket>tickets2){
        System.out.println("Whoops! Looks like you lost your ticket.\n");
        try {
            for (int i = 0; i <= 2; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException ingore) {

        }
        for (Ticket ticket : tickets){
            int lostTime = (random.nextInt(12)+ 12);

            exitTimeFormat = LocalTime.of(lostTime, 0);
            entryTimeFormat = LocalTime.of(ticket.getEntryTime(),0);

            /**
             * Cost of losing your ticket
             */

            for (Ticket ticket2: tickets2){
                if (ticket.getID() == ticket2.getID()){
                    ticket2.setCost(lostTicketCost);
                }
            }
            totalLostMoney += lostTicketCost;
            System.out.println("Welp, ya lost your ticket. Unfortunately that's gonna cost ya $" + lostTicketCost + ".");
            try {
                for (int i = 0; i <= 2; i++) {
                    Thread.sleep(1000);
                    System.out.print(".");
                }
            } catch (InterruptedException ingore) {
                System.out.println("Nicely done Mate! You owe us $" + lostTicketCost);
                try {
                    Thread.sleep(3000);
                    System.out.println("Transaction Complete");
                } catch (InterruptedException ignore) {
                }
            }
            tickets.remove(ticket);
            lostTicketCount++;
            break;
        }
    }

    @Override
    public double getSalesTotal() {
        return totalLostMoney;
    }
    @Override
    public int getVisitorTotal() { return getVisitorTotal(); }
    @Override
    public void displayInfo() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.GarageLogo();
        System.out.println(
                "============Receipt============\n" +
                        "Hours Parked: " + entryTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                        " - " + exitTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                        "\nYou have paid: $" + lostTicketCost + ".\n " + "Have a nice day!");
    }
}
