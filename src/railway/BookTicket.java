/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railway;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Chandirasegaran
 */

public class BookTicket {

    Scanner input = new Scanner(System.in);

    static private int ticketId = 1;
    static protected Ticket[] upperBerth = new Ticket[21];
    static protected Ticket[] middleBerth = new Ticket[21];
    static protected Ticket[] lowerBerth = new Ticket[21];
    static protected Queue<Ticket> rac = new LinkedList<Ticket>();
    static protected Queue<Ticket> waitingList = new LinkedList<Ticket>();

    static protected int upperBerthCount = 0;
    static protected int middleBerthCount = 0;
    static protected int lowerBerthCount = 0;
    static protected int racCount = 0;
    static protected int waitingListCount = 0;
    // For testing purpose
    // static protected int maxUpperMiddleLowerBerth = 2;
    // static protected int maxRac = 1;
    // static protected int maxWaitingList = 1;
    static protected int maxUpperMiddleLowerBerth = 21;
    static protected int maxRac = 18;
    static protected int maxWaitingList = 10;

    public boolean ticketAvailable() {
        if (upperBerthCount == maxUpperMiddleLowerBerth && middleBerthCount == maxUpperMiddleLowerBerth
                && lowerBerthCount == maxUpperMiddleLowerBerth && racCount == maxRac
                && waitingListCount == maxWaitingList) {
            return false;
        }
        return true;
    }

    public boolean confirmBooking(String name, int age, String gender, String berthPreference) {
        if (berthPreference.equals("lower")) {
            lowerBerth[lowerBerthCount] = new Ticket(ticketId, name, age, gender, berthPreference, "Lower Berth");
            lowerBerthCount++;
            ticketId++;
            System.out.println("Hi " + name + " Your Ticket booked successfully on Lower Berth");
            return true;
        } else if (berthPreference.equals("middle")) {
            middleBerth[middleBerthCount] = new Ticket(ticketId, name, age, gender, berthPreference, "Middle Berth");
            middleBerthCount++;
            ticketId++;
            System.out.println("Hi " + name + " Your Ticket booked successfully on Middle Berth");
            return true;
        } else if (berthPreference.equals("upper")) {
            upperBerth[upperBerthCount] = new Ticket(ticketId, name, age, gender, berthPreference, "Upper Berth");
            upperBerthCount++;
            ticketId++;
            System.out.println("Hi " + name + " Your Ticket booked successfully on Upper Berth");
            return true;
        } else if (berthPreference.equals("rac")) {
            rac.add(new Ticket(ticketId, name, age, gender, berthPreference, "RAC"));
            racCount++;
            ticketId++;
            System.out.println("Hi " + name + " Your Ticket booked successfully on RAC");
            return true;
        } else if (berthPreference.equals("waitingList")) {
            waitingList.add(new Ticket(ticketId, name, age, gender, berthPreference, "Waiting List"));
            waitingListCount++;
            ticketId++;
            System.out.println("Hi " + name + " Your Ticket is on Waiting List");
            return true;
        } else {
            return false;
        }

    }

    public Boolean booking(String name, int age, String gender, String berthPreference, String hasChild) {
        if (age < 5) {
            System.out.println("Ticket cannot be booked for children below 5 years");
            return false;
        } else if (age > 60 || gender.equals("female") && hasChild.equals("yes")) {
            if (lowerBerthCount < maxUpperMiddleLowerBerth) {
                if (confirmBooking(name, age, gender, "lower")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }
            } else if (middleBerthCount < maxUpperMiddleLowerBerth) {
                if (confirmBooking(name, age, gender, "middle")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }

            } else if (upperBerthCount < maxUpperMiddleLowerBerth) {
                if (confirmBooking(name, age, gender, "upper")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }
            } else if (racCount < maxRac) {
                System.out.println("Available Tickets on RAC: " + (maxRac - racCount));
                System.out.println("Dou you want to book ticket on RAC? (yes/no)");
                String racOption = input.next();
                if (racOption.equals("yes")) {
                    if (confirmBooking(name, age, gender, "rac")) {
                        System.out.println("Thank you for booking ticket");
                        return true;
                    }
                } else {
                    System.out.println("Thank you for visiting");
                    return false;
                }
            } else if (waitingListCount < maxWaitingList) {
                System.out.println("Available Tickets on Waiting List: " + (maxWaitingList - waitingListCount));
                System.out.println("Dou you want to book ticket on Waiting List? (yes/no)");
                String waitingListOption = input.next();
                if (waitingListOption.equals("yes")) {
                    if (confirmBooking(name, age, gender, "waitingList")) {
                        System.out.println("Thank you for booking ticket");
                        return true;
                    }
                } else {
                    System.out.println("Thank you for visiting");
                    return false;
                }
            } else {
                System.out.println("No tickets available");
                return false;
            }
            return false;
        } else if (berthPreference.equals("lower")) {
            if (lowerBerthCount < maxUpperMiddleLowerBerth) {
                if (confirmBooking(name, age, gender, "lower")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }
            } else {
                System.out.println("No tickets available on Lower Berth");
                if (middleBerthCount < maxUpperMiddleLowerBerth || upperBerthCount < maxUpperMiddleLowerBerth) {
                    System.out.println(
                            "Available Tickets on Middle Berth: " + (maxUpperMiddleLowerBerth - middleBerthCount));
                    System.out.println(
                            "Available Tickets on Upper Berth: " + (maxUpperMiddleLowerBerth - upperBerthCount));
                    System.out.println("Please select the berth preference from the available options");
                    System.out.println("Enter the berth preference (middle/upper)");
                    String berthPreferenceOption = input.next();
                    if (berthPreferenceOption.equals("middle")) {
                        if (confirmBooking(name, age, gender, "middle")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    } else if (berthPreferenceOption.equals("upper")) {
                        if (confirmBooking(name, age, gender, "upper")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    }

                } else if (racCount < maxRac) {
                    System.out.println("Available Tickets on RAC: " + (maxRac - racCount));
                    System.out.println("Are you willing to book ticket on RAC? (yes/no)");
                    String racOption = input.next();
                    if (racOption.equals("yes")) {
                        if (confirmBooking(name, age, gender, "rac")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    } else {
                        System.out.println("Thank you for visiting");
                        return false;
                    }
                } else if (waitingListCount < maxWaitingList) {
                    System.out.println("Available Tickets on Waiting List: " + (maxWaitingList - waitingListCount));
                    System.out.println("Are you willing to book ticket on Waiting List? (yes/no)");
                    String waitingListOption = input.next();
                    if (waitingListOption.equals("yes")) {
                        if (confirmBooking(name, age, gender, "waitingList")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    }
                } else {
                    System.out.println("No tickets available");

                    System.out.println("Thank you for visiting");
                }

            }
            return false;

        }

        else if (berthPreference.equals("middle")) {
            if (middleBerthCount < maxUpperMiddleLowerBerth) {
                if (confirmBooking(name, age, gender, "middle")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }
            } else {
                System.out.println("No tickets available on Middle Berth");
                if (lowerBerthCount < maxUpperMiddleLowerBerth || upperBerthCount < maxUpperMiddleLowerBerth) {
                    System.out.println(
                            "Available Tickets on Lower Berth: " + (maxUpperMiddleLowerBerth - lowerBerthCount));
                    System.out.println(
                            "Available Tickets on Upper Berth: " + (maxUpperMiddleLowerBerth - upperBerthCount));
                    System.out.println("Please select the berth preference from the available options");
                    System.out.println("Enter the berth preference (lower/upper)");
                    String berthPreferenceOption = input.next();
                    if (berthPreferenceOption.equals("lower")) {
                        if (confirmBooking(name, age, gender, "lower")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    } else if (berthPreferenceOption.equals("upper")) {
                        if (confirmBooking(name, age, gender, "upper")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    }

                } else if (racCount < maxRac) {
                    System.out.println("Available Tickets on RAC: " + (maxRac - racCount));
                    System.out.println("Are you willing to book ticket on RAC? (yes/no)");
                    String racOption = input.next();
                    if (racOption.equals("yes")) {
                        if (confirmBooking(name, age, gender, "rac")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    } else {
                        System.out.println("Thank you for visiting");
                        return false;
                    }
                } else if (waitingListCount < maxWaitingList) {
                    System.out.println("Available Tickets on Waiting List: " + (maxWaitingList - waitingListCount));
                    System.out.println("Are you willing to book ticket on Waiting List? (yes/no)");
                    String waitingListOption = input.next();
                    if (waitingListOption.equals("yes")) {
                        if (confirmBooking(name, age, gender, "waitingList")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    }

                }

                else {
                    System.out.println("No tickets available");

                    System.out.println("Thank you for visiting");
                }

            }
            return false;
        } else if (berthPreference.equals("upper")) {
            if (upperBerthCount < maxUpperMiddleLowerBerth) {
                if (confirmBooking(name, age, gender, "upper")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }
            } else {
                System.out.println("No tickets available on Upper Berth");
                if (lowerBerthCount < maxUpperMiddleLowerBerth || middleBerthCount < maxUpperMiddleLowerBerth) {
                    System.out.println(
                            "Available Tickets on Lower Berth: " + (maxUpperMiddleLowerBerth - lowerBerthCount));
                    System.out.println(
                            "Available Tickets on Middle Berth: " + (maxUpperMiddleLowerBerth - middleBerthCount));
                    System.out.println("Please select the berth preference from the available options");
                    System.out.println("Enter the berth preference (lower/middle)");
                    String berthPreferenceOption = input.next();
                    if (berthPreferenceOption.equals("lower")) {
                        if (confirmBooking(name, age, gender, "lower")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    } else if (berthPreferenceOption.equals("middle")) {
                        if (confirmBooking(name, age, gender, "middle")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    }

                } else if (racCount < maxRac) {
                    System.out.println("Available Tickets on RAC: " + (maxRac - racCount));
                    System.out.println("Are you willing to book ticket on RAC? (yes/no)");
                    String racOption = input.next();
                    if (racOption.equals("yes")) {
                        if (confirmBooking(name, age, gender, "rac")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    } else {
                        System.out.println("Thank you for visiting");
                        return false;
                    }
                } else if (waitingListCount < maxWaitingList) {
                    System.out.println("Available Tickets on Waiting List: " + (maxWaitingList - waitingListCount));
                    System.out.println("Are you willing to book ticket on Waiting List? (yes/no)");
                    String waitingListOption = input.next();
                    if (waitingListOption.equals("yes")) {
                        if (confirmBooking(name, age, gender, "waitingList")) {
                            System.out.println("Thank you for booking ticket");
                            return true;
                        }
                    }

                }

                else {
                    System.out.println("No tickets available");
                    System.out.println("Thank you for visiting");
                }

            }
            return false;
        }

        else if (berthPreference.equals("rac")) {
            if (racCount < maxRac) {
                if (confirmBooking(name, age, gender, "rac")) {
                    System.out.println("Thank you for booking ticket");
                    return true;
                }
            }

            else {
                System.out.println("No tickets available on Rac");
                System.out.println("Thank you for visiting");
            }
            return false;

        }

        else {
            System.out.println("Invalid Berth Preference");
            return false;
        }

    }
}
