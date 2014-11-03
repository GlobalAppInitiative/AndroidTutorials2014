package me.kmannix.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	/* * * * * * * * * * *
	 * 
	 * Declare Views outside
	 * any method to make
	 * them global
	 * 
	 * * * * * * * * * * */
	
	TextView text_output;
	EditText dollars, cents;
	Button calculate;
	RadioGroup percentages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Define Views to create references to the Views
        // in activity_main.xml
        
        text_output = (TextView) findViewById(R.id.text_output);
        dollars = (EditText) findViewById(R.id.dollars);
        cents = (EditText) findViewById(R.id.cents);
        calculate = (Button) findViewById(R.id.calculate_tip);
        percentages = (RadioGroup) findViewById(R.id.tip_amount);
        
        
        
    }

}
