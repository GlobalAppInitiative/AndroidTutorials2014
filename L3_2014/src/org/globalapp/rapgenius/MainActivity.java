package org.globalapp.rapgenius;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends ActionBarActivity {
	
	// Define all our variables outside any methods
	// so that they are global
	RadioGroup button_group;
	RadioButton tupac, eminem, asap;
	Button button;
	Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Get references to our views defined in the layout file
        button_group = (RadioGroup) findViewById(R.id.radio_group);
        tupac = (RadioButton) findViewById(R.id.tupac);
        eminem = (RadioButton) findViewById(R.id.eminem);
        asap = (RadioButton) findViewById(R.id.asap);
        button = (Button) findViewById(R.id.click_button);
        
        /* * * * * * * * * * * *
         * 
         *	The click listener
         *	builds the alert
         *	dialog, grabs a 
         *	lyric message
         *	and then displays
         *	the alert
         *
         * * * * * * * * * * * */
        OnClickListener clickListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Lyrics!");
				builder.setMessage(getMessage());
				AlertDialog alert = builder.create();
				alert.show();
			}
        };
        
        // Attach the clickListener to the button
        button.setOnClickListener(clickListener);
    
        
    }
    
    /* * * * * * * * * * * *
     * 
     *	getMessage() is a
     *	"parent" method in
     *	that it contains the
     *	logic to decide which
     *	message method
     *	we should call
     *
     * * * * * * * * * * * */
    
    public String getMessage() {
    	
    	// IDs are stored as integers. We get the radio button that is 
    	// checked within the radio group and then use a switch statement
    	// to return the correct lyric
    	int id_checked = button_group.getCheckedRadioButtonId();
    	
    	// Here is the switch statement where we decide which lyric to return
    	switch (id_checked) {
    	case R.id.tupac:
    		return getTupacLyrics();
    	case R.id.eminem:
    		return getEminemLyrics();
    	case R.id.asap:
    		return getAsapLyrics();
    	default:
    		return "No artist selected.";	
    	}
    		
    }
    
    /* * * * * * * * * * * *
     * 
     *	These methods randomly
     *  choose an index within
     *  a String array to
     *  return. Feel free to
     *  add more Strings in 
     *  these arrays
     *
     * * * * * * * * * * * */
    
    public String getTupacLyrics() {
    	String[] allLyrics = {
    			"You could get the finger.. the middle!",
    			"And the media is greedier than most",
    			"It's just me against the world"
    	};
    	int num = (int) Math.round(Math.random()*2);
    	return allLyrics[num];
    }
    
    public String getAsapLyrics() {
    	String[] allLyrics = {
    			"Sha-Shabba Ranks",
    			"Eight gold rings like I'm Sha-Shabba Ranks",
    			"Four gold chains like I'm Sha-Shabba Ranks"
    	};
    	int num = (int) Math.round(Math.random()*2);
    	return allLyrics[num];
    }
    
    public String getEminemLyrics() {
    	String[] allLyrics = {
    			"I'm beginning to feel like a Rap God",
    			"All my people from the front to the back",
    			"But for me to rap like a computer must be in my genes"
    	};
    	int num = (int) Math.round(Math.random()*2);
    	return allLyrics[num];
    }
   
}
