package com.te.customvolleyrequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {
TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
		
		RequestQueue queue = Volley.newRequestQueue(this);
		ByteArrayRequest request = new ByteArrayRequest(Request.Method.GET, "https://gdata.youtube.com/feeds/api/videos?q=surfing&v=2&alt=jsonc&max-results=1", byteListener, error);
		queue.add(request);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	ByteArrayResponseListener byteListener = new ByteArrayResponseListener(){
		@Override
		public void onByteArrayResponse(byte[] response) {
			String text = response.toString();
			textView.setText(text);
		}
		
	};
	
	ErrorListener error = new ErrorListener(){
		@Override
		public void onErrorResponse(VolleyError error) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public interface ByteArrayResponseListener{
		
		public void onByteArrayResponse(byte[] response);
	}

}
