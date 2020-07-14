package com.example.syinsta;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.syinsta.R;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {
    TextView textView;
    EditText editText;
    Button button;
    private final ArrayList<String> username;
    private final ArrayList<String> userComment;
    private final ArrayList<Bitmap> userImage;
    private final Activity context;

    public  PostClass(ArrayList<String>username, ArrayList<String> userComment, ArrayList<Bitmap> userImage, Activity context){
        super(context, R.layout.home,username);
        this.username=username;
        this.userComment=userComment;
        this.userImage=userImage;
        this.context=context;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View home=layoutInflater.inflate(R.layout.home,null,true);
        TextView userName=home.findViewById(R.id.userName);
        TextView commentText=home.findViewById(R.id.commentText);
        ImageView imageView=home.findViewById(R.id.HomeImageView);

        userName.setText(username.get(position));
        imageView.setImageBitmap(userImage.get(position));
        commentText.setText(userComment.get(position));



        return home;
    }

}
