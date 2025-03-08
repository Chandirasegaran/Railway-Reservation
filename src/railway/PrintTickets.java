package railway;


public class PrintTickets extends BookTicket {

    public void printBookedTickets() {
        if(upperBerthCount==0 && middleBerthCount==0 && lowerBerthCount==0 && racCount==0 && waitingListCount==0){
            System.out.println("No Tickets Booked Yet");
            return;
        }
        System.out.println("Booked Tickets");
        System.out.println("Ticket ID\tName\tAge\tGender\tBerth Allocated");
        for (Ticket t : upperBerth) {
            if (t != null && t.getTicketId() != 0) {
                System.out.println(t.getTicketId() + "\t" + t.getName() + "\t" + t.getAge() + "\t" + t.getGender()
                        + "\t" + t.getBerthAllocated());
            }
        }
        for (Ticket t : middleBerth) {
            if (t != null && t.getTicketId() != 0) {
                System.out.println(t.getTicketId() + "\t" + t.getName() + "\t" + t.getAge() + "\t" + t.getGender()
                        + "\t" + t.getBerthAllocated());
            }
        }
        for (Ticket t : lowerBerth) {
            if (t != null && t.getTicketId() != 0) {
                System.out.println(t.getTicketId() + "\t" + t.getName() + "\t" + t.getAge() + "\t" + t.getGender()
                        + "\t" + t.getBerthAllocated());
            }
        }
        for (Ticket t : rac) {
            if (t != null && t.getTicketId() != 0) {
                System.out.println(t.getTicketId() + "\t" + t.getName() + "\t" + t.getAge() + "\t" + t.getGender()
                        + "\t" + t.getBerthAllocated());
            }
        }
        for (Ticket t : waitingList) {
            if (t != null && t.getTicketId() != 0) {
                System.out.println(t.getTicketId() + "\t" + t.getName() + "\t" + t.getAge() + "\t" + t.getGender()
                        + "\t" + t.getBerthAllocated());
            }
        }
        if(upperBerthCount==0 && middleBerthCount==0 && lowerBerthCount==0 && racCount==0 && waitingListCount==0){
            System.out.println("No Tickets Booked Yet");
            return;
        }
        System.out.println("Upper Berth Tickets Booked: " + upperBerthCount);
        System.out.println("Middle Berth Tickets Booked: " + middleBerthCount);
        System.out.println("Lower Berth Tickets Booked: " + lowerBerthCount);
        System.out.println("RAC Tickets Booked: " + racCount);
        System.out.println("Waiting List Tickets Booked: " + waitingListCount);
        System.out.println("Total Tickets Booked: "
                + (upperBerthCount + middleBerthCount + lowerBerthCount + racCount + waitingListCount));

    }

    public void printAvailableTickets() {
        System.out.println("Available Tickets");
        System.out.println("No of Upper Berth Tickets Available: " + (maxUpperMiddleLowerBerth - upperBerthCount));
        System.out.println("No of Middle Berth Tickets Available: " + (maxUpperMiddleLowerBerth - middleBerthCount));
        System.out.println("No of Lower Berth Tickets Available: " + (maxUpperMiddleLowerBerth - lowerBerthCount));
        System.out.println("No of RAC Tickets Available: " + (maxRac - racCount));
        System.out.println("No of Waiting List Tickets Available: " + (maxWaitingList - waitingListCount));
        System.out.println("Total Tickets Available: "
                + ((maxRac+maxWaitingList+(3*maxUpperMiddleLowerBerth)) - (upperBerthCount + middleBerthCount + lowerBerthCount + racCount + waitingListCount)));
    }

}