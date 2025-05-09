package org.example.entity;

import lombok.*;
import org.example.enums.RoomStatus;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {
    private UUID id;
    private UUID userId;
    private Integer floor;
    private Integer roomNumber;
    private Integer capacity;
    private double price;
    private RoomStatus status;


    @Override
    public String toString() {
        return "Room[" +
                "floor=" + floor +
                ", roomNumber=" + roomNumber +
                ", capacity=" + capacity +
                ", price=" + price +
                ", status=" + status +
                ']';
    }
}