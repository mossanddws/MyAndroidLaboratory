package mossand.myandroidlaboratory;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {
    private TextView textView;
    private EditText plainText;
    private EditText password;
    private EditText passwordNumeric;
    private EditText email;
    private EditText phone;
    private EditText postalAddress;
    private EditText multilineText;
    private EditText time;
    private EditText date;
    private EditText number;
    private EditText numberSigned;
    private EditText numberDecimal;
    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;
    private CheckedTextView checkedTextView;
    //private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        initView(); //Bind all the Text Widgets.
        setAllText();   //Sets each Text Widgets's hint.
    }

    /**
     *  This method binds all the Text Widgets.
     */
    private void initView() {
        textView = findViewById(R.id.textView);
        plainText = findViewById(R.id.editText_PlainText);
        password = findViewById(R.id.editText_Password);
        passwordNumeric = findViewById(R.id.editText_Password_Numeric);
        email = findViewById(R.id.editText_Email);
        phone = findViewById(R.id.editText_Phone);
        postalAddress = findViewById(R.id.editText_PostalAddress);
        multilineText = findViewById(R.id.editText_MultilineText);
        time = findViewById(R.id.editText_Time);
        date = findViewById(R.id.editText_Date);
        number = findViewById(R.id.editText_Number);
        numberSigned = findViewById(R.id.editText_Number_Signed);
        numberDecimal = findViewById(R.id.editText_Number_Decimal);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        checkedTextView = findViewById(R.id.checkedTextView);
        //textInputLayout = findViewById(R.id.textInputLayout);
        textInputEditText = findViewById(R.id.textInputEditText);
    }

    /**
     *  This method sets each Text Widgets's hint.
     */
    private void setAllText() {
        textView.setHint("This is TextView.");
        plainText.setHint("This is Plain Text.");
        password.setHint("This is Password.");
        passwordNumeric.setHint("This is Password (Numeric).");
        email.setHint("This is Email.");
        phone.setHint("This is phone.");
        postalAddress.setHint("This is Postal Address.");
        multilineText.setHint("This is Multiline Text.");
        time.setHint("This is Time.");
        date.setHint("This is Date.");
        number.setHint("This is Number.");
        numberSigned.setHint("This is Number (Signed).");
        numberDecimal.setHint("This is Number (Decimal).");
        autoCompleteTextView.setHint("This is AutoCompleteTextView.");
        multiAutoCompleteTextView.setHint("This is MultiAutoCompleteTextView.");
        checkedTextView.setHint("This is CheckedTextView.");
        textInputEditText.setHint("This is TextInputEditText.");
    }
}
