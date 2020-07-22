package com.gzeinnumer.customdialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment previous = getSupportFragmentManager().findFragmentByTag(CustomDialog.TAG);
                if(previous != null){
                    transaction.remove(previous);
                }
                DialogFragment dialog = new CustomDialog().newInstance();
                dialog.show(transaction,CustomDialog.TAG);
            }
        });
    }
}