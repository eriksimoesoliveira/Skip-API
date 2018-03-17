package br.com.skip.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestConsumer {

	private String url;
	private String requestMethod;
	
	public RestConsumer(String url, String requestMethod) {
		this.url = url;
		this.requestMethod = requestMethod;
	}
	
	public String execute() {
		
		try {

			URL url = new URL(this.url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requestMethod);
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String resp = "";
					
			while ((output = br.readLine()) != null) {
				resp += output;
			}
			
			conn.disconnect();

			return resp;
		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		
		return null;

		
	}
	
	
	
}
