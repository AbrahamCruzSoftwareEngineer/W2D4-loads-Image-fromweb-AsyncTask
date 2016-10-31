package com.evolutiondso.www.w2d4_downloadshowimg_async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Albrtx on 31/10/2016.
 */

public class DownAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;

    private String Url;

    private static final String TAG = "DownTAG";

    private Bitmap img;

    public DownAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }


    private Bitmap downIMG(String url) {
        img = null;
        try{
            URL newUrl = new URL(url);
            HttpURLConnection open = (HttpURLConnection)newUrl.openConnection();
            InputStream is = open.getInputStream();
            Log.d(TAG, "Ya la bajo");
            img = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            Log.d(TAG, "error de un tipo: "+e);
        }

        return img;
    }

    @Override
    protected Bitmap doInBackground(String... url) {
        this.Url = url[0];
        return downIMG(Url);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        Log.d(TAG, "mostrando imagen");
    }
}




