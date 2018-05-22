package com.example.wojciech.chorzydoktorzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.apteka_but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityApteka();
            }

        });
        button2 = (Button) findViewById(R.id.szpital_but);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySzpital();
            }

        });
        button3 = (Button) findViewById(R.id.przychodnia_but);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPrzychodnia();
            }

        });
        button4 = (Button) findViewById(R.id.nisoz_but);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityNisoz();
            }

        });
    }
    public void openActivityApteka(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void openActivitySzpital(){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
    public void openActivityPrzychodnia(){
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }
    public void openActivityNisoz(){
        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }

}
