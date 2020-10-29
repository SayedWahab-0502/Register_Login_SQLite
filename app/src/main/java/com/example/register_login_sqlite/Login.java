package com.example.register_login_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText mail,password;
    Button login;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    mail=(EditText)findViewById(R.id.mail_login);
    password=(EditText)findViewById(R.id.password_login);
    login=(Button)findViewById(R.id.login_button);


    dataBaseHelper=new DataBaseHelper(this);


    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String s1=mail.getText().toString();
            String s2=password.getText().toString();

            Boolean loginmailpass=dataBaseHelper.Loginmailpassword(s1,s2);


            if(s1.equals("") || s2.equals(""))
            {
                Toast.makeText(getApplicationContext(),"Fields are Empty",Toast.LENGTH_SHORT).show();
            }

            else if (loginmailpass==true)
            {
                Toast.makeText(getApplicationContext(),"Log in Successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Login.this,Main2Activity.class);
                startActivity(intent);
            }
            else {

                Toast.makeText(getApplicationContext(),"Log in UnSuccessful",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}
