package com.a2zdevelopers.hollerads;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {
    TextView c_name, c_tag;
    Animation frombuttom, fromupper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        c_name = findViewById(R.id.c_name);
        c_tag = findViewById(R.id.c_tag);
        frombuttom = AnimationUtils.loadAnimation(this, R.anim.buttom_side);
        c_name.setAnimation(frombuttom);
        fromupper = AnimationUtils.loadAnimation(this, R.anim.upper_side);
        c_tag.setAnimation(fromupper);


        gotoSecondPage();


    }

    private void gotoSecondPage() {
        AsyncTask<String, String, String> demoAsynk = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "done";
            }

            @Override
            protected void onPostExecute(String s) {
                if (s.equals("done")) {
                    startActivity(new Intent(getBaseContext(),LoginActivity.class));
                    finish();

                }
            }

            @Override
            protected void onPreExecute() {


            }
        };
        demoAsynk.execute();
    }


}
