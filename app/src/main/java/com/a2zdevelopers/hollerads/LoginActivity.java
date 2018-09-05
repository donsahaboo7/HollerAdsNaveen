package com.a2zdevelopers.hollerads;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emaiId, password;
    Button loginButton;
    public  String idString, passwordString;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emaiId = findViewById(R.id.loginId);
        password = findViewById(R.id.loginPass);
        loginButton = findViewById(R.id.login);
        loginMethod();


    }

    private void loginMethod() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idString = emaiId.getText().toString();
                passwordString = password.getText().toString();
                SharedPreferences preferences = getSharedPreferences(SignUpActivity.MY_GLOBAL_PREFRENCE, MODE_PRIVATE);
                String email = preferences.getString(SignUpActivity.EMAIL_ID, "");
                String pass = preferences.getString(SignUpActivity.PASSW, "");


                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {

                    if ((email.equals(idString)) && (pass.equals(passwordString))) {

                        Intent intent
                                = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        idString=null;
                        passwordString=null;

                    } else {
                        Toast.makeText(LoginActivity.this, "ID / Paass Incorrect OR SignUp Now", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    emaiId.setError("Eneter Correct ID ");
                    view = emaiId;
                    password.setError("Wrong Password");
                    view = password;
                }


            }

        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void signUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
