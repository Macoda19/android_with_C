package com.example.saikatmondal.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    TextView textView;
    EditText editText;
    char operate;
    double val1,val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
       textView = findViewById(R.id.output);
       editText = findViewById(R.id.edittext);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    //public native String stringFromJNI();
    public native double getAnswer(double input1,double input2,char operation);

    public void getfunc(View view){
        switch (view.getId())
        {
            case R.id.sum :
            {
                operate = '+';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText(""+Double.toString(val1)+"+");
                editText.setText(null);
                break;
            }
            case R.id.substract :
            {
                operate = '-';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText(""+Double.toString(val1)+"-");
                editText.setText(null);
                break;
            }
            case R.id.multiply :
            {
                operate = 'x';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText(""+Double.toString(val1)+"x");
                editText.setText(null);
                break;
            }
            case R.id.divide :
            {
                operate = '/';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText(""+Double.toString(val1)+"/");
                editText.setText(null);
                break;
            }
            case R.id.sin :
            {
                operate = 's';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText("sin("+Double.toString(val1)+")");
                editText.setText(null);
                break;
            }
            case R.id.cos :
            {
                operate = 'c';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText("cos("+Double.toString(val1)+")");
                editText.setText(null);
                break;
            }
            case R.id.tan :
            {
                operate = 't';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText("tan("+Double.toString(val1)+")");
                editText.setText(null);
                break;
            }
            case R.id.sqrt :
            {
                operate = 'r';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText("sqrt("+Double.toString(val1)+")");
                editText.setText(null);
                break;
            }
            case R.id.power :
            {
                operate = 'p';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText(""+Double.toString(val1)+"^");
                editText.setText(null);
                break;
            }
            case R.id.factorial :
            {
                operate = 'f';
                val1 = Double.parseDouble(editText.getText().toString());
                textView.setText("Fact("+Double.toString(val1)+")");
                editText.setText(null);
                break;
            }
        }
    }
    public void calculateAndclear(View view){
        switch (view.getId()){
            case R.id.answer :
            {
                if(editText.getText().length()>0)
                    val2 = Double.parseDouble(editText.getText().toString());
                else val2=0.0;
                double ans = getAnswer(val1,val2,operate);
                textView.setText(Double.toString(ans));
                editText.setHint("Enter input");
                break;
            }
            case R.id.clear:
            {
                textView.setText("Output");
                editText.setText(null);
                editText.setHint("Enter input");
                break;
            }
        }
    }
}
