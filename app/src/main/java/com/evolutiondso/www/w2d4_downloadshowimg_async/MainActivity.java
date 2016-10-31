package com.evolutiondso.www.w2d4_downloadshowimg_async;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private String url[] = {"http://cdn.eldeforma.com/wp-content/uploads/2014/07/best-selfie-ever.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.img_view);
    }

    public void ShowMagic(View view) {
        DownAsyncTask downimgasync = new DownAsyncTask(this.imageView);
        downimgasync.execute(url);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Tu foto se ha bajado", Toast.LENGTH_SHORT);
        toast1.show();

    }
}
