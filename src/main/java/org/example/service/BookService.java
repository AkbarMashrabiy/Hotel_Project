package org.example.service;

import org.example.db.DB;
import org.example.entity.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookService {

    public List<Room> seeAllFreeRoomsByDate() {
        List<Room> freeRooms = new ArrayList<>();
        DB.rooms.forEach(room -> {
            if (room.getCapacity() >0) {
                freeRooms.add(room);
            }
        });
        return freeRooms;
    }





    public boolean validateDate(LocalDate checkInDate, LocalDate checkOutDate) {
        if (checkInDate.isBefore(LocalDate.now()) || checkOutDate.isBefore(LocalDate.now())) {
            return false;
        }
        return checkInDate.isBefore(checkOutDate);
    }
}


