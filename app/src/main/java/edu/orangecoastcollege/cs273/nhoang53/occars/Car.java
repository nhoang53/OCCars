package edu.orangecoastcollege.cs273.nhoang53.occars;

/**
 * Nguyen Hoang C02288487
 * Exercise: OC Cars
 */

public class Car {
    private static final Double APR_3_YEARS = 0.0462;
    private static final Double APR_4_YEARS = 0.0416;
    private static final Double APR_5_YEARS = 0.0419;
    double mDownPayment;
    int mLoanTerm;
    double mPrice;
    private static final Double TAX_RATE = 0.08;

    public Car() {
        mDownPayment = 0.0;
        mLoanTerm = 0;
        mPrice = 0.0;
    }

    public double getmDownPayment() {
        return mDownPayment;
    }

    public int getmLoanTerm() {
        return mLoanTerm;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmDownPayment(double mDownPayment) {
        this.mDownPayment = mDownPayment;
    }

    public void setmLoanTerm(int mLoanTerm) {
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
            return calculateBorrowedAmount() * APR_3_YEARS;
        else if(mLoanTerm == 4)
            return calculateBorrowedAmount() * APR_4_YEARS;
        else
            return calculateBorrowedAmount() * APR_5_YEARS;
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
