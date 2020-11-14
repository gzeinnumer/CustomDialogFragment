package com.gzeinnumer.customdialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gzeinnumer.customdialogfragment.constant.ButtonStyle;
import com.gzeinnumer.customdialogfragment.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.customdialogfragment.dialog.successDialog.SuccessDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        _ConfirmDialog();
        _SuccessDialog();
    }

    private void _ConfirmDialog() {
        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConfirmDialog(getSupportFragmentManager())
//                        .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))
                        .setTitle("ini title")
//                        .setTitleSize(21)
//                        .setTitleColor(getResources().getColor(R.color.colorAccent))
//                        .setTitleColor(getResources().getColor(R.color.colorAccent))
//                        .setTitleAlignment(View.TEXT_ALIGNMENT_INHERIT)
                        .setTitleAlignment(View.TEXT_ALIGNMENT_TEXT_END)
                        .setContent("ini content")
//                        .setContentSize(21)
//                        .setContentColor(Color.parseColor("#03DAC5"))
                        .setContentAlignment(View.TEXT_ALIGNMENT_TEXT_END)
                        .setBtnCancelTitle("Batal")
//                        .setBtnCancelTitleColor(getResources().getColor(R.color.colorAccent))
                        .setBtnOkTitle("Yuhuu")
//                        .setBtnOkTitleColor(getResources().getColor(R.color.colorAccent))
//                        .setButtonTextSize(15)
                        .setButtonStyle(ButtonStyle.ButtonText)
//                        .setOkIconLeft(R.drawable.ic_baseline_add_24)
//                        .setCancelIconLeft(R.drawable.ic_baseline_add_24)
//                        .setOkIconTop(R.drawable.ic_baseline_add_24)
//                        .setCancelIconTop(R.drawable.ic_baseline_add_24)
//                        .setOkIconRight(R.drawable.ic_baseline_add_24)
//                        .setCancelIconRight(R.drawable.ic_baseline_add_24)
//                        .setOkIconBottom(R.drawable.ic_baseline_add_24)
//                        .setCancelIconBottom(R.drawable.ic_baseline_add_24)
                        .setButtonGravity(Gravity.CENTER)
                        .onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
                            @Override
                            public void onCancelPressed() {
                                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
                            @Override
                            public void onOkPressed() {
                                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    private void _SuccessDialog() {
        ((Button) findViewById(R.id.btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SuccessDialog(getSupportFragmentManager())
                        .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))
                        .setTitle("ini title")
                        .setTitleSize(21)
                        .setTitleColor(getResources().getColor(R.color.colorAccent))
                        .setTitleColor(getResources().getColor(R.color.colorAccent))
                        .setTitleAlignment(View.TEXT_ALIGNMENT_INHERIT)
                        .setTitleAlignment(View.TEXT_ALIGNMENT_TEXT_END)
                        .setContent("ini content")
                        .setContentSize(21)
                        .setContentColor(Color.parseColor("#03DAC5"))
                        .setContentAlignment(View.TEXT_ALIGNMENT_TEXT_END)
                        .setBtnOkTitle("Yuhuu")
                        .setBtnOkTitleColor(getResources().getColor(R.color.colorAccent))
                        .setButtonTextSize(15)
                        .setButtonStyle(ButtonStyle.ButtonText)
                        .setOkIconLeft(R.drawable.ic_baseline_add_24)
                        .setOkIconTop(R.drawable.ic_baseline_add_24)
                        .setOkIconRight(R.drawable.ic_baseline_add_24)
                        .setOkIconBottom(R.drawable.ic_baseline_add_24)
                        .setButtonGravity(Gravity.CENTER)
                        .onOkPressedCallBack(new SuccessDialog.OnOkPressed() {
                            @Override
                            public void onOkPressed() {
                                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}