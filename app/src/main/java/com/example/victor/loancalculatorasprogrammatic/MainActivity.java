package com.example.victor.loancalculatorasprogrammatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1, et2, et3;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout)findViewById(R.id.viewobject);

        TextView tv1 = new TextView(this);
        tv1.setText("Enter loan amount in $");
        ll.addView(tv1);

        et1 = new EditText(this);
        ll.addView(et1);

        TextView tv2 = new TextView(this);
        tv2.setText("Enter the number of years");
        ll.addView(tv2);

        et2 = new EditText(this);
        ll.addView(et2);

        TextView tv3 = new TextView(this);
        tv3.setText("Enter the interest as a double");
        ll.addView(tv3);

        et3 = new EditText(this);
        ll.addView(et3);

        Button button = new Button(this);
        button.setText("Calculate");
        button.setOnClickListener(this);

        ll.addView(button);
    }

    @Override
    public void onClick(View v)
    {
        int loanAmount = Integer.parseInt(et1.getText().toString());
        int years = Integer.parseInt(et2.getText().toString());
        double interestRate = Double.parseDouble(et3.getText().toString());

        double monthlyPayment;
        double monthlyInterestRate;
        int numberOfPayments;

        if (years != 0 && interestRate != 0)
        {
            //calculate the monthly payment
            monthlyInterestRate = interestRate / (years*12);
            numberOfPayments = years * 12;

            monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - (1 / Math.pow (1 + monthlyInterestRate, numberOfPayments)));

            TextView msg = new TextView(this);
            msg.setVisibility(TextView.VISIBLE);
            msg.setText("Loan_amount: $" + loanAmount + "\nYears: " + years + "\nInterest rate: %" + interestRate
                    + "\n\nMonthly Payment: $" + monthlyPayment + "\nMonthly Interest rate: %" + monthlyInterestRate +
                    "\nNumber of Payments: " + numberOfPayments);
            ll.addView(msg);
        }
        else {
            TextView msg = new TextView(this);
            msg.setVisibility(TextView.VISIBLE);
            msg.setText("Loan_amount: $0" + "\nYears: 0" + "\nInterest rate: %0" +
                    "\n\nMonthly Payment: $0" + "\nMonthly Interest rate: %0" + "\nNumber of Payments: 0");
            ll.addView(msg);
        }
    }
}
