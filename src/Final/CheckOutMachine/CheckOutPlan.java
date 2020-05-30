package Final.CheckOutMachine;

import Final.CheckInSystem;
import Final.CheckOutSystem;
import Final.MachinePlan;

public enum CheckOutPlan implements MachinePlan {
    INSTANCE;
    CheckOutPlan(){
        try
        {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex)
        {
        }
    }

    @Override
    public CheckInSystem getInSystemType(String type) {

        return null;
    }

    @Override
    public CheckOutSystem getOutSystemType(String type2) {
        switch (type2) {
            case "ticketID":
                return new TicketCheckOut();
            case "Lost":
                return new CheckOutNoTicket();
            case "Special":
                return new SpecialEventCheckOut();
            default:
                return null;
        }
    }
}
