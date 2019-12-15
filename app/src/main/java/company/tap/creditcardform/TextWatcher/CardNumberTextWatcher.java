package company.tap.creditcardform.TextWatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class CardNumberTextWatcher implements TextWatcher {

    private EditText creditCard;
    private String beforeText, currentText;
    private boolean noAction, addStroke, dontAddChar, deleteStroke;

    public CardNumberTextWatcher(EditText creditCard) {
        // TODO Auto-generated constructor stub
        this.creditCard = creditCard;
        noAction = false;
        addStroke = false;
        dontAddChar = false;
        deleteStroke = false;
    }

    /* here I save the previous string if the max character had achieved */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // TODO Auto-generated method stub
        Log.i("TextWatcherImplement", "beforeTextChanged start==" + String.valueOf(start) + " count==" + String.valueOf(count) + " after==" + String.valueOf(after));
        if (start >= 19)
            beforeText = s.toString();
    }


    /* here I check were we add a character, or delete one.
    if we add character and it is time to add a stroke, then I flag it -> addStroke
    if we delete a character and it time to delete a stroke, I flag it -> deleteStroke
    if we are in max character for the credit card, don't add char -> dontAddChar
    */
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // TODO Auto-generated method stub
        Log.i("TextWatcherImplement", "onTextChanged start==" + String.valueOf(start) + " before==" + String.valueOf(before) + " count==" + String.valueOf(count) + " noAction ==" + String.valueOf(noAction));
        if ((before < count) && !noAction) {
            if ((start == 3) || (start == 8) || (start == 13)) {
                currentText = s.toString();
                addStroke = true;
            } else if (start >= 19) {
                currentText = s.toString();
                dontAddChar = true;
            }
        } else {
            if ((start == 4) || (start == 9) || (start == 14)) { //(start == 5) || (start == 10) || (start == 15)
                currentText = s.toString();
                deleteStroke = true;
            }
        }
    }

/* noAction flag is when we change the text, the interface is being called again.
the NoAction flag will prevent any action, and prevent a ongoing loop */

    @Override
    public void afterTextChanged(Editable stext) {
        // TODO Auto-generated method stub
        if (addStroke) {
            Log.i("TextWatcherImplement", "afterTextChanged String == " + stext + " beforeText == " + beforeText + " currentText == " + currentText);
            noAction = true;
            addStroke = false;
            creditCard.setText(currentText + " ");
        } else if (dontAddChar) {
            dontAddChar = false;
            noAction = true;
            creditCard.setText(beforeText);
        } else if (deleteStroke) {
            deleteStroke = false;
            noAction = true;
            currentText = currentText.substring(0, currentText.length() - 1);
            creditCard.setText(currentText);
        } else {
            noAction = false;
            creditCard.setSelection(creditCard.getText().length()); // set cursor at the end of the line.
        }
    }
}