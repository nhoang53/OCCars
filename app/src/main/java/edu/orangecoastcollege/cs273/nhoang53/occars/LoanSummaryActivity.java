package edu.orangecoastcollege.cs273.nhoang53.occars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends Activity {

    private TextView monthlyPaymentTextView;
    private TextView loanReportTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        monthlyPaymentTextView = (TextView) findViewById(R.id.monthlyPaymentTextView);
        loanReportTextView = (TextView) findViewById(R.id.loanReportTextView);

        Intent intentFromPurchaseActivity = getIntent();
        String monthlyPaymentText = intentFromPurchaseActivity.getStringExtra("MonthlyPayment");
        monthlyPaymentTextView.setText(monthlyPaymentText);

        String loanSummaryReport = intentFromPurchaseActivity.getStringExtra("LoanSummary");
        loanReportTextView.setText(loanSummaryReport);
    }

    public void returnToDataEntry(View view)
    {
        this.finish();
    }
}
