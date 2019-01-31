package com.example.pipsa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.Toast;

import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.io.StringReader;

public class FifthActivity extends AppCompatActivity {
    private String LOG_TAG = "XML";
    private int UpdateFlag = 0;
    InputSource inputSource = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        new GetXMLFromServer().execute();
    }

    public void ParseXML(String xmlString){

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlString));
            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){

                if(eventType== XmlPullParser.START_TAG){

                    String name = parser.getName();
                    if(name.equals("UpdateFlag")){

                        String ref = parser.getAttributeValue(null,"ref");
                        Log.d(LOG_TAG,"ref:" + ref);

                        if(parser.next() == XmlPullParser.TEXT) {
                            String UpdateFlag = parser.getText();
                            Log.d(LOG_TAG,"UpdateFlag:" + UpdateFlag);
                        }


                    }else if(name.equals("Name")) {

                        if(parser.next() == XmlPullParser.TEXT) {
                            String Name = parser.getText();
                            Log.d(LOG_TAG,"Name:" + Name);
                        }
                    }else if(name.equals("Range")) {

                        if(parser.next() == XmlPullParser.TEXT) {
                            String Range = parser.getText();
                            Log.d(LOG_TAG,"Range:" + Range);
                        }
                    }


                }else if(eventType== XmlPullParser.END_TAG){


                }
                eventType = parser.next();

            }


        }catch (Exception e){
            Log.d(LOG_TAG,"Error in ParseXML()",e);
        }

    }

    private class GetXMLFromServer extends AsyncTask<String,Void,String> {

        HttpHandler nh;

        @Override
        protected String doInBackground(String... strings) {

            String URL = "http://androidpala.com/tutorial/horoscope.xml";
            String res= "";
            nh =  new HttpHandler();
            InputStream is = nh.CallServer(URL);
            if(is!=null){

                res = nh.StreamToString(is);

            }else{
                res = "NotConnected";
            }

            return res;
        }
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if(result.equals("NotConnected")){

                Toast.makeText(getApplicationContext(),"Not Connect To Server",Toast.LENGTH_SHORT).show();

            }else {
                ParseXML(result);
            }
        }



    }
}
