package Final;

import Final.Ticket;

import java.util.List;
public interface CheckOutSystem {

    /**
     *Checks Car out of system. Then updates the ticket lists accordingly
     */
    void outSystemStuff(List<Ticket>tickets, List<Ticket>tickets2);

    /**
     *Total number of people parked for a certain ticket type
     */
    int getVisitorTotal();

    /**
     * Displays ticket info
     */
    void displayInfo();
}