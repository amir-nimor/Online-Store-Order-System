package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressUser {


    @Column(nullable = false)
    private String City;


    @Column(nullable = false)
    private String street;


    @Column(nullable = false)
    private String postalCode;

    public AddressUser(String city, String street, String postalCode) {
        City = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public AddressUser() {

    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
