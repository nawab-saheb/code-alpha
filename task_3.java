//HotelReservationSystem 

import java.util.*;
class Room {
    int roomNumber;
    String roomType;
    boolean isBooked;
    double price;
    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = false;
        this.price = price;
    }
    public void bookRoom() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Room " + roomNumber + " is successfully booked!");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }
    public void showRoomDetails() {
        String status = isBooked ? "Booked" : "Available";
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType + ", Price: Rs." + price + ", Status: " + status);
    }
}
class Reservation {
    Room room;
    String guestName;
    public Reservation(Room room, String guestName) {
        this.room = room;
        this.guestName = guestName;
    }
    public void showBookingDetails() {
        System.out.println("Booking Details:");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Number: " + room.roomNumber + ", Room Type: " + room.roomType);
        System.out.println("Total Price: Rs." + room.price);
    }
}
public class task_3 {
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static {
        rooms.add(new Room(101, "Single", 1000.0));
        rooms.add(new Room(102, "Double", 1500.0));
        rooms.add(new Room(103, "Suite", 2500.0));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nHotel Reservation System Menu:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookingDetails(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the hotel reservation system!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }

        scanner.close();
    }

    // Method to view available rooms
    public static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                room.showRoomDetails();
            }
        }
    }
    public static void makeReservation(Scanner scanner) {
        System.out.print("\nEnter your name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                selectedRoom = room;
                break;
            }
        }
        if (selectedRoom != null && !selectedRoom.isBooked) {
            selectedRoom.bookRoom();
            reservations.add(new Reservation(selectedRoom, guestName));
        } else if (selectedRoom != null) {
            System.out.println("Sorry, this room is already booked.");
        } else {
            System.out.println("Room number " + roomNumber + " does not exist.");
        }
    }
    public static void viewBookingDetails(Scanner scanner) {
        System.out.print("\nEnter your name to view booking: ");
        String guestName = scanner.nextLine();

        for (Reservation reservation : reservations) {
            if (reservation.guestName.equalsIgnoreCase(guestName)) {
                reservation.showBookingDetails();
                return;
            }
        }
        System.out.println("No booking found for the name: " + guestName);
    }
}
