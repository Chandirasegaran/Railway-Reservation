package railway;
/**
 *
 * @author Chandirasegaran
 */

public class CancelTicket extends BookTicket {

    public void cancelTicket(int ticketId, String name) {

        int ticketCancelledFlag = 0;

        for (Ticket t : upperBerth) {
            if (t != null && t.getTicketId() == ticketId && t.getName().equals(name)) {
                t.setTicketId(0);
                t.setName("");
                t.setAge(0);
                t.setGender("");
                t.setBerthPreference("");
                t.setBerthAllocated("");
                System.out.println("Ticket Cancelled Successfully from Upper Berth");
                ticketCancelledFlag = 1;
                upperBerthCount--;
                transferTicketFromRacToConfirmed("upper");
                transferTicketFromWaitingListToRac();
                break;
            }
        }
        for (Ticket t : middleBerth) {
            if (t != null && t.getTicketId() == ticketId && t.getName().equals(name)) {
                t.setTicketId(0);
                t.setName("");
                t.setAge(0);
                t.setGender("");
                t.setBerthPreference("");
                t.setBerthAllocated("");
                System.out.println("Ticket Cancelled Successfully from Middle Berth");
                ticketCancelledFlag = 1;
                middleBerthCount--;
                transferTicketFromRacToConfirmed("middle");
                transferTicketFromWaitingListToRac();
                break;
            }
        }
        for (Ticket t:lowerBerth){
            if (t != null && t.getTicketId() == ticketId && t.getName().equals(name)) {
                t.setTicketId(0);
                t.setName("");
                t.setAge(0);
                t.setGender("");
                t.setBerthPreference("");
                t.setBerthAllocated("");
                System.out.println("Ticket Cancelled Successfully from Lower Berth");
                ticketCancelledFlag = 1;
                lowerBerthCount--;
                transferTicketFromRacToConfirmed("lower");
                transferTicketFromWaitingListToRac();
                break;
            }
        }
        for (Ticket t:rac){
            if (t != null && t.getTicketId() == ticketId && t.getName().equals(name)) {
                t.setTicketId(0);
                t.setName("");
                t.setAge(0);
                t.setGender("");
                t.setBerthPreference("");
                t.setBerthAllocated("");
                System.out.println("Ticket Cancelled Successfully from RAC");
                ticketCancelledFlag = 1;
                racCount--;
                transferTicketFromWaitingListToRac();
                break;
            }
        }
        for (Ticket t:waitingList){
            if (t != null && t.getTicketId() == ticketId && t.getName().equals(name)) {
                t.setTicketId(0);
                t.setName("");
                t.setAge(0);
                t.setGender("");
                t.setBerthPreference("");
                t.setBerthAllocated("");
                System.out.println("Ticket Cancelled Successfully from RAC");
                transferTicketFromWaitingListToRac();
                waitingListCount--;
                ticketCancelledFlag = 1;
                break;
            }
        }
        if (ticketCancelledFlag == 0) {
            System.out.println("Ticket not found, Verify the details and try again");
        }

    }

    private void transferTicketFromRacToConfirmed(String availableBerth) {
        Ticket t = rac.poll();
        if (t != null) {
            confirmBooking(t.getName(), t.getAge(), t.getGender(), availableBerth);
            racCount--;
        }       
    }

    private void transferTicketFromWaitingListToRac() {
        Ticket t = waitingList.poll();
        if (t != null) {
            booking(t.getName(), t.getAge(), t.getGender(), "rac","no");
            waitingListCount--;            
        }  
    }

}
