package Final.CheckOutMachine;
import java.util.List;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import Final.CheckOutSystem;
import Final.MainMenu;
import Final.Ticket;

public class SpecialEventCheckOut implements CheckOutSystem {
    private LocalTime exitTimeFormat;
    private LocalTime entryTimeFormat;
    private Random random;
    private int specialEventCost = 20;
    private int eventCount = 0;
    private double eventTotal = 0.00;

    @Override
    public void outSystemStuff(List<Ticket> tickets, List<Ticket> tickets2) {
        System.out.println("Ticket Processing");
        try {
            for (int i = 0; i <= 2; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException ignore) {

        }
        for (Ticket ticket : tickets) {
            int eventLeaveTime = (random.nextInt(12) + 12);

            // formatting output
            exitTimeFormat = LocalTime.of(eventLeaveTime, 0);
            entryTimeFormat = LocalTime.of(ticket.getEntryTime(), 0);

            for (Ticket ticket2 : tickets2) {
                if (ticket.getID() == ticket2.getID()) {
                    ticket2.setCost(specialEventCost);
                }
            }
            eventTotal += specialEventCost;
            System.out.println("\nTime to pay!");
            System.out.println("You owe $" + specialEventCost);
            try {
                Thread.sleep(3000);
                System.out.println("Paid!");
            } catch (InterruptedException ignore) {
            }
            tickets.remove(ticket);
            eventCount++;
            break;
        }
    }

    @Override
    public double getSalesTotal(){
        return eventTotal;
    }

    @Override
    public int getVisitorTotal() {
        return eventCount;
    }

    @Override
    public void displayInfo() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.GarageLogo();
        System.out.println(
                "Receipt\n" +
                        "Hours Parked: " + entryTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                        " - " + exitTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")) +
                        "\nYou have paid: $" + specialEventCost);
    }
}