package Final;

import java.util.List;

public interface CheckInSystem {
    /**
     * Checks in a vehicle and adds ticket info to both ticket lists
     */
    void inSystemStuff(List<Ticket>tickets, List<Ticket> ticketHistory);

    /**
     * Shows ticket info
     */
    void displayInfo();
}
