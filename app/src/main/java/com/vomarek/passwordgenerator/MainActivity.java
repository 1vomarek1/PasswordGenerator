package com.vomarek.passwordgenerator;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.vomarek.passwordgenerator.listener.SwitchListener;
import com.vomarek.passwordgenerator.passwords.PasswordGenerator;

public class MainActivity extends AppCompatActivity {

    public static final PasswordGenerator generator = new PasswordGenerator();

    private static String currentPassword;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = findViewById(R.id.length);
        final Switch letterSwitch = findViewById(R.id.letters);
        final Switch numberSwitch = findViewById(R.id.numbers);
        final Switch symbolSwitch = findViewById(R.id.symbols);

        letterSwitch.setOnCheckedChangeListener(new SwitchListener(this));
        numberSwitch.setOnCheckedChangeListener(new SwitchListener(this));
        symbolSwitch.setOnCheckedChangeListener(new SwitchListener(this));

        seekBar.setOnSeekBarChangeListener(new SeekBarChangeListener(this));

        setPassword(generator.generate());

    }

    public void onClick(final View v) {
        if (v.getId() == R.id.newPassword) setPassword(generator.generate());
        if (v.getId() == R.id.copy) setClipboard();
    }

    public void setPassword(final String password) {
        currentPassword = password;
        final TextView textView = findViewById(R.id.password);
        if (textView != null) textView.setText(password);
    }

    private void setClipboard() {
        final android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        final android.content.ClipData clip = android.content.ClipData.newPlainText("Password", currentPassword);
        if (clipboard != null) clipboard.setPrimaryClip(clip);

        Toast toast = Toast.makeText(this, R.string.password_copied, Toast.LENGTH_SHORT);
        toast.show();
    }
}
