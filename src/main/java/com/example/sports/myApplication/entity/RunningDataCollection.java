package com.example.sports.myApplication.entity;

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

    @NotBlank
    private int distance;

    public RunningDataCollection(long id, Date date, long time, int distance) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.distance = distance;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
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
