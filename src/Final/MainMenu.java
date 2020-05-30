package Final;

public class MainMenu {
    /*
    Shows Garage Name
     */
    public void GarageLogo(){
        System.out.println("============================\n");
        System.out.println("Best Value Parking Garage");
    }
    /*
     Shows main Check In/ Check Out Menu options
     */
    public void MainMenu(){
        System.out.println("1. Wanna Check In?");
        System.out.println("2. Or Check Out?");
        System.out.print("=>");
    }
    /*
    Shows Ticket options. Normal Check In, or Event Check In
     */
    public void CheckInMenu(){
        System.out.println("What kind of ticket do you need?\n" +
                "--------------------------------");
        System.out.println("1. Regular Check In\n");
        System.out.println("2. Special Event Ticket");
        System.out.print("=>");
    }
    /*
    Shows Checkout options
     */
    public void CheckoutMenu(){
        System.out.println("What checkout option do ya choose?\n" +
                "----------------------------------\n");
        System.out.println("1. Normal Checkout (w/Ticket)\n");
        System.out.println("2. Special Event Ticket");
        System.out.println("3. Lost Ticket");
        System.out.print("=>");
    }
}
