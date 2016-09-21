package edu.orangecoastcollege.cs273.nhoang53.occars;

/**
 * Nguyen Hoang C02288487
 * Exercise: OC Cars
 */

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.NumberFormat;

public class PurchaseActivity extends AppCompatActivity {

    private EditText carPriceEditText;
    private EditText downPaymentEditText;
    private RadioButton threeYearsRadioButton;
    private RadioButton fourYearsRadioButton;
    private RadioButton fiveYearsRadioButton;

    private Car currentCar = new Car();

    private String monthlyPaymentText;
    private String loanSummaryText;

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        carPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        downPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        threeYearsRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        fourYearsRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        fiveYearsRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);
    }

    // when associating the button with an event, set the onClickProperty
    // Define the method as public void (with one parameter View view)
    public void activateLoanReport(View view){
        double price, downPayment;

        try{
            price = Double.parseDouble(carPriceEditText.getText().toString());
            downPayment = Double.parseDouble(downPaymentEditText.getText().toString());
        }
        catch(NumberFormatException e) // Hold Ctrl and mouse over parseDouble to get Exception
        {
            price = 0.0;
            downPayment = 0.0;
        }

        int loanTerm;

        if(fiveYearsRadioButton.isChecked())
            loanTerm = 5;
        else if(fourYearsRadioButton.isChecked())
            loanTerm = 4;
        else
            loanTerm = 3;

        currentCar.setmPrice(price);
        currentCar.setmDownPayment(downPayment);
        currentCar.setmLoanTerm(loanTerm);

        constructLoanSummaryText();

        // create the Intent to share data with LoanSummaryActivity
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);
        loanSummaryIntent.putExtra("MonthlyPayment", monthlyPaymentText);
        loanSummaryIntent.putExtra("LoanSummary", loanSummaryText);

        // Start the new activity with the intent data
        startActivity(loanSummaryIntent);
    }

    private void constructLoanSummaryText()
    {
        monthlyPaymentText = getString(R.string.report_line1) + currency.format(currentCar.calculateMonthlyPayment());
        loanSummaryText = getString(R.string.report_line2) + currency.format(currentCar.getmPrice())
                + getString(R.string.report_line3) + currency.format(currentCar.getmDownPayment())
                + getString(R.string.report_line5) + currency.format(currentCar.calculateTaxAmount())
                + getString(R.string.report_line6) + currency.format(currentCar.calculateTotalCost())
                + getString(R.string.report_line7) + currency.format(currentCar.calculateBorrowedAmount())
                + getString(R.string.report_line8) + currency.format(currentCar.calculateInterestAmount())
                + getString(R.string.report_line4) + currentCar.getmLoanTerm() + " years."
                + getString(R.string.report_line9)
                + getString(R.string.report_line10)
                + getString(R.string.report_line11);
    }
}
