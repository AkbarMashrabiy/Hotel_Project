package org.example.service;

import org.example.db.DB;
import org.example.entity.User;

import java.util.Scanner;

public class AuthService {
    public static Scanner scn = new Scanner(System.in);


    public void addUser(User user) {
        DB.users.add(user);
    }


    public boolean isAlreadyExistUser(String email) {
        for (User user : DB.users) {
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }


    public boolean signIn(String email, String password) {
        for (User user : DB.users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User getUserByEmail(String email){
        for (User user : DB.users) {
            if (user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }
}
