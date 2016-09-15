package edu.up.cs371.laum18.newcarstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnLongClickListener {

    private ToggleButton power;
    private ToggleButton play;
    private Button stop;
    private TextView display;
    private TextView currentVolume;
    private boolean AM = true;
    private Switch amFm;
    private SeekBar tuner;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    String presetsAM[] = {"550", "600", "650", "700", "750"};
    String presetsFM[] = {"90.9", "92.9", "94.9", "96.9", "98.9"};
    int AMValue = 0;
    double FMValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        power = (ToggleButton) findViewById(R.id.Power);
        power.setOnClickListener(new powerListener());
        stop = (Button) findViewById(R.id.Stop);
        play = (ToggleButton) findViewById(R.id.PausePlay);
        display = (TextView) findViewById(R.id.textView);
        currentVolume = (TextView) findViewById(R.id.CurrentVolume);
        amFm = (Switch) findViewById(R.id.AMFM);
        tuner = (SeekBar) findViewById(R.id.Tuner);
        tuner.setOnSeekBarChangeListener(this);

        one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(new presetListener());
        one.setOnLongClickListener(this);

        two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(new presetListener());
        two.setOnLongClickListener(this);

        three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(new presetListener());
        three.setOnLongClickListener(this);

        four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(new presetListener());
        four.setOnLongClickListener(this);

        five = (Button) findViewById(R.id.button5);
        five.setOnClickListener(new presetListener());
        five.setOnLongClickListener(this);
    }

    private class powerListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v == power) {
                if (power.isChecked()) {
                    display.setTextColor(Color.WHITE);
                    currentVolume.setText("0");
                    stop.setBackgroundColor(Color.WHITE);
                    play.setBackgroundColor(Color.WHITE);
                    tuner.setEnabled(true);
                } else {
                    tuner.setEnabled(false);
                    display.setTextColor(Color.BLACK);
                    currentVolume.setText("Current Volume");
                    stop.setBackgroundColor(Color.GRAY);
                    play.setBackgroundColor(Color.GRAY);
                }
            }
        }
    }

    private class presetListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v == one) {
                if (amFm.isChecked()) {
                    display.setText(presetsAM[0] +" AM");
                } else {
                    display.setText(presetsFM[0] +" FM");
                }
            } else if (v == two) {
                if (amFm.isChecked()) {
                    display.setText(presetsAM[1] +" AM");
                } else {
                    display.setText(presetsFM[1] +" FM");
                }
            } else if (v == three) {
                if (amFm.isChecked()) {
                    display.setText(presetsAM[2] +" AM");
                } else {
                    display.setText(presetsFM[2] +" FM");
                }
            } else if (v == four) {
                if (amFm.isChecked()) {
                    display.setText(presetsAM[3] +" AM");
                } else {
                    display.setText(presetsFM[3] +" FM");
                }
            } else if (v == five) {
                if (amFm.isChecked()) {
                    display.setText(presetsAM[4] +" AM");
                } else {
                    display.setText(presetsFM[4] +" FM");
                }
            }
        }
    }

    public void onStartTrackingTouch(SeekBar s) {

    }

    public void onStopTrackingTouch(SeekBar s) {

    }

    public void onProgressChanged(SeekBar s, int p, boolean b) {
        if (s == tuner) {
            AM = amFm.isChecked();
            if (AM) {
                tuner.setMax(1170);
                display.setText("" +(((p +530)/10) * 10)+" AM");
                AMValue = (((p +530)/10) * 10);
            } else {
                tuner.setMax(99);
                double fm = (((((double)(p +440))/10)*2)+.1);
                String r = String.format("%.1f", fm);
                display.setText("" +r +" FM");
                FMValue = fm;
            }

        }
    }

    public boolean onLongClick(View v) {
        if (v == one) {
            if (amFm.isChecked()) {
                presetsAM[0] = "" +AMValue;
                display.setText("Preset Changed");
            } else {
                presetsFM[0] = "" +FMValue;
                display.setText("Preset Changed");
            }
        } else if (v == two) {
            if (amFm.isChecked()) {
                presetsAM[1] = "" +AMValue;
                display.setText("Preset Changed");
            } else {
                presetsFM[1] = "" +FMValue;
                display.setText("Preset Changed");
            }
        } else if (v == three) {
            if (amFm.isChecked()) {
                presetsAM[2] = "" +AMValue;
                display.setText("Preset Changed");
            } else {
                presetsFM[2] = "" +FMValue;
                display.setText("Preset Changed");
            }
        } else if (v == four) {
            if (amFm.isChecked()) {
                presetsAM[3] = "" +AMValue;
                display.setText("Preset Changed");
            } else {
                presetsFM[3] = "" +FMValue;
                display.setText("Preset Changed");
            }
        } else if (v == five) {
            if (amFm.isChecked()) {
                presetsAM[4] = "" +AMValue;
                display.setText("Preset Changed");
            } else {
                presetsFM[4] = "" +FMValue;
                display.setText("Preset Changed");
            }
        }
        return true;
    }

}
