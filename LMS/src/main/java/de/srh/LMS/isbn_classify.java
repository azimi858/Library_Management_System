package de.srh.LMS;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
public class isbn_classify {

        private static final String USER_AGENT = "Mozilla/5.0";
        private static final String GET_URL = "http://classify.oclc.org/classify2/Classify?&summary=true";


        public static void sendGET(String ISBN) throws IOException {
            URL obj = new URL(GET_URL+"&isbn="+ISBN);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                //response -> to be parsed to get Title, Author and Description


                //xml parsing



                System.out.println(response.toString());
            } else {
                System.out.println("GET request did not work.");
            }

        }



    }



