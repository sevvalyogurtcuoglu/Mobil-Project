package com.example.syinsta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText=findViewById(R.id.sing_in_usernameActi);
        passwordText=findViewById(R.id.sing_in_passwordActi);


    }
    public void signIn(View view){
        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                else {
                    //intent
                    Toast.makeText(getApplicationContext(),"hosgeldin "+user.getUsername(),Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),FActivity.class);
                    startActivity(intent);

                }
            }
        });


    }
    public  void  signUp(View view){
        ParseUser user=new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"kullanıcı olusturuldu!",Toast.LENGTH_LONG).show();
                //intent
                    Intent intent=new Intent(getApplicationContext(),FActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
