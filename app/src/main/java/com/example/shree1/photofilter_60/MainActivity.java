package com.example.shree1.photofilter_60;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView radsImage;
    Drawable myPhoto;
    Bitmap bitmapImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radsImage=(ImageView)findViewById(R.id.radsImageview);
        Drawable[] sequence=new Drawable[2];
        sequence[0]=getResources().getDrawable(R.drawable.img);
        sequence[1]=getResources().getDrawable(R.drawable.download);
        LayerDrawable obj=new LayerDrawable(sequence);
        radsImage.setImageDrawable(obj);

    }
    // invert a bitmap image
    public static Bitmap VintageEffect(Bitmap original)
    {
        Bitmap finalImage=Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());

        int A,R,G,B;
        int pixelColor;
        int height=original.getHeight();
        int width=original.getWidth();
        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++)
            {
                pixelColor=original.getPixel(x,y);
                A= Color.alpha(pixelColor);
                R= 255-Color.red(pixelColor);
                G= 255-Color.green(pixelColor);
                B= 255-Color.blue(pixelColor);
                finalImage.setPixel(x,y,Color.argb(A,R,G,B));

            }
        }

        return finalImage;
    }

}
