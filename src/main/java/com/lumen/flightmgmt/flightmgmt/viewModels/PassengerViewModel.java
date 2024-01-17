package com.lumen.flightmgmt.flightmgmt.viewModels;


public class PassengerViewModel {
    private int passengerId;
    private String firstName;
    private String lastName;
    private long mobileNumber;

    private String email;
    private int flightId;
    private String flightCode;

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

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
//        if(email.contains("@gmail.com")) {
        return email;
//        }
//        return "Email invalid";
    }

    public void setEmail(String email) {
        this.email = email;
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

}
