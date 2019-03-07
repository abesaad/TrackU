package com.uninorte.edu.co.tracku.networking;

import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceManager {

    public static void CallWebServiceOperation(final WebServiceManagerInterface  caller,
                                               final String  webServiceURL,
                                               final String resourceName,
                                               final String operation,
                                               final String methodType,
                                               final String payload,
                                               final String userState){

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL(webServiceURL+"/"+resourceName+"/"+operation);
                    HttpURLConnection httpURLConnection= (HttpURLConnection)url.openConnection();
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(methodType);
                    httpURLConnection.getOutputStream().write(payload.getBytes());
                    int responseCode=httpURLConnection.getResponseCode();
                    if(responseCode==HttpURLConnection.HTTP_OK){
                        InputStream in=httpURLConnection.getInputStream();
                        StringBuffer stringBuffer=new StringBuffer();
                        int charIn=0;
                        while((charIn=in.read())!=-1){
                            stringBuffer.append((char)charIn);
                        }
                        caller.WebServiceMessageReceived(userState,stringBuffer.toString());
                    }

                }catch (Exception error){

                }
            }
        });



    }
}
