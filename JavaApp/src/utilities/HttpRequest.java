package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;

import java.net.URL;

public class HttpRequest {
	
	public static StringBuffer getRequest(String url) {
		URL urlReq;
		HttpURLConnection connection;
		try {
			urlReq = new URL(url);
			connection = (HttpURLConnection) urlReq.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			int respCode = connection.getResponseCode();
			if(respCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer buff = new StringBuffer();
				String tmp = null;
				while((tmp = in.readLine()) != null) {
					buff.append(tmp);
				}
				in.close();
				connection.disconnect();
				return buff;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static StringBuffer postRequest(String url, String params) {
		URL urlReq;
		HttpURLConnection connection;
		try {
			urlReq = new URL(url);
			connection = (HttpURLConnection) urlReq.openConnection();
			connection.setRequestMethod("POST");
			connection.setInstanceFollowRedirects(false);
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			connection.setRequestProperty("Accept", "application/json");
			connection.setDoOutput(true);
			OutputStream ostr = connection.getOutputStream();
			byte[] postData = params.getBytes("utf-8");
			connection.setRequestProperty("Content-Length", "" + postData.length);
			ostr.write(postData);
			ostr.flush();
			ostr.close();
			connection.connect();
			
			int respCode = connection.getResponseCode();
			if(respCode == HttpURLConnection.HTTP_CREATED) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
				StringBuffer buff = new StringBuffer();
				String tmp = null;
				while((tmp = in.readLine()) != null) {
					buff.append(tmp);
				}
				in.close();
				connection.disconnect();
				return buff;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
