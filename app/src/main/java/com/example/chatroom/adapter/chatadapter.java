package com.example.chatroom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.chatroom.R;
import com.example.chatroom.models.ChatMassage;

import java.util.ArrayList;
import java.util.List;

public class chatadapter extends ArrayAdapter<ChatMassage> {

    private TextView chatText;
    private List<ChatMassage> chatMassageList = new ArrayList<ChatMassage>();
    private Context context;


    @Override
    public void add(ChatMassage object) {
        chatMassageList.add(object);
        super.add(object);
    }


    public chatadapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;

    }

    public int getCount() {
        return this.chatMassageList.size();

    }

    public ChatMassage getItem(int index) {
        return this.chatMassageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMassage chatMassageObj = getItem(position);
        View row = convertView;

        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMassageObj.leftchat) {
            row = inflater.inflate(R.layout.rightchat, parent, false);
        }else{
            row = inflater.inflate(R.layout.leftchat, parent, false);
        }

        chatText = (TextView) row.findViewById(R.id.msgr);
        chatText.setText(chatMassageObj.massage);
        return row;


    }



    }
