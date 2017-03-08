package cn.gtgs.base.OTO.widget.SweetAlert;


import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

import java.util.ArrayList;
import java.util.List;

import cn.gtgs.base.OTO.R;
import cn.gtgs.base.OTO.widget.LineBreakLayout;

public class Add2ShoppingCarAlertDialog extends Dialog implements View.OnClickListener {
    private View mDialogView;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private Animation mOverlayOutAnim;
    private AnimationSet mErrorXInAnim;
    private OnSweetClickListener mCancelClickListener;
    private OnSweetClickListener mConfirmClickListener;
    private boolean mCloseFromCancel;

    public static final int NORMAL_TYPE = 0;
    LineBreakLayout mSize;
    LineBreakLayout mColor;


    public static interface OnSweetClickListener {
        public void onClick(Add2ShoppingCarAlertDialog sweetAlertDialog);
    }

    public Add2ShoppingCarAlertDialog(Context context) {
        this(context, NORMAL_TYPE);
    }

    public Add2ShoppingCarAlertDialog(Context context, int alertType) {
        super(context, R.style.alert_dialog_1);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        mErrorXInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.error_x_in);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.GINGERBREAD_MR1) {
            List<Animation> childAnims = mErrorXInAnim.getAnimations();
            int idx = 0;
            for (; idx < childAnims.size(); idx++) {
                if (childAnims.get(idx) instanceof AlphaAnimation) {
                    break;
                }
            }
            if (idx < childAnims.size()) {
                childAnims.remove(idx);
            }
        }
        mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_in);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_out);
        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCloseFromCancel) {
                            Add2ShoppingCarAlertDialog.super.cancel();
                        } else {
                            Add2ShoppingCarAlertDialog.super.dismiss();
                        }
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        // dialog overlay fade out
        mOverlayOutAnim = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                WindowManager.LayoutParams wlp = getWindow().getAttributes();
                wlp.alpha = 1 - interpolatedTime;
                getWindow().setAttributes(wlp);
            }
        };
        mOverlayOutAnim.setDuration(120);
        Window win = this.getWindow();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        win.setAttributes(lp);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add2shoppingcar_dialog);
        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mSize = (LineBreakLayout) findViewById(R.id.linebreaklayout_buy_size_choose);
        mColor = (LineBreakLayout) findViewById(R.id.linebreaklayout_buy_color_choose);
        ArrayList<String> size = new ArrayList<>();
        size.add("350ml");
        size.add("500ml");
        size.add("800ml");
        size.add("1000ml");
        size.add("1200ml");
        size.add("1500ml");
        mSize.setLables(size, false, null);
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Black");
        colors.add("Yellow");
        colors.add("Pink");
        colors.add("White");
        colors.add("Silver");
        mColor.setLables(colors, false, null);

    }


    public Add2ShoppingCarAlertDialog setCancelClickListener(OnSweetClickListener listener) {
        mCancelClickListener = listener;
        return this;
    }

    public Add2ShoppingCarAlertDialog setConfirmClickListener(OnSweetClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }

    protected void onStart() {
        mDialogView.startAnimation(mModalInAnim);
    }

    /**
     * The real Dialog.cancel() will be invoked async-ly after the animation finishes.
     */
    @Override
    public void cancel() {
        dismissWithAnimation(true);
    }

    /**
     * The real Dialog.dismiss() will be invoked async-ly after the animation finishes.
     */
    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    private void dismissWithAnimation(boolean fromCancel) {
        mCloseFromCancel = fromCancel;
        mDialogView.startAnimation(mModalOutAnim);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancel_button) {
            if (mCancelClickListener != null) {
                mCancelClickListener.onClick(Add2ShoppingCarAlertDialog.this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.confirm_button) {
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(Add2ShoppingCarAlertDialog.this);
            } else {
                dismissWithAnimation();
            }
        }
    }

}