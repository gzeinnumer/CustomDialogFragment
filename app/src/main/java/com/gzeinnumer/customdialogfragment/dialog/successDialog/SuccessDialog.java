package com.gzeinnumer.customdialogfragment.dialog.successDialog;

import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gzeinnumer.customdialogfragment.constant.ButtonStyle;
import com.gzeinnumer.customdialogfragment.dialog.confirmDialog.ConfirmDialog;

public class SuccessDialog extends SuccessDialogSetting {

    public static final String TAG = "CustomDialog";

    private FragmentManager _context;
    private FragmentTransaction _transaction;

    public SuccessDialog(FragmentManager context) {
        this._context = context;

        _transaction = _context.beginTransaction();
        Fragment previous = _context.findFragmentByTag(SuccessDialog.TAG);
        if (previous != null) {
            _transaction.remove(previous);
        }
    }

    //CANVAS
    public SuccessDialog setDialogCanvas(Drawable resource) {
        this.shapeCanvas = resource;
        return this;
    }

    //TITLE
    public SuccessDialog setTitle(String title) {
        this.tvTitleValue = title;
        return this;
    }
    public SuccessDialog setTitleSize(int size) {
        this.tvTitleSize = size;
        return this;
    }
    public SuccessDialog setTitleColor(int color) {
        this.tvTitleColor = color;
        return this;
    }
    public SuccessDialog setTitleAlignment(int alignment) {
        this.tvTitleAlignment = alignment;
        return this;
    }

    //CONTENT
    public SuccessDialog setContent(String title) {
        this.tvContentValue = title;
        return this;
    }
    public SuccessDialog setContentSize(int size) {
        this.tvContentSize = size;
        return this;
    }
    public SuccessDialog setContentColor(int color) {
        this.tvContentColor = color;
        return this;
    }
    public SuccessDialog setContentAlignment(int alignment) {
        this.tvContentAlignment = alignment;
        return this;
    }

    //OK
    public SuccessDialog setBtnOkTitle(String title) {
        this.dBtnOkValue = title;
        return this;
    }
    public SuccessDialog setBtnOkTitleColor(int color) {
        this.btnTextColorOk = color;
        return this;
    }

    //OK ICON
    public SuccessDialog setOkIconLeft(int icon) {
        this.okIconL = icon;
        return this;
    }
    public SuccessDialog setOkIconTop(int icon) {
        this.okIconT = icon;
        return this;
    }
    public SuccessDialog setOkIconRight(int icon) {
        this.okIconR = icon;
        return this;
    }
    public SuccessDialog setOkIconBottom(int icon) {
        this.okIconB = icon;
        return this;
    }

    //BUTTON STYLE
    public SuccessDialog setButtonStyle(ButtonStyle style) {
        this.btnStyle = style;
        return this;
    }
    public SuccessDialog setButtonTextSize(int size) {
        this.dBtnTextSize = size;
        return this;
    }
    public SuccessDialog setButtonGravity(int gravity) {
        this.buttonGravity = gravity;
        return this;
    }

    //ACTION CALLBACK
    public SuccessDialog onCancelPressedCallBack(OnCancelPressed callBack) {
        this.onCancelPressed = callBack;
        return this;
    }
    public SuccessDialog onOkPressedCallBack(OnOkPressed callBack) {
        this.onOkPressed = callBack;
        return this;
    }

    public void show() {
        this.show(_transaction, SuccessDialog.TAG);
    }

    //callback
    public interface OnCancelPressed {
        void onCancelPressed();
    }

    public interface OnOkPressed {
        void onOkPressed();
    }
}