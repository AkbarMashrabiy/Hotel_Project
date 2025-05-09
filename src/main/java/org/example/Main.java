package org.example;

import org.example.db.DB;
import org.example.entity.Room;
import org.example.entity.User;
import org.example.enums.RoomStatus;
import org.example.enums.UserType;
import org.example.service.AuthService;
import org.example.ui.UserUi;
import java.util.UUID;

import static org.example.service.AuthService.scn;

public class Main {
    static {
        new User(UUID.randomUUID(), "Akbar", "Mashrabiy", "akbar@gmail.com", "2002", 1_500D, UserType.ADMIN);

        Room room1 = new Room(UUID.randomUUID(), null, 2, 24, 4, 545000, RoomStatus.FREE);
        Room room2 = new Room(UUID.randomUUID(), null, 1, 14, 2, 45000, RoomStatus.FREE);
        Room room3= new Room(UUID.randomUUID(), null, 2, 25, 1, 55000, RoomStatus.FREE);
        Room room4 = new Room(UUID.randomUUID(), null, 1, 6, 3, 23000, RoomStatus.FREE);
        Room room5 = new Room(UUID.randomUUID(), null, 2, 24, 4, 545000, RoomStatus.FREE);
        Room room6 = new Room(UUID.randomUUID(), null, 1, 8, 2, 75000, RoomStatus.FREE);
        Room room7 = new Room(UUID.randomUUID(), null, 1, 18, 4, 845000, RoomStatus.FREE);
        DB.rooms.add(room1);
        DB.rooms.add(room2);
        DB.rooms.add(room3);
        DB.rooms.add(room4);

        DB.rooms.add(room5);
        DB.rooms.add(room6);
        DB.rooms.add(room7);
    }

    static AuthService authService = new AuthService();

    public static void main(String[] args) {
        boolean isExited = false;

        while (!isExited) {
            System.out.print("""
                    1 register.
                    2 login.
                    \s
                    0 exit.
                    >>>\s""");

            switch (scn.nextLine()) {
                case "1" -> register();
                case "2" -> login();
                case "0" -> isExited = true;
            }
        }
    }


    private static void register() {
        System.out.println("Enter first name: ");
        String firstName = scn.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scn.nextLine();

        System.out.println("Enter email: ");
        String email = scn.nextLine();

        if (authService.isAlreadyExistUser(email)) {
            System.out.println("The email already exist!");
            return;
        }

        System.out.println("Enter password");
        String password = scn.nextLine();

        User user = new User(UUID.randomUUID(), firstName, lastName, email, password, 0, UserType.USER);
        authService.addUser(user);
        UserUi.userUi(user);
    }

    private static void login() {
        System.out.println("Enter email: ");
        String email = scn.nextLine();

        System.out.println("Enter password");
        String password = scn.nextLine();

        if (authService.signIn(email, password)) {
            User user = authService.getUserByEmail(email);
            UserUi.userUi(user);
        }
        System.out.println("User not found!");
    }
}