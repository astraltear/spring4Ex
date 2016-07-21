package com.astraltear.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientTest {

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 100; i++) {
			
			Thread.sleep(500);
			
			String url = "http://1.201.137.80:8088/audienCutter/insertTaskList?userno="+(i)+"&installmentid=CM000000"+(i+1)+"&startSec=20&timeLength=60";
			
			System.out.println(url);
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);
			
			HttpResponse response;
			try {
				response = client.execute(request);
				
				System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
				
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("END");
	}

}
