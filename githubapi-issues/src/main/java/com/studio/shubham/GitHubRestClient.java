package com.studio.shubham;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*
 * Referred most part of code from ClientPreemptiveBasicAuthentication.java and QuickStart.java
 */
public class GitHubRestClient {

  public String requestIssues(String username, String password, String uri)
   throws Exception {

    BufferedReader bufferedReader = null;
    CloseableHttpClient httpclient = null;
    CloseableHttpResponse response = null;
    String jsonContent = null;
    
    try {
      HttpHost target = new HttpHost("api.github.com", 443, "https");
      CredentialsProvider credsProvider = new BasicCredentialsProvider();
      credsProvider.setCredentials(new AuthScope(target.getHostName(),
          target.getPort()), new UsernamePasswordCredentials(username, password));
      httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
      // Create AuthCache instance
      AuthCache authCache = new BasicAuthCache();
      // Generate BASIC scheme object and add it to the local
      // auth cache
      BasicScheme basicAuth = new BasicScheme();
      authCache.put(target, basicAuth);
      // Add AuthCache to the execution context
      HttpClientContext localContext = HttpClientContext.create();
      localContext.setAuthCache(authCache);
      HttpGet httpget = new HttpGet(uri);
      response = httpclient.execute(target, httpget, localContext);
      System.out.println(response.getStatusLine());
      HttpEntity entity = response.getEntity();

      bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));

      jsonContent = bufferedReader.readLine();
      EntityUtils.consume(entity);
      
    } catch (Exception e) {
      System.out.println("Error Message: " + e.getMessage());
    } finally {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
      if (httpclient != null) {
        httpclient.close();
      }
      if (response != null) {
        response.close();
      }
    }
    return jsonContent;
  } 
}
