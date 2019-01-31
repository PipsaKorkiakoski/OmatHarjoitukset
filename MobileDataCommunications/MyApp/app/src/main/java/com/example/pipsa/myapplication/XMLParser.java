package com.example.pipsa.myapplication;


import android.os.AsyncTask;

import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class XMLParser extends AsyncTask {
    URL url;
    ArrayList<String> headlines = new ArrayList();
    ArrayList<String> links = new ArrayList();
    InputSource inputSource = null;

    @Override
    protected Object doInBackground(Object[] objects){
        try {
            url = new URL(
                    "http://feeds.bbci.co.uk/news/rss.xml?edition=uk");
            inputSource = new InputSource(url.openStream());
           // url = new URL("http://feeds.bbci.co.uk/news/rss.xml?edition=uk");

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();

            // We will get the XML from an input stream
           // xpp.setInput(getInputStream(url), "UTF_8");
            xpp.setInput(url.openConnection().getInputStream(),"UTF_8");

            boolean insideItem = false;

            // Returns the type of current event: START_TAG, END_TAG, etc..
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {

                    if (xpp.getName().equalsIgnoreCase("item")) {
                        insideItem = true;
                    } else if (xpp.getName().equalsIgnoreCase("title")) {
                        if (insideItem)
                            headlines.add(xpp.nextText()); //extract the headline
                    } else if (xpp.getName().equalsIgnoreCase("link")) {
                        if (insideItem)
                            links.add(xpp.nextText()); //extract the link of article
                    }
                } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                    insideItem = false;
                }

                eventType = xpp.next(); //move to next element
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return headlines;
    }



    public ArrayList<String> heads()
    {
        return headlines;
    }

}
