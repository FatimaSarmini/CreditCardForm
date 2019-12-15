package company.tap.creditcardform.Validation;


import android.widget.EditText;
import android.widget.TextView;

public class validation {

    private EditText editText;


    public validation(EditText editText)
    {
        this.editText= editText;

    }


    public Boolean validate() {

        String text = editText.getText().toString().trim();

        if (text.isEmpty()) {
            return false;
        }
        else
            return true;

        }
    }

