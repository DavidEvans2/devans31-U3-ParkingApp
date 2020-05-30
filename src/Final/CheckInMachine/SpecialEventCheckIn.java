package Final.CheckInMachine;

import Final.CheckInSystem;
import Final.Ticket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class SpecialEventCheckIn implements CheckInSystem {
    private Ticket newTicket;
    private Random random = new Random();
    private int TicketID = 1;

    @Override
    public void inSystemStuff(List<Ticket> tickets, List<Ticket> ticketHistory2) {
        for (Ticket ticket : ticketHistory2) {
            if (ticket.getID() == TicketID) {
                TicketID++;
            }
        }
        int entryTime = (random.nextInt(6) + 7);
        newTicket = new Ticket(TicketID, entryTime);
        tickets.add(newTicket);
        ticketHistory2.add(newTicket);
    }
    @Override
    public void displayInfo () {
        LocalTime entryTimeFormat = LocalTime.of(newTicket.getEntryTime(), 0);
        System.out.println("Now Printing Ticket. Be sure to make it visible in your car\n");
        System.out.println("Ticket Id: " + newTicket.getID() +  "\n" +
                "You entered the Parking Garage at " + entryTimeFormat.format(DateTimeFormatter.ofPattern("hh:mm a")));
    }
}