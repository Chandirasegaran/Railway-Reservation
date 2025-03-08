/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railway;

/**
 *
 * @author Chandirasegaran
 */
public class Ticket {
    
    static private int id=1;
    private int ticketId;
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private String berthAllocated;
    
    public static void setId(int id) {
        Ticket.id = id;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public void setBerthAllocated(String berthAllocated) {
        this.berthAllocated = berthAllocated;
    }

    public static int getId() {
        return id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public String getBerthAllocated() {
        return berthAllocated;
    }

    Ticket(int ticketId,String name,int age,String gender,String berthPreference,String berthAllocated){
        
        id++;
        this.ticketId = ticketId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
        this.berthAllocated = berthAllocated;
    }
    
}
