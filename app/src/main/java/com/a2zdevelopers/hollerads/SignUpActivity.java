package com.a2zdevelopers.hollerads;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    public static final String EMAIL_KEY = "email key";
    public static final String EMAIL_ID = "email_id";
    public static final String PASSW = "password";
    public static final String MY_GLOBAL_PREFRENCE = "my_global_pref";
    EditText signUpID, signUpPass;
    Button ragister, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpID = findViewById(R.id.sighUpID);
        signUpPass = findViewById(R.id.signUpPass);
        ragister = findViewById(R.id.ragister);
        login = findViewById(R.id.login);
        ragister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ragisterUser();
            }
        });


    }

    private void ragisterUser() {
        signUpID.setError(null);
        signUpPass.setError(null);

        String emailID = signUpID.getText().toString();
        String pass = signUpPass.getText().toString();
        View focusView = null;
        boolean cancel = false;
        if (!TextUtils.isEmpty(pass) && !isPassValidate(pass)) {
            signUpPass.setError("This pass is too short");
            focusView = signUpPass;
            cancel = true;
        }

        if (TextUtils.isEmpty(emailID)) {
            signUpID.setError("This field is required");
            focusView = signUpID;
            cancel = true;
        } else if (!isEmailValidate(emailID)) {
            signUpID.setError("This email adddress is invalid");
            focusView = signUpPass;
            cancel = true;

        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            SharedPreferences.Editor editor = getSharedPreferences(MY_GLOBAL_PREFRENCE, MODE_PRIVATE).edit();
            editor.putString(EMAIL_ID, emailID);
            editor.putString(PASSW, pass);
            editor.apply();
            Toast.makeText(this, "Ragistration Success", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private boolean isEmailValidate(String emailID) {
        return emailID.contains("@");
    }

    private boolean isPassValidate(String pass) {
        return pass.length() > 4;
    }
}
