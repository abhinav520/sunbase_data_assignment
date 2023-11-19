package com.abhinav.sunbase.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String first_name;

    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    private String street;

    private String address;

    private String city;

    private String phone;

    //getter and setter
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.id +
                ", first_name='" + this.first_name +
                ", last_name='" + this.last_name +
                ", street='" + this.street +
                ", address='" + this.address +
                ", city='" + this.city +
                ", email='" + this.email +
                ", phone='" + this.phone +
                '}';
    }
}
