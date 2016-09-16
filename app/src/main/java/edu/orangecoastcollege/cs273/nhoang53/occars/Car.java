package edu.orangecoastcollege.cs273.nhoang53.occars;

/**
 * Created by nhoang53 on 9/15/2016.
 */

public class Car {
    double mDownPayment;
    double mLoanTerm;
    double mPrice;
    private static final Double TAX_RATE = 0.08;
    private static final Double threeYearsInterest = 0.0462;
    private static final Double fourYearsInterest = 0.0416;
    private static final Double fiveYearsInterest = 0.0419;

    public Car() {
        mDownPayment = 0.0;
        mLoanTerm = 0.0;
        mPrice = 0.0;
    }

    public double getmDownPayment() {
        return mDownPayment;
    }

    public double getmLoanTerm() {
        return mLoanTerm;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmDownPayment(double mDownPayment) {
        this.mDownPayment = mDownPayment;
    }

    public void setmLoanTerm(double mLoanTerm) {
        this.mLoanTerm = mLoanTerm;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public double calculateBorrowedAmount(){
        return mPrice + calculateTaxAmount() - mDownPayment;
    }

    public double calculateInterestAmount(){
        if(mLoanTerm == 3)
            return calculateBorrowedAmount() * threeYearsInterest;
        else if(mLoanTerm == 4)
            return calculateBorrowedAmount() * fourYearsInterest;
        else
            return calculateBorrowedAmount() * fiveYearsInterest;
    }

    public double calculateMonthlyPayment(){
        if(mLoanTerm == 3)
            return (calculateBorrowedAmount() + calculateInterestAmount()) / 36;
        else if(mLoanTerm == 4)
            return (calculateBorrowedAmount() + calculateInterestAmount()) / 48;
        else
            return (calculateBorrowedAmount() + calculateInterestAmount()) / 60;
    }
    public double calculateTaxAmount(){
        return mPrice * TAX_RATE;
    }

    public double calculateTotalCost(){
        return mPrice + calculateTaxAmount();
    }
}
