package Final;
import java.util.List;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TicketWriter {

    private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private Date today = Calendar.getInstance().getTime();
    private String dateReport = dateFormat.format(today);
    private String fileDate = dateReport;

    /*
     Adds Tickets to the tickets.txt file, with time stamps.
     */

    public void writeToFile(List<Ticket> tickets) throws FileNotFoundException, IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("tickets.txt", true));
        out.write("\nTickets from\n" +
                fileDate+
                "\n----------------------\n");
        for (Ticket ticket : tickets) {
            out.write("Ticket ID #" + ticket.getID() + ", Cost: " + ticket.getCost() + "\n");
        }
        out.close();
    }
}