package com.example.hw7_media;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageActivity extends Activity {
    private final static int REQUEST_CAMERA = 123;
    private List<String> URLs=new ArrayList<String>();
    private ImageView mImageView;
    private Button next;
    private int i=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
        mImageView=findViewById(R.id.imageview);
        next=findViewById(R.id.changepic);
        URLs.add("https://c-ssl.duitang.com/uploads/item/201511/22/20151122172148_w54xh.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201511/22/20151122172139_fTjey.thumb.700_0.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201511/22/20151122172125_3aGK5.thumb.700_0.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201511/22/20151122172111_eGxNn.thumb.700_0.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201705/19/20170519212612_ftNJK.thumb.700_0.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201705/19/20170519212604_t2R8C.thumb.700_0.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201705/19/20170519212556_dNmzM.thumb.700_0.jpeg");
        URLs.add("https://c-ssl.duitang.com/uploads/item/201705/19/20170519212540_fGXZn.thumb.700_0.jpeg");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage(URLs.get(i));
                i++;
                if(i>=URLs.size()) i=0;
            }
        });
    }

    private void loadImage(String url) {
        RequestOptions cropOptions = new RequestOptions();
        cropOptions = cropOptions.optionalCenterInside();
        Glide.with(ImageActivity.this)
                .load(url)
                .apply(cropOptions)
                .placeholder(R.drawable.waiting)
                .error(R.drawable.error)
                .fallback(R.drawable.ic_launcher_background)
                .transition(withCrossFade(2000))
                .into(mImageView);
    }
}
