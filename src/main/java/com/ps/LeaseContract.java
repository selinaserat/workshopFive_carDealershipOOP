
package com.ps;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValue() {
        double vehiclePrice = getVehicleSold().getPrice();
        expectedEndingValue = vehiclePrice * 0.5;
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {

        double vehiclePrice = getVehicleSold().getPrice();
        leaseFee = vehiclePrice * 0.07;
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }



    @Override
    public double getTotalPrice() {

        return getExpectedEndingValue() + getLeaseFee();


    }

    @Override
    public double getMonthlyPayment() {
        double rate = 0.04/12;
        int months = 36;
        double totalAmount = getTotalPrice();

        monthlyPayment = totalAmount*(rate* Math.pow(1+ rate, months))/(Math.pow(1+ rate, months)-1);


        return monthlyPayment;

    }
}
