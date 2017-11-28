package com.example.xiangdian.yk_20171020;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private ImageView imageview;//显示图片
    private ProgressBar progressBar;//进度条
    private Button btnDownImg;//下载按钮
    private TextView tvPercent;//下载百分比

    private Handler handler;
    private String url = "http://p2.gexing.com/G1/M00/12/C4/rBACFFJHpmzgzIZFAAFNXUpR1CI018.jpg";
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        imageview = (ImageView)findViewById(R.id.iv_pic);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        tvPercent = (TextView)findViewById(R.id.tv_percent);
    }




    public Bitmap zoomImage(Bitmap bgimage) {
        // 获取这个图片的宽和高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = 0.5f;
        float scaleHeight = 0.5f;
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width, (int) height, matrix, true);
        return bitmap;
    }


}
