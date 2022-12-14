package com.example.beautysalonfx.entity;

import java.util.Objects;

public class Record {

    private int id_record;
    private String service_name;
    private String master_name;
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

    public Record(String service, String master_name, String date, String time) {
        this.service_name = service;
        this.master_name = master_name;
        this.date = date;
        this.time = time;
        this.status = Status.Free;
    }

    public Record() {
    }

    public int getId_record() {
        return id_record;
    }

    public void setId_record(int id_record) {
        this.id_record = id_record;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
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
        return id_record == record.id_record && service_name == record.service_name && master_name == record.master_name && Objects.equals(date, record.date) && Objects.equals(time, record.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_record, service_name, master_name, date, time);
    }
}
