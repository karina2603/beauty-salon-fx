package com.example.beautysalonfx.entity;

import java.util.Objects;

public class Record {

    private int ID_record;
    private Service service;
    private Master master;
    private User user;
    private String date;
    private String time;
    private Status status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Record(Service service, Master master, String date, String time) {
        this.service = service;
        this.master = master;
        this.date = date;
        this.time = time;
        this.status = Status.Free;
    }

    public Record() {
    }

    public int getID_record() {
        return ID_record;
    }

    public void setID_record(int ID_record) {
        this.ID_record = ID_record;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service ID_service) {
        this.service = ID_service;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return ID_record == record.ID_record && service == record.service && master == record.master && Objects.equals(date, record.date) && Objects.equals(time, record.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID_record, service, master, date, time);
    }
}
