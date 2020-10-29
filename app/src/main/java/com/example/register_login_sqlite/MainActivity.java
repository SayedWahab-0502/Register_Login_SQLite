package com.example.register_login_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

EditText username,mail,password,confirm_password;
Button register,Login;
DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username_register);
        mail=(EditText)findViewById(R.id.mail_register);
        password=(EditText)findViewById(R.id.password_register);
        confirm_password=(EditText)findViewById(R.id.confirm_password);

        register=(Button)findViewById(R.id.register);
        Login=(Button)findViewById(R.id.login_now_if_already);

        dataBaseHelper=new DataBaseHelper(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String s1= username.getText().toString();
                String s2=mail.getText().toString();
                String s3=password.getText().toString();
                String s4=confirm_password.getText().toString();


                if (s1.equals("")||s2.equals("")||s3.equals("") || s4.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields are Empty",Toast.LENGTH_LONG).show();
                }


             else if (s3.equals(s4))
                {
                    Boolean checkmail=dataBaseHelper.checkmail(s2);

                    if (checkmail==true)
                    {

                Boolean insert=dataBaseHelper.insert(s1,s2,s3);

                if (insert==true)
                {
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();

                } //2nd if
                    } //1st if

                    else {
                        Toast.makeText(getApplicationContext(),"Email Already Exist",Toast.LENGTH_SHORT).show();
                    }

                } //end of  else if
                else{
                    Toast.makeText(getApplicationContext(),"Password do not Match",Toast.LENGTH_SHORT).show();
                }

            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
