package ir.maktabsharif.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseModel<Integer>{

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(name = "phone_number",nullable = false,unique = true)
    private String phoneNumber;

    @Enumerated
    private AddressUser addressUser;

    @Check(constraints = "balance >= 0")
    private BigDecimal balance;

    @ManyToMany
    private List<Product> products;

    public User(String fullName, String phoneNumber, AddressUser addressUser, BigDecimal balance) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.addressUser = addressUser;
        this.balance = balance;
        this.products = new ArrayList<>();
    }

    public User() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressUser getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(AddressUser addressUser) {
        this.addressUser = addressUser;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressUser=" + addressUser +
                ", balance=" + balance +
                ", products=" + products +
                '}';
    }
}
