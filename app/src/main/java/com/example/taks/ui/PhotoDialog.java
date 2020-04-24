package com.example.taks.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.taks.R;
import com.squareup.picasso.Picasso;

public class PhotoDialog extends Dialog {
    private Context context;
    private String uri;

    public PhotoDialog(Context context , String uri) {
        super(context);
        this.context = context;
        this.uri = uri;
    }

    @Override
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
        setContentView(R.layout.photo_dialog);
        Button button = findViewById(R.id.clos_btn);
        ImageView imageView = findViewById(R.id.specific_photo);
        Picasso.get().load(uri).into(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        super.show();
    }
}
