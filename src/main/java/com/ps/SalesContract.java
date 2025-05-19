package com.ps;

public class SalesContract extends Contract{

    private double salesTaxAmount;
    private double recordingFee ;
    private double processingFee;
    private boolean isFinanced;



    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    public double getSalesTaxAmount(){

        double salesTaxRate = 0.05;
        double vehiclePrice = getVehicleSold().getPrice();
        salesTaxAmount = salesTaxRate * vehiclePrice;

        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount){
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee(){

        recordingFee =100;
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee){
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee(){
        double vehiclePrice = getVehicleSold().getPrice();

        if(vehiclePrice < 10000){
            processingFee = 295;
        }

        else{
            processingFee = 495;
        }

        return processingFee;
    }


    public void setProcessingFee(double processingFee){
        this.processingFee= processingFee;
    }

    public boolean isFinanced(){
        return isFinanced;
    }

    public void setIsFinanced(boolean isFinanced){
        this.isFinanced = isFinanced;
    }


    @Override
    public double getTotalPrice() {

        double vehiclePrice = getVehicleSold().getPrice();
        double salesTotalPrice = vehiclePrice+getSalesTaxAmount()+getRecordingFee()+getProcessingFee();

        return salesTotalPrice;
    }

    @Override
    public double getMonthlyPayment() {

        double rate;
        int months;
        double loanAmount = getTotalPrice();
        double vehiclePrice = getVehicleSold().getPrice();

        if(isFinanced) {

            if (vehiclePrice >= 10000) {

                rate = 0.0425 / 12;
                months = 48;
            }

            else {

                rate = 0.0525/12;
                months =24;
            }

            double monthlyPayment = loanAmount*(rate *Math.pow(1+ rate, months))/(Math.pow(1+ rate, months)-1);

            return monthlyPayment;
        }

        else {
            return 0;
        }

    }

}