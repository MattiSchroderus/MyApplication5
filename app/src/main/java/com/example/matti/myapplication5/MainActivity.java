package com.example.matti.myapplication5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  implements TextEntryDialogFragment.TextEntryDialogListener {

    private final String TEXTVIEW_STATEKEY = "TEXTVIEW_STATEKEY";

    private TextView txtMessage;
    private Button btnChangeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindLayout();

        // Comment below to test
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(TEXTVIEW_STATEKEY)) {
                String text = savedInstanceState.getString(TEXTVIEW_STATEKEY);
                txtMessage.setText(text);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        Toast.makeText(getBaseContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();

        // save text view state
        saveInstanceState.putString(TEXTVIEW_STATEKEY, txtMessage.getText().toString());
    }

    private void bindLayout() {
        txtMessage = (TextView) findViewById(R.id.txtMessage);

        btnChangeText = (Button) findViewById(R.id.btnChangeText);
        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnChangeTextClicked(v);
            }
        });
    }

    private void onBtnChangeTextClicked(View view) {
        TextEntryDialogFragment eDialog = new TextEntryDialogFragment();
        eDialog.show(getFragmentManager(), "Text Dialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String text) {
        txtMessage.setText(text);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
    }


}