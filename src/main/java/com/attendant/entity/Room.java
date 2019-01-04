package com.attendant.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
//@Entity
public class Room {
    private int numberRoom;
    private List<Date> datesAttendants;
    private List<Human> humans;
}

