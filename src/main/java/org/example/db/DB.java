package org.example.db;

import org.example.entity.Book;
import org.example.entity.Room;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface DB {
    List<User> users = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

}


