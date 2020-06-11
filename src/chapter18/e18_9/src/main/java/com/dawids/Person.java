package com.dawids;

public class Person {
    private final String name;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public Person() {
        this.name = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = "";
    }

    public Person(String name, String street, String city, String state, String zip) {
        if (name.length() > 32) {
            name = name.substring(0, 32);
        }
        if (street.length() > 32) {
            street = street.substring(0, 32);
        }
        if (city.length() > 20) {
            city = city.substring(0, 20);
        }
        if (state.length() > 2) {
            state = state.substring(0, 2);
        }
        if (zip.length() > 5) {
            zip = zip.substring(0, 5);
        }
        this.name = String.format("%-32s", name);
        this.street = String.format("%-32s", street);
        this.city = String.format("%-20s", city);
        this.state = String.format("%-2s", state);
        this.zip = String.format("%-5s", zip);
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
