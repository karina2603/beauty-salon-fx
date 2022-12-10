package com.example.beautysalonfx.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Service {

    private int ID_service;
    private String name;
    private double request_time;
    private int cost;
    private List<Master> masters;

    public void addMasterToService(Master master) {
        if (masters == null) {
            masters = new ArrayList<>();
        }
        masters.add(master);
    }
    public Service(String name, double request_time, int cost) {
        this.name = name;
        this.request_time = request_time;
        this.cost = cost;
    }

    public Service() {
    }

    public int getID_service() {
        return ID_service;
    }

    public void setID_service(int ID_service) {
        this.ID_service = ID_service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRequest_time() {
        return request_time;
    }

    public void setRequest_time(double request_time) {
        this.request_time = request_time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Master> getMasters() {
        return masters;
    }

    public void setMasters(List<Master> masters) {
        this.masters = masters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return ID_service == service.ID_service && request_time == service.request_time && cost == service.cost && name == service.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID_service, name, request_time, cost);
    }
}
