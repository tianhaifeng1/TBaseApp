package com.trjx.tlibs.uils;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarUtil {

    private static Snackbar snackbar;
    public static void show(View view,String text){
        show(view,text,Snackbar.LENGTH_SHORT);
    }

    public static void show(View view,String text,int duration){
        if (snackbar == null ) {
            snackbar = Snackbar.make(view, text, duration);
            snackbar.addCallback(new Snackbar.Callback(){
                @Override
                public void onShown(Snackbar sb) {
                    super.onShown(sb);
                }

                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);
                }
            });
            snackbar.show();
        }else{
            snackbar.setText(text);
            if (!snackbar.isShown()) {
                snackbar.show();
            }
        }
    }


    public static void showAction(View view, String text, View.OnClickListener listener){
        //一直显示
        Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("action1", listener);
//        snackbar.setAction("action1", new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showToast(context, "action1");
//            }
//        });
        snackbar.show();
    }


    public static void showToast(View layout,String text){
        Snackbar snackbar = Snackbar.make(layout, text, Snackbar.LENGTH_SHORT);
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        TextView textView = snackbarLayout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setGravity(Gravity.CENTER);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        snackbarLayout.setAlpha(0.6f);
        Snackbar.SnackbarLayout.LayoutParams params = (Snackbar.SnackbarLayout.LayoutParams) snackbarLayout.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM;
        params.bottomMargin = 200;
        params.width = Snackbar.SnackbarLayout.LayoutParams.WRAP_CONTENT;
        params.height = Snackbar.SnackbarLayout.LayoutParams.WRAP_CONTENT;
        snackbarLayout.setLayoutParams(params);

        snackbar.show();
    }


}
