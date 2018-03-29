package com.example.maniy.tot_application;



public class CustomerInfo {

    //Required Values Declaration
    private String id;
    private String customerName;
    private String customerPhone;
    private String trainName;
    private String trainNumber;
    private String coachName;
    private String seatNumber;
    private String destinationStation;


    //Empty Constructor
    public CustomerInfo() {
    }


    //Constructor with all the arguments passed in


    public CustomerInfo(String id, String customerName,String customerPhone, String trainName, String trainNumber,String coachName, String seatNumber, String destinationStation) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.coachName = coachName;
        this.seatNumber = seatNumber;
        this.destinationStation = destinationStation;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone(){ return customerPhone; }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getCoachName(){
        return coachName;
    }


    public String getSeatNumber() {
        return seatNumber;
    }

    public String getDestinationStation() {
        return destinationStation;
    }
}
