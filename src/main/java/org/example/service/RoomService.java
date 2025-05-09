package org.example.service;

import org.example.db.DB;
import org.example.entity.Room;
import org.example.enums.RoomStatus;

import java.util.Optional;
import java.util.UUID;

public class RoomService {

    public void addRoom(Room room){
        DB.rooms.add(room);
    }

    public boolean isAdded(Room room){
        return DB.rooms.stream().anyMatch(room1 -> {
            return room1.getRoomNumber().equals(room.getRoomNumber())
                    && room1.getFloor().equals(room.getFloor());
        });
    }


    public void updateStatus(Room room, RoomStatus status){
        room.setStatus(status);
    }

    public void remove(Room room){
        DB.rooms.remove(room);
    }

    public void removeByRoomId(UUID id){
        Room room = getRoomById(id);
        if (room != null){
            DB.rooms.remove(room);
        }
    }


    public Room getRoomById(UUID id){
        Optional<Room> first = DB.rooms.stream().filter(room -> room.getId().equals(id)).findFirst();
        return first.orElse(null);
    }

}
