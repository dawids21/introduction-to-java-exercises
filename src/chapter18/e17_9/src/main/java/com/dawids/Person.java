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
        if (name.length() > 32 || street.length() > 32 || city.length() > 20 || state.length() > 2 || zip.length() > 5) {
            throw new IllegalArgumentException();
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
