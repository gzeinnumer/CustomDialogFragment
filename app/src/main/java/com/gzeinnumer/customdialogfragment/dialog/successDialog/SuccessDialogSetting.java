package com.gzeinnumer.customdialogfragment.dialog.successDialog;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gzeinnumer.customdialogfragment.R;
import com.gzeinnumer.customdialogfragment.constant.ButtonStyle;
import com.gzeinnumer.customdialogfragment.dialog.BaseDialog;

public class SuccessDialogSetting extends BaseDialog {

    protected SuccessDialog.OnCancelPressed onCancelPressed;

    protected SuccessDialog.OnOkPressed onOkPressed;

    protected View _view;
    protected LinearLayout _dialogCanvas;
    protected LinearLayout _dialogCanvasContent;
    protected LinearLayout _parentButton;
    protected TextView _tvTitle;
    protected TextView _tvContent;
    protected Button _dBtnOkMBT;
    protected Button _dBtnOkMBO;
    protected Button _dBtnOkMBC;
    protected ButtonStyle btnStyle;

    protected String tvTitleValue;
    protected String tvContentValue;
    protected String dBtnOkValue;

    protected Drawable shapeCanvas = null;
    protected double tvTitleSize = 0;
    protected double tvContentSize = 0;
    protected double dBtnTextSize = 0;

    protected int tvTitleColor = 0;
    protected int tvContentColor = 0;
    protected int btnTextColorOk = 0;

    protected int okIconL = 0;
    protected int okIconT = 0;
    protected int okIconR = 0;
    protected int okIconB = 0;

    protected int buttonGravity = -100;

    protected int tvTitleAlignment = View.TEXT_ALIGNMENT_CENTER; //default from view
    protected int tvContentAlignment = View.TEXT_ALIGNMENT_TEXT_START; //default from view

    private void initView() {
        _dialogCanvas = _view.findViewById(R.id.dialog_canvas);
        _dialogCanvasContent = _view.findViewById(R.id.dialog_canvas_content);
        _parentButton = _view.findViewById(R.id.parent_button);
        _tvTitle = _view.findViewById(R.id.tv_title);
        _tvContent = _view.findViewById(R.id.tv_content);
        _dBtnOkMBT = _view.findViewById(R.id.d_btn_ok_MBT);
        _dBtnOkMBO = _view.findViewById(R.id.d_btn_ok_MBO);
        _dBtnOkMBC = _view.findViewById(R.id.d_btn_ok_MBC);
    }

    @Override
    protected int contentView() {
        return R.layout.success_dialog;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this._view = view;
        initView();
        initDesign();
        initOnClick();
    }

    private void initDesign() {
        if (shapeCanvas!=null)
            _dialogCanvas.setBackground(shapeCanvas);

        if (tvTitleValue != null)
            _tvTitle.setText(tvTitleValue);
        else
            _tvTitle.setVisibility(View.GONE);

        if (tvContentValue != null)
            _tvContent.setText(tvContentValue);
        else
            _tvContent.setVisibility(View.GONE);

        if (dBtnOkValue != null)
            _dBtnOkMBT.setText(dBtnOkValue);

        if (btnStyle != null) {
            if (btnStyle == ButtonStyle.ButtonText) {
                btnVisibleOk(_dBtnOkMBT, View.VISIBLE);
            }
            if (btnStyle == ButtonStyle.ButtonOutlined) {
                btnVisibleOk(_dBtnOkMBO, View.VISIBLE);
            }
            if (btnStyle == ButtonStyle.ButtonContained) {
                btnVisibleOk(_dBtnOkMBC, View.VISIBLE);
            }
        } else {
            btnVisibleOk(_dBtnOkMBT, View.VISIBLE);
        }

        if (tvTitleSize!=0)
            _tvTitle.setTextSize((float) tvTitleSize);

        if (tvContentSize!=0)
            _tvContent.setTextSize((float) tvContentSize);

        if (dBtnTextSize!=0){
            _dBtnOkMBT.setTextSize((float) dBtnTextSize);
            _dBtnOkMBO.setTextSize((float) dBtnTextSize);
            _dBtnOkMBC.setTextSize((float) dBtnTextSize);
        }

        if (tvTitleColor!=0)
            _tvTitle.setTextColor(tvTitleColor);

        if (tvContentColor!=0)
            _tvContent.setTextColor(tvContentColor);

        if (btnTextColorOk!=0){
            _dBtnOkMBT.setTextColor(btnTextColorOk);
            _dBtnOkMBO.setTextColor(btnTextColorOk);
            _dBtnOkMBC.setTextColor(btnTextColorOk);
        }

        if(buttonGravity!=-100){
            _parentButton.setGravity(buttonGravity);
        }

        if(tvTitleAlignment !=View.TEXT_ALIGNMENT_CENTER){
            _tvTitle.setTextAlignment(tvTitleAlignment);
        }

        if(tvContentAlignment !=View.TEXT_ALIGNMENT_TEXT_START){
            _tvContent.setTextAlignment(tvContentAlignment);
        }
    }


    private void initOnClick() {
        _dBtnOkMBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOkPressed.onOkPressed();
                getDialog().dismiss();
            }
        });
        _dBtnOkMBO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOkPressed.onOkPressed();
                getDialog().dismiss();
            }
        });
        _dBtnOkMBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOkPressed.onOkPressed();
                getDialog().dismiss();
            }
        });
    }

    private void btnVisibleOk(Button button, int visible) {
        button.setVisibility(visible);
        button.setVisibility(visible);
        if (okIconL != 0 || okIconT != 0 || okIconR != 0 || okIconB != 0) {
            if (okIconT !=0 || okIconB !=0){
                ViewGroup.LayoutParams lp = button.getLayoutParams();
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                button.setLayoutParams(lp);
            }
            button.setCompoundDrawablesWithIntrinsicBounds(okIconL, okIconT, okIconR, okIconB);
        }
    }
}
