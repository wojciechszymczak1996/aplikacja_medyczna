package com.example.wojciech.chorzydoktorzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.xw.repo.BubbleSeekBar;

public class Main5Activity extends AppCompatActivity {

    int maks_odl=1;
    boolean otwarte=false;
    String godz_otw="00:00";
    String godz_zam="24:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        //pasek odleglosci
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




        final EditText edit =  (EditText) findViewById(R.id.editText);
        godz_otw = edit.getText().toString();

        final EditText edit2 =  (EditText) findViewById(R.id.editText2);
        godz_zam = edit.getText().toString();


        //get the spinner from the xml.
        final Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        String[] items = new String[]{"PONIEDZIAŁEK", "WTOREK", "ŚRODA", "CZWARTEK", "PIĄTEK","SOBOTA","NIEDZIELA"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                //jesli jest wlaczony
                edit.setEnabled(!isChecked);
                edit2.setEnabled(!isChecked);
                dropdown.setEnabled(!isChecked);
            }
        });







    }
}
