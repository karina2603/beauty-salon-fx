package com.example.beautysalonfx.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Master {
    private int id_master;
    private String name;
    private List<Service> services;

    public void addServiceToMaster(Service service) {
        if (services == null) {
            services = new ArrayList<>();
        }
        services.add(service);
    }
    public Master(String name, List<Service> services) {
        this.name = name;
        this.services = services;
    }
    public Master(String name) {
        this.name = name;
    }

    public Master() {
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Master master = (Master) o;
        return id_master == master.id_master && Objects.equals(name, master.name) && Objects.equals(services, master.services);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_master, name, services);
    }
}
