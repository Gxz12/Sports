package com.example.sports.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name ="_RDC")
public class RunningDataCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private Date date;

    @NotBlank
    private long time;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @NotBlank
    private int speed;

    private double distance;

    public RunningDataCollection(long id, Date date, long time, int speed) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.speed = speed;
    }

    public RunningDataCollection(long id, Date date, long time, int speed,double distance) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.speed = speed;
        this.distance =distance;
    }

    public RunningDataCollection(){
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RunningDataCollection{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", distance=" + distance +
                '}';
    }
}
