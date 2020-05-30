package Final;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import Final.CheckInMachine.CheckInPlan;
import Final.CheckOutMachine.CheckOutPlan;

public class Driver {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        List<Ticket> ticketFile = new ArrayList<>();
        MachinePlan checkInPlan = CheckInPlan.INSTANCE;
        MachinePlan checkOutPlan = CheckOutPlan.INSTANCE;
        CheckInSystem checkIn = checkInPlan.getInSystemType("CheckIn");
        CheckInSystem eventTick = checkInPlan.getInSystemType("SpecialEventCheckIn");
        CheckOutSystem hasTicketID = checkOutPlan.getOutSystemType("hasTicketID");
        CheckOutSystem lostTicket = checkOutPlan.getOutSystemType("Lost");
        CheckOutSystem checkOutEvent = checkOutPlan.getOutSystemType("SpecialEventCheckOut");
        MainMenu mainMenu = new MainMenu();
        double totalMade;
        TicketWriter tw = new TicketWriter();
        Scanner keyboard = new Scanner(System.in);
        boolean endOfDay = false;
        boolean backNForth = false;
        do {
            if (!backNForth) {
                mainMenu.GarageLogo();
                mainMenu.MainMenu();
                String doubleCheck = keyboard.nextLine();
                switch (doubleCheck) {
                    case "1":
                        mainMenu.CheckInMenu();
                        String checkInTime = keyboard.nextLine();
                        switch (checkInTime) {
                            case "1":
                                checkIn.inSystemStuff(tickets, ticketFile);
                                checkIn.displayInfo();
                                backNForth = true;
                                break;
                            case "2":
                                eventTick.inSystemStuff(tickets, ticketFile);
                                eventTick.displayInfo();
                                backNForth = true;
                                break;
                        }
                        break;
                    case "2":
                        System.out.println("We collected a total of $" + hasTicketID.getSalesTotal() + " from a whopping " + hasTicketID.getVisitorTotal() + "People!\n");
                        System.out.println("A total of $" + checkOutEvent.getSalesTotal() + "was reaped from " + checkOutEvent.getVisitorTotal() + " people attending events!");
                        System.out.println("And last but not least, we made $" + lostTicket.getSalesTotal() + " from " + lostTicket.getVisitorTotal() + " poor suckers that lost their parking stubs!");
                        totalMade = (hasTicketID.getSalesTotal() + checkOutEvent.getSalesTotal() + lostTicket.getSalesTotal());
                        System.out.println("We made a grand total of $" + totalMade + "overall!!!");

                        try {
                            tw.writeToFile(ticketFile);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        endOfDay = true;
                        break;
                }
            } else {
                mainMenu.GarageLogo();
                mainMenu.CheckoutMenu();
                String lastSwitch = keyboard.nextLine();

                switch (lastSwitch) {
                    case "1":
                        hasTicketID.outSystemStuff(tickets, ticketFile);
                        hasTicketID.displayInfo();
                        backNForth = false;
                        break;
                    case "2":
                        checkOutEvent.outSystemStuff(tickets, ticketFile);
                        checkOutEvent.displayInfo();
                        backNForth = false;
                    case "3":
                        lostTicket.outSystemStuff(tickets, ticketFile);
                        lostTicket.displayInfo();
                        backNForth = false;
                        break;
                }
            }
        } while (!endOfDay);
    }
}