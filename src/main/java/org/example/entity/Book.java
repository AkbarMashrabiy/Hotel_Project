package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private UUID roomId;
    private UUID userId;
    private LocalDate checkInTime;
    private LocalDate checkOutTime;
    private Integer numberOfGuests;
}
