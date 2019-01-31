package com.example.pipsa.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txt = (TextView) findViewById(R.id.txt);
        parseXML();


    }
    private TextView txt;

       private void parseXML() {
        XmlPullParserFactory parserFactory;

        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = getAssets().open("data2.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            processParsing(parser);

        } catch (XmlPullParserException e) {

        } catch (IOException e) {
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException{
        ArrayList<Movie> movies = new ArrayList<>();
        int eventType = parser.getEventType();
        Movie currentMovie = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if ("item".equals(eltName)) {
                        currentMovie = new Movie();
                        movies.add(currentMovie);
                    } else if (currentMovie != null) {
                        if ("title".equals(eltName)) {
                            currentMovie.title = parser.nextText();
                        }else if ("link".equals(eltName)) {
                            currentMovie.link = parser.nextText();
                        }else if ("pubDate".equals(eltName)) {
                            currentMovie.pubDate = parser.nextText();
                        }

                    }
                    break;
            }

            eventType = parser.next();
        }

        printMovies(movies);
    }

    private void printMovies(ArrayList<Movie> movies) {
        StringBuilder builder = new StringBuilder();


        for (Movie movie : movies) {

            builder.append(movie.title).append("\n").
                    append(movie.link).append("\n").
                    //append(movie.description).append("\n").
                    append(movie.pubDate).append("\n\n");
                   // append(movie.guid).append("\n\n");
        }

        txt.setText(builder.toString());
    }
}
