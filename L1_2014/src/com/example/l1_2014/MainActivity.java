package com.example.l1_2014;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	/* * * * * * * * * * * * * * * *
	 * 
	 * 		Set our variables
	 * 
	 * * * * * * * * * * * * * * * */

	// We'll define all our variables within the class
	// so that they're global
	// If you have an error, make sure to import the button by writing
	// import android.widget.Button; at the top of the file
	Button colorButton; // This will change the color
	Button textButton; // When the text button is clicked, 
					   // it will update the text
	EditText text_input; // This is the input text field
	TextView text; // The text that is displayed
	RelativeLayout background; // This is the layout itself, and we
							   // will change its background color
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// SavedInstanceState represents what's currently going
    	// on in the device, and we inform the Android framework of that.
    	// We then set our view to be the layout file activity_main.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /* * * * * * * * * * * * * * * *
    	 * 
    	 * 		Define our variables
    	 * 
    	 * * * * * * * * * * * * * * * */
        
        // Here, we'll define our variables that we declared earlier
        // This way, we can interact in Java with the Views we made in
        // our layout file
        // We need to typecast when return findViewById because that method
        // never knows what type of View it's returning
        colorButton = (Button) findViewById(R.id.color_button);
        textButton = (Button) findViewById(R.id.text_button);
        text = (TextView) findViewById(R.id.textfield);
        text_input = (EditText) findViewById(R.id.inputtext);
        background = (RelativeLayout) findViewById(R.id.activity_layout);
        
        /* * * * * * * * * * * * * * * *
    	 * 
    	 * 		Create ClickListeners
    	 * 
    	 * * * * * * * * * * * * * * * */
        
        // Set our listeners to what we want to do on a click. We'll then
        // attach these listeners to the buttons we've made
        OnClickListener colorButtonListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Grab the layout and set it's background color to whatever
				// returns from our randColor method
				background.setBackgroundColor(pickARandomColor());
			}
        };
        
        OnClickListener textButtonListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// We grab the text from the edit text and 
				// set it as the text of our text view
				String text_in_edit_text = text_input.getText().toString();
				text.setText(text_in_edit_text);
			}
        };
        
        // Now that we have our listeners, lets assign them to views
       colorButton.setOnClickListener(colorButtonListener);
       textButton.setOnClickListener(textButtonListener);
       
    }
    
    /* * * * * * * * * * * * * * * *
	 * 
	 * 		Random Color Method
	 * 
	 * * * * * * * * * * * * * * * */
    
    // Make sure to import "Color" as import android.graphics.Color; in the
    // top of the page
    // We'll be randomly generating a color to choose
    public int pickARandomColor() {
    	int randNum =  (int) Math.round(Math.random() * 4);
    	// The reason we are returning and int is because 
    	// every Color can be represented by an int value
    	if (randNum < 1) {
    		return Color.BLUE;
    	} else if (randNum < 2) {
    		return Color.RED;
    	} else if (randNum < 3) {
    		return Color.GREEN;
    	} else if (randNum < 4) {
    		return Color.YELLOW;
    	} else {
    		return Color.GRAY;
    	}	
    }
    
}
