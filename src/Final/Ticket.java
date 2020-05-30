package Final;

import java.io.Serializable;

public class Ticket implements Serializable {
    private int ticketID;
    private int ticketCost;
    private int entryTime;

    /*
    Making CheckIn Tickets
     */
    public Ticket(int id, int enterTime)
    {
        this.ticketID = id;
        this.entryTime = enterTime;
    }
    /*
    Updating costs for file
     */
    public Ticket(int ticketID, int entryTime, int ticketCost)
    {
        this.ticketID= ticketID;
        this.entryTime = entryTime;
        this.ticketCost = ticketCost;
    }

    /*
    Returns ticketID
     */
    public int getID() {
        return ticketID;
    }
    /*
    Returns entryTime for ticket
     */
    public int getEntryTime() {
        return entryTime;
    }
    /*
    Sets the ticketCost
     */
    public void setCost(int ticketCost) {
        this.ticketCost = ticketCost;
    }
    /*
    Returns the ticketCost
     */
    public int getCost() {
        return ticketCost;
    }
}