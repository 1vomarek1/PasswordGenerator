package com.vomarek.passwordgenerator;

import android.app.Activity;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
    private final MainActivity activity;

    public SeekBarChangeListener(final MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        MainActivity.generator.length = progress;
        final TextView text = activity.findViewById(R.id.lengthText);
        if (text != null) text.setText(String.valueOf(progress));
        activity.setPassword(MainActivity.generator.generate());

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
