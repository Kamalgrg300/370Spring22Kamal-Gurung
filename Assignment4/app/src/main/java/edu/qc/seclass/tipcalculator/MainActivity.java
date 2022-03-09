package edu.qc.seclass.tipcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
        import android.content.Context;
import android.widget.Toast;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Button;
        import android.view.inputmethod.InputMethodManager;
public class MainActivity extends AppCompatActivity {
    int SizeOfTheParty;
    double AmountChecking;
    EditText checkAmountInput;
    Button initializingKeypad;
    EditText inputSizeOfParty;
    EditText tippercentageis15;
    EditText tippercentageis20;
    EditText tippercentageis25;
    EditText totalof20percentage;
    EditText totalof15percentage;
    EditText totalof25percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkAmountInput = findViewById(R.id.inputCheckAmount);
        inputSizeOfParty = findViewById(R.id.partySizeValue);
        initializingKeypad = findViewById(R.id.buttonCompute);
        initializingKeypad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                if(checkAmountInput.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Type in the amount needed to be checked: ", Toast.LENGTH_LONG).show(); }
                else if
                (inputSizeOfParty.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "Type in the needed size of the party:", Toast.LENGTH_LONG).show(); }
                else if
                (Integer.valueOf(inputSizeOfParty.getText().toString()) == 0) {
                    Toast.makeText(getApplicationContext(), "Cannot divide by 0 party size", Toast.LENGTH_LONG).show(); }
                else   {
                    tippercentageis15 = findViewById(R.id.fifteenPercentTotalValue);
                    tippercentageis20 = findViewById(R.id.twentyPercentTipValue);
                    tippercentageis25 = findViewById(R.id.twentyfivePercentTipValue);
                    totalof15percentage = findViewById(R.id.fifteenPercentTotalVal);
                    totalof20percentage = findViewById(R.id.twentyPercentTotalValue);
                    totalof25percentage = findViewById(R.id.twentyfivePercentTotalValue);
                    AmountChecking = Double.valueOf(checkAmountInput.getText().toString());
                    SizeOfTheParty = Integer.valueOf((inputSizeOfParty.getText().toString()));
                    tippercentageis15.setText(String.valueOf(calculateTip(AmountChecking, SizeOfTheParty, 0.15)));
                    tippercentageis20.setText(String.valueOf(calculateTip(AmountChecking, SizeOfTheParty, 0.20)));
                    tippercentageis25.setText(String.valueOf(calculateTip(AmountChecking, SizeOfTheParty, 0.25)));
                    totalof15percentage.setText(String.valueOf(calculateTotal(AmountChecking, SizeOfTheParty, 0.15)));
                    totalof20percentage.setText(String.valueOf(calculateTotal(AmountChecking, SizeOfTheParty, 0.20)));
                    totalof25percentage.setText(String.valueOf(calculateTotal(AmountChecking, SizeOfTheParty, 0.25)));
                } }   }
        );
    }
    public int calculateTip(double checkAmount, int sizeoftheparty, double percentage){
        int alltotal = (int) Math.ceil((checkAmount / sizeoftheparty) * percentage);
        return  alltotal;
    }
    public int calculateTotal(double Amountchecking, int sizeoftheparty, double percentage){
        double tip = ((Amountchecking / sizeoftheparty) * percentage);
        int entiretotal = (int) Math.ceil((Amountchecking / sizeoftheparty) + tip);
        return  entiretotal;
    }
    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } }  }