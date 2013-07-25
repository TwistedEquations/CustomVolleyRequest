package com.te.customvolleyrequest;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.te.customvolleyrequest.MainActivity.ByteArrayResponseListener;

public class ByteArrayRequest extends Request<byte[]> {

	ByteArrayResponseListener byteListener;
	public ByteArrayRequest(int method, String url, ByteArrayResponseListener byteListener, ErrorListener listener) {
		super(method, url, listener);
		this.byteListener = byteListener;
	}

	@Override
	protected Response<byte[]> parseNetworkResponse(NetworkResponse response) {
		byte[] data = response.data;
		
		if(data!=null)
			return Response.success(data, HttpHeaderParser.parseCacheHeaders(response));
		else
			return Response.error(new VolleyError());
	}

	@Override
	protected void deliverResponse(byte[] response) {
		byteListener.onByteArrayResponse(response);
		
	}
	
	

}
