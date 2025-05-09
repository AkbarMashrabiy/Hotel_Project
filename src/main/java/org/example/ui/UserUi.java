package org.example.ui;

import org.example.entity.Room;
import org.example.entity.User;
import org.example.service.BookService;

import java.time.LocalDate;
import java.util.List;

import static org.example.service.AuthService.scn;

public class UserUi {
    static User currentUser;
    static BookService bookService = new BookService();
    public static void userUi(User user) {

        currentUser = user;
        boolean isExited = false;
        while (!isExited) {
            System.out.print("""
                    \n
                    1 Show rooms
                    2 Search room
                    3 Book room
                    4 Show bookings
                    5 Cancel booking
                    6 Balance
                    
                    0 Exit
                    """);

            switch (scn.nextLine()) {
                case "1" -> {
                    showRooms();
                }
                case "2" -> {
                    searchRoom();
                }
                case "3" -> {

                }
                case "4" -> {

                }
                case "5" -> {

                }
                case "6" -> {
                    balance();
                }
                case "0" -> {
                    isExited = true;

                }

            }
        }
    }

    private static void searchRoom() {
        System.out.print("""
                1 Search by Date
                2 Search by Capacity
                >>>>\s""");

        switch (scn.nextLine()) {
            case "1" -> {
                System.out.println("Enter");

            }
            case "2" -> {
            }
        }
    }

    private static void balance() {
        System.out.print("""
                1 Show balance
                2 Fill balance
                >>>>\s""");

        switch (scn.nextLine()){
            case "1" -> System.out.println("Your balance = "  + currentUser.getBalance());
            case "2" -> {
                System.out.println("Enter amount");
                double value = Double.parseDouble(scn.nextLine());
                currentUser.setBalance(currentUser.getBalance() + value);
                System.out.println("Success!");
            }
        }
    }

    private static void showRooms() {
        List<Room> rooms = bookService.seeAllFreeRoomsByDate();
        for (Room room : rooms) {
            System.out.println(room);

        }
    }
}
