package com.example.chatroom;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.chatroom.adapter.chatadapter;
import com.example.chatroom.models.ChatMassage;


public class MainActivity extends Activity {

    private static final String Tag ="ChatActivity";

    private chatadapter chatadapter;
    private ListView listView;
    private EditText chatText;
    private Button buttonsend;
    private boolean side=true;
    private boolean sidee=false;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.send);
        listView = (ListView) findViewById(R.id.msgview);

        chatadapter = new chatadapter(getApplicationContext(), R.layout.rightchat);
        listView.setAdapter((chatadapter));
        chatadapter.add(new ChatMassage(side, "selamat datang \n silahkan ketik sesuatu dibawah ini \n 1.what your name? \n 2. where do you from ?"));
        chatText = (EditText) findViewById(R.id.msgr);

        imageView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                if (chatText.getText().toString().equals("Siapa namamu?") || chatText.getText().toString().equals("siapa namamu?")) {
                    chatadapter.add(new ChatMassage(side, chatText.getText().toString()));
                    chatText.setText("");
                    otherMessage();
                } else if (chatText.getText().toString().equals("Darimana asalmu?") || chatText.getText().toString().equals("darimana asalmu?")) {
                    chatadapter.add(new ChatMassage(side, chatText.getText().toString()));
                    chatText.setText("");
                    otherMessage1();
                } else {
                    chatadapter.add(new ChatMassage(side, chatText.getText().toString()));
                    chatadapter.add(new ChatMassage(sidee, "Oke Sayangku"));
                    chatText.setText("");
                }

            }
        });

        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatadapter);

        //------//
        chatadapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatadapter.getCount() - 1);
            }
        });
    }

            private void otherMessage1() {
            chatadapter.add(new ChatMassage(sidee, "Probolinggo"));
            chatText.setText("");
            return ;
            }

            private void otherMessage() {
                chatadapter.add(new ChatMassage(sidee, "Mohammad Reza Pahlevi"));
                chatText.setText("");
                return ;
            }






}
