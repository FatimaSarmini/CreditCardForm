package company.tap.creditcardform.TextWatcher;



import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class CVVTextWatcher implements TextWatcher{
    private EditText etCard;
    private TextView tvCard;
    private boolean isDelete;

    public CVVTextWatcher(EditText etcard,TextView tvcard) {
        this.etCard=etcard;
        this.tvCard=tvcard;
    }

    public CVVTextWatcher(EditText etcard) {
        this.etCard=etcard;
    }


    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(before==0)
            isDelete=false;
        else
            isDelete=true;
    }


    public void afterTextChanged(Editable s) {
        String source = s.toString();
        int length=source.length();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(source);

        if(length>3){
            if(isDelete)
                stringBuilder.deleteCharAt(length-1);
            etCard.setText(stringBuilder);
            etCard.setSelection(etCard.getText().length());
        }

        if(tvCard!=null)
        {
            if(length==0)
                tvCard.setText("CVV");
            else
                tvCard.setText(stringBuilder);
        }

    }

}