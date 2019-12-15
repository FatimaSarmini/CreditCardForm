package company.tap.creditcardform.Views;

import androidx.appcompat.app.AppCompatActivity;
import company.tap.creditcardform.MainActivity;
import company.tap.creditcardform.R;

import android.os.Bundle;
import android.widget.TextView;

public class CreditCardView extends AppCompatActivity {

    private   TextView cardNumber;
    private   TextView cardDate;
    private   TextView cardCVV;
    private   TextView cardName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_view);

        cardNumber = (TextView) findViewById(R.id.cardNumberView);
        cardDate = (TextView) findViewById(R.id.cardDateView);
        cardCVV = (TextView) findViewById(R.id.cardCvvView);
        cardName = (TextView) findViewById(R.id.FullNameView);

        cardNumber.setText(MainActivity.editTxtCardNumber.getText().toString());
        cardDate.setText(MainActivity.cardDateEditText.getText().toString());
        cardCVV.setText(MainActivity.cardCVVEditText.getText().toString());
        cardName.setText(MainActivity.FullNameEditText.getText().toString());
    }
}
