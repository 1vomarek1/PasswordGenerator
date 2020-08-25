package com.vomarek.passwordgenerator.listener;

import android.widget.CompoundButton;
import com.vomarek.passwordgenerator.MainActivity;
import com.vomarek.passwordgenerator.R;

public class SwitchListener implements CompoundButton.OnCheckedChangeListener {
    final MainActivity activity;

    public SwitchListener(MainActivity activity) {
        this.activity = activity;
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (buttonView.getId() == R.id.letters) MainActivity.generator.update(isChecked, null, null);
        if (buttonView.getId() == R.id.numbers) MainActivity.generator.update(null, isChecked, null);
        if (buttonView.getId() == R.id.symbols) MainActivity.generator.update(null, null, isChecked);
        activity.setPassword(MainActivity.generator.generate());
    }
}
