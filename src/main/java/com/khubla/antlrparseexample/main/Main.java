package com.khubla.antlrparseexample.main;

import java.io.InputStream;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.khubla.antlrparseexample.DocumentParser;

/**
 * @author tom
 */
public class Main {
   /**
    * main
    */
   static public void main(String args[]) throws Exception {
      final String url = args[0];
      System.out.println("Fetching " + url);
      final CloseableHttpClient httpclient = HttpClients.createDefault();
      final HttpGet httpGet = new HttpGet(url);
      final CloseableHttpResponse response = httpclient.execute(httpGet);
      InputStream inputStream = null;
      try {
         inputStream = response.getEntity().getContent();
         System.out.println("Parsing " + url);
         DocumentParser.parse(inputStream);
      } finally {
         response.close();
      }
   }
}
