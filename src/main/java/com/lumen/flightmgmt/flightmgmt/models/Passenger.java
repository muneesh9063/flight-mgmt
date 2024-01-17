package com.lumen.flightmgmt.flightmgmt.models;

import com.lumen.flightmgmt.flightmgmt.exception.InvalidEmailFormat;
import com.lumen.flightmgmt.flightmgmt.exception.InvalidPhoneNumberFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "passengers")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    //@Pattern(regexp="^(\\+\\d{1,3}[- ]?)?\\d{10}$",message = "Enter valid Mobile Number")
    @Column(nullable = false,unique = true)
    private long mobileNumber;

    //@Email(message = "Email is not valid", regexp="{(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])}")
    //@NotEmpty(message = "Email cannot be empty")
    @Column(nullable = false,unique = true)
    private String email;
    private int flightId;
    private String flightCode;
    @ManyToOne
    @JoinColumn(name = "flightId",insertable = false,updatable = false)
    private Flight flight;
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) throws InvalidPhoneNumberFormat {
        String mobileNumberString = String.valueOf(mobileNumber);
        if (mobileNumberString.length() != 10 || mobileNumberString.charAt(0) == '0') {
            throw new InvalidPhoneNumberFormat("Invalid mobile number");
        }
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) throws InvalidEmailFormat {
        if (email == null || !(email.contains("@") && (email.contains(".com") || email.contains(".org")))) {
            throw new InvalidEmailFormat("Invalid email address");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", flightId=" + flightId +
                ", flightCode='" + flightCode + '\'' +
                ", flight=" + flight +
                '}';
    }
}
