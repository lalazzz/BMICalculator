package com.michelletan11nov17.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private float height, weight , BMI;

    @Override //Methods
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //if comment this then you cant see the layout
        Log.v("Mia Class", "onCreate invoked");

        //Initialize the variables
        Button compute_button = (Button) findViewById(R.id.compute_button);
        final EditText edit_height = (EditText) findViewById(R.id.height);
        final EditText edit_weight = (EditText) findViewById(R.id.weight);
        final TextView BMI_result = (TextView) findViewById(R.id.bmiResult); //final means this cannot be change

        //Event triggered by user
        compute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_height.getText().length() > 0 && edit_weight.getText().length() > 0) {

                    height = Float.parseFloat(edit_height.getText().toString());
                    weight = Float.parseFloat(edit_weight.getText().toString());

                    BMI = calculateBMI(weight, height); //calling a method calculate BMI
                    //Change the string to two decimal place
                    String BMIstr = String.format("%.2f", BMI);

                    if (BMI < 16) {
                        BMI_result.setText("Your BMI is "+ BMIstr + " :Severely Underweight");
                    }
                    else if (BMI < 18.5) {
                        BMI_result.setText("Your BMI is "+ BMIstr + " : Underweight");
                    }
                    else if (BMI < 25) {
                        BMI_result.setText("Your BMI is "+ BMIstr + " : Normal");
                    }
                    else if (BMI < 30) {
                        BMI_result.setText("Your BMI is "+ BMIstr + " : Overweight");
                    }
                    else{
                        BMI_result.setText("Your BMI is "+ BMIstr + " : Obese");
                    }

                }

                else{

                    Toast toast=Toast.makeText(getApplicationContext(),"Please input a valid number.",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }//End of on Create

    @Override
    protected void onPause() {
        super.onPause();
        //Save any game can be put here, cause this is guaranteed to be executed.
        Log.v("Mia Class", "onPause invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Mia Class","OnDestroy invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Mia Class", "onRestart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Mia Class", "onResume invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Mia Class", "onStart invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Mia Class", "onStop invoked");
    }

    private float calculateBMI(float weight, float height) {
        height = height/100;
        return (weight/ (height*height));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
