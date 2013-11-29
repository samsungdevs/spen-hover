package com.example.hoverexample;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initSPen();
		
	}

	private void initSPen() {
		
		img = (ImageView) (findViewById(R.id.imageView1) );
		final TextView tv = (TextView) (findViewById(R.id.textView1) );
		img.setOnHoverListener(new OnHoverListener() {

			@Override
			public boolean onHover(View v, MotionEvent event) {
				Log.d("Hover", "On the image");
				if(event.getAction() == MotionEvent.ACTION_HOVER_ENTER) {
					tv.setText("Enter");
					img.animate().scaleX((float)(1.2)).scaleY((float)(1.2)).setDuration(100).withLayer() ;
				}
				else if(event.getAction() == MotionEvent.ACTION_HOVER_EXIT) {
					tv.setText("Exit");
					img.animate().scaleX((float)(1)).scaleY((float)(1)).setDuration(100).withLayer() ;
				}
				else if(event.getButtonState() == MotionEvent.BUTTON_SECONDARY) {
					tv.setText("Button");
				}
				return false;
			}
			

		});
		img.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Log.d("EVT", event.getActionIndex() + "");
				return false;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
