package me.kmannix.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	/* * * * * * * * * * *
	 * 
	 * Declare Views outside
	 * any method to make
	 * them global
	 * 
	 * * * * * * * * * * */
	
	Context context = this; // Context its the context of current state of 
							// the application/object. 
							// It lets newly created objects understand 
							// what has been going on.
							// Check out this StackOverflow question/answer
							// http://stackoverflow.com/questions/3572463/what-is-context-in-android
	TextView text_output;
	EditText money;
	Button calculate;
	RadioGroup percentages;
	double percentage = 0.05; // Our initial percentage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Define Views to create references to the Views
        // in activity_main.xml
        
        text_output = (TextView) findViewById(R.id.text_output);
        money = (EditText) findViewById(R.id.money);
        calculate = (Button) findViewById(R.id.calculate_tip);
        percentages = (RadioGroup) findViewById(R.id.tip_amount);
        
        /* * * * * * * * * * *
    	 * 
    	 * Create listeners
    	 * 
    	 * * * * * * * * * * */
        
        // Create listeners for Radio Group
        OnCheckedChangeListener radioButtonChange = new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.five:
					percentage = 0.05;
					break;
				case R.id.ten:
					percentage = 0.10;
					break;
				case R.id.fifteen:
					percentage = 0.15;
					break;
				default:
					percentage = 0.05;
					break;
				}
			}
        };
        
        // Create listener for Button
        OnClickListener buttonClicked = new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				// Check if we have the valid input in our EditTexts
				boolean validInput = isValidInput(money.getText().toString());
				
				if (validInput) {
					
					// If we have valid input, convert strings 
					// to doubles and send to 
					// our "calculateTip()" method
					
					double tip = calculateTip(money.getText().toString(), percentage);
					
					// We now have the tip, so plug this into our TextView
					text_output.setText("You should tip:\n$" + 
										String.format("%.2f", tip));
					
					
				} else {
					// Invalid input
					Toast.makeText(context, "Invalid Input", Toast.LENGTH_LONG).show();
				}
				
			}
        };
        
        /* * * * * * * * * * *
    	 * 
    	 * Attach listeners
    	 * to objects
    	 * 
    	 * * * * * * * * * * */
        
        calculate.setOnClickListener(buttonClicked);
        percentages.setOnCheckedChangeListener(radioButtonChange);
        
    }
    
    /* * * * * * * * * * *
	 * 
	 * Calculate Tip
	 * 
	 * * * * * * * * * * */

	protected boolean isValidInput(String input) {
		if (!input.equals("") && 
			input.contains(".") && 
			!input.startsWith(".") && 
			input.substring(input.indexOf('.')).length() == 3) return true;
		return false;
	}

	protected double calculateTip(String moneyText, double percent) {
		double total = Double.parseDouble(moneyText);
		return Math.round(total*percent);
	}

}
