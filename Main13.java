package com.company;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;


public class Main {

public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
            System.out.println("Input query: ");
            Scanner scanner = new Scanner(System.in);
            String query = scanner.nextLine();
            System.out.println(query);//https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=%22Java%22
            final CloseableHttpClient httpclient = HttpClients.createDefault();

            final HttpUriRequest httpGet = new HttpGet(query);
            try (
                    CloseableHttpResponse response1 = httpclient.execute(httpGet)
            ){
                final HttpEntity entity1 = response1.getEntity();
                System.out.println(EntityUtils.toString(entity1));
            }

            final HttpPost httpPost = new HttpPost(query);
            final List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("action", "query"));
            params.add(new BasicNameValuePair("list", "search"));
            params.add(new BasicNameValuePair("srsearch", query));
            params.add(new BasicNameValuePair("utf8", ""));
            params.add(new BasicNameValuePair("srlimit", "20"));
            params.add(new BasicNameValuePair("format", "json"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));


            try (
                    CloseableHttpResponse response2 = httpclient.execute(httpPost)
            ){
                final HttpEntity entity2 = response2.getEntity();
                System.out.println(entity2);
                HashMap<String, String> res = new HashMap<String, String>();

                Iterator itr = response2.headerIterator();

                while(itr.hasNext()) {
                    String key = itr.next().toString();
                    res.put(key, itr.next().toString());
                }
                System.out.println(res);
            }
            httpclient.close();
        }

}
