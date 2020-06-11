package com.example.bened.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.widget.TextView;

import static com.example.bened.helloandroid.R.id;
import static com.example.bened.helloandroid.R.layout;
import static com.example.bened.helloandroid.R.string;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        /*
        * THIS CODE RUNS ON EMULATOR
        * THIS CODE CRASHES THE APP ON MY SAMSUNG MOBILE PHONE
        */

        TextView txtPhoneUdacity  = (TextView) findViewById(id.phone_text);
        if (txtPhoneUdacity  != null) {
        removeUnderlines((Spannable) txtPhoneUdacity .getText());
        }

        /*
        * THIS CODE RUNS ON EMULATOR
        * THIS CODE RUNS THE APP ON MY SAMSUNG MOBILE PHONE
        * BUT THE LINK TO THE PHONE NUMBER IS NO LONGER CLICKABLE
        */

        /*TextView txtPhoneUdacity = findViewById(id.phone_text);
        txtPhoneUdacity.setText(string.phone_number, TextView.BufferType.SPANNABLE);
        removeUnderlines((Spannable) txtPhoneUdacity.getText());
        */

        // Remove underlines from HTML links(mail)
        TextView txtMailUdacity = findViewById(id.mail_text);
        //Make sure the TextView was instantiated correctly
        if (txtMailUdacity != null) {
            removeUnderlines((Spannable) txtMailUdacity.getText());
        }

        // Remove underlines from HTML links(url Udacity)
        TextView txtUrlUdacity = findViewById(id.web_text);
        // Make sure the TextView was instantiated correctly
        if (txtUrlUdacity != null) {
            removeUnderlines((Spannable) txtUrlUdacity.getText());
        }
    }

    /**
     * Removes URL underlines in a string by replacing URLSpan occurrences by
     * URLSpanNoUnderline objects.
     *
     * @param p_Text A Spannable object. For example, a TextView casted as
     *               Spannable.
     */
    public void removeUnderlines(Spannable p_Text) {
        URLSpan[] spans = p_Text.getSpans(0, p_Text.length(), URLSpan.class);

        for (URLSpan span : spans) {
            int start = p_Text.getSpanStart(span);
            int end = p_Text.getSpanEnd(span);
            p_Text.removeSpan(span);
            span = new URLSpanNoUnderline(span.getURL());
            p_Text.setSpan(span, start, end, 0);
        }
    }
}