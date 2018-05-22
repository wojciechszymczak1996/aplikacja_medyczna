package com.example.wojciech.chorzydoktorzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.xw.repo.BubbleSeekBar;

public class Main2Activity extends AppCompatActivity {
    int maks_odl=1;
    boolean otwarte=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) findViewById(R.id.seekBar);
        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress, float progressFloat) {
                maks_odl=progress;
            }
            @Override
            public void getProgressOnActionUp(int progress, float progressFloat) {
                maks_odl=progress;
            }
            @Override
            public void getProgressOnFinally(int progress, float progressFloat) {
                maks_odl=progress;
            }
        });


        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                //jesli jest wlaczony
                bubbleSeekBar.setEnabled(!isChecked);
            }


        });

    }
}
