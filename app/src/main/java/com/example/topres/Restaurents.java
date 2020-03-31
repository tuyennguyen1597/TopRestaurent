package com.example.topres;

import java.util.ArrayList;

public class Restaurents {
    private String name;
    private String location;
    private double rating;
    private String contactNumber;
    private double priceAvg;

    public Restaurents() {
    }

    public Restaurents(String name, String location, double rating, String contactNumber, double priceAvg) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.contactNumber = contactNumber;
        this.priceAvg = priceAvg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getPriceAvg() {
        return priceAvg;
    }

    public void setPriceAvg(double priceAvg) {
        this.priceAvg = priceAvg;
    }

    public static ArrayList<Restaurents> restaurentsList() {
        ArrayList<Restaurents> restaurents;
        restaurents = new ArrayList<>();
        restaurents.add(new Restaurents("Quay", "Overseas Passenger Terminal, The Rock, Sydney 2000", 5, "0292515600", 300));
        restaurents.add(new Restaurents("Lankan Filling Station", "58 Riley St, Darlinghurst, Sydney 2010", 5, "0285429936", 20));
        restaurents.add(new Restaurents("Marrickville Pork Roll", "296 Marrickville Rd, Marrickville, NSW 2204", 4.8, "0479000445", 10));
        restaurents.add(new Restaurents("Ms. G's", "201-141 Victoria St, Potts Point, NSW 2011", 4.7, "0291147342", 50));
        restaurents.add(new Restaurents("Out of the Blue", "272 Clovelly Rd, Clovelly, NSW 2031", 4.7, "0293158380", 10));
        restaurents.add(new Restaurents("Mappen Noodle Restaurent", "Skyview Shopping Plaza, 537-551 George Street, CBD Sydney", 4.8, "0292835525", 20));
        restaurents.add(new Restaurents("The Baxter Inn", "152-156 Clarence Street, CBD, Sydney", 4.9, "0292215580", 30));
        restaurents.add(new Restaurents("La Renaissance Cafe Patisserie", "47 Argyle Street, The Rocks, Sydney", 4.8, "0292414878", 20));
        restaurents.add(new Restaurents("Thai Pothong", "294 King Street, Newtown, Sydney", 4.8, "0295506277", 50));
        restaurents.add(new Restaurents("Din Tai Fung", "World Square Shopping Centre, 644 George Street, CBD Sydney", 4.5, "0292646010", 35));
        return restaurents;
    }

    public static Restaurents searchRestaurent(String name) {
        Restaurents notMatchRestaurent = new Restaurents();
        ArrayList<Restaurents> restaurents = new ArrayList<>();
        restaurents = Restaurents.restaurentsList();
        for (int i = 0; i < restaurents.size(); i++) {
            Restaurents res = restaurents.get(i);
            if (name.equals(res.getName())) {
                return res;
            }
        }
        return notMatchRestaurent;
    }
}
