package company.tap.creditcardform;

import androidx.appcompat.app.AppCompatActivity;
import company.tap.creditcardform.TextWatcher.CVVTextWatcher;
import company.tap.creditcardform.TextWatcher.CardNumberTextWatcher;
import company.tap.creditcardform.TextWatcher.ExpiryDateTextWatcher;
import company.tap.creditcardform.Validation.validation;
import company.tap.creditcardform.Views.CreditCardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public  static EditText editTxtCardNumber;
    public  static EditText cardDateEditText;
    public  static EditText cardCVVEditText;
    public  static EditText FullNameEditText;

    private Button submit ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTxtCardNumber = (EditText) findViewById(R.id.cardNumberEditText);
        cardDateEditText = (EditText) findViewById(R.id.cardDateEditText);
        cardCVVEditText = (EditText) findViewById(R.id.cardCVVEditText);
        FullNameEditText = (EditText) findViewById(R.id.FullNameEditText);

        submit = (Button) findViewById(R.id.btn_submit);


        editTxtCardNumber.addTextChangedListener(new CardNumberTextWatcher(editTxtCardNumber));
        cardDateEditText.addTextChangedListener(new ExpiryDateTextWatcher(cardDateEditText));
        cardCVVEditText.addTextChangedListener(new CVVTextWatcher(cardCVVEditText));


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validation f1 = new validation(editTxtCardNumber);
                validation f2 = new validation(cardDateEditText);
                validation f3 = new validation(cardCVVEditText);
                validation f4 = new validation(FullNameEditText);

                if(f1.validate() && f2.validate() && f3.validate() && f4.validate() ) {
                    Intent intent = new Intent(MainActivity.this, CreditCardView.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Fields can't be empty", Toast.LENGTH_LONG).show();
            }
        });


}
    }