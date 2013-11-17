package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createClickEvents();
    }
	private void createClickEvents() {
		
		//Fix this up to go by ID.
		LinearLayout cKey = (LinearLayout) findViewById(R.id.piano_key_c);
		cKey.setSoundEffectsEnabled(false);
		cKey.setOnClickListener(new View.OnClickListener()
		{
		    @Override
		    public void onClick(View V)
		    {
		        playNote(V, R.raw.pianoc);
		    }
		});
		LinearLayout csKey = (LinearLayout) findViewById(R.id.piano_key_cs);
		csKey.setSoundEffectsEnabled(false);
		csKey.setOnClickListener(new View.OnClickListener()
		{
		    @Override
		    public void onClick(View V)
		    {
		        playNote(V, R.raw.pianocs);
		    }
		});
		LinearLayout dKey = (LinearLayout) findViewById(R.id.piano_key_d);
		dKey.setSoundEffectsEnabled(false);
		dKey.setOnClickListener(new View.OnClickListener()
		{
		    @Override
		    public void onClick(View V)
		    {
		        playNote(V, R.raw.pianod);
		    }
		});
		
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//EditText is a class of "view object"
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    //make static player!
    public void playNote(View view, int resid) {
        // Play a Note
    	MediaPlayer clip = MediaPlayer.create(getApplicationContext(), resid);
    	clip.start();	 
    }
}
