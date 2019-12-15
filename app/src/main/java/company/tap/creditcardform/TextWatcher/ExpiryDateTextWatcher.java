package company.tap.creditcardform.TextWatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Calendar;

public class ExpiryDateTextWatcher implements TextWatcher {

    private EditText mEditText;

    public ExpiryDateTextWatcher(EditText editText) {
        mEditText = editText;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String working = s.toString();
        boolean isValid = true;
        if (working.length()==2 && before ==0) {
            if (Integer.parseInt(working) < 1 || Integer.parseInt(working)>12) {
                isValid = false;
            } else {
                working+="/";
                mEditText.setText(working);
                mEditText.setSelection(working.length());
            }
        }
        else if (working.length()==5 && before ==0) {
            String x = "20";
            String enteredYear = x.concat(working.substring(3,5));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (Integer.parseInt(enteredYear) < currentYear) {
                isValid = false;
            }
        } else if (working.length()!=5) {
            isValid = false;
        }

        if (!isValid) {
            mEditText.setError("Enter a valid date: MM/YY");
        } else {
            mEditText.setError(null);
        }

    }


    public void afterTextChanged(Editable s) {}


    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}



}



