package com.example.hw7_media;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.io.IOException;

public class VideoActivity extends Activity {
    private SurfaceView surfaceView;
    private SeekBar seekBar;
    private Button play_Button;
    private String videoPath;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    private TextView time;
    private Boolean isPlay=false;
    private boolean started=false;
    private int hour;
    private int minute;
    private int second;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);
        surfaceView=findViewById(R.id.surfaceview);
        seekBar=findViewById(R.id.seekbar);
        play_Button=findViewById(R.id.play);
        play_Button.setClickable(false);
        time=findViewById(R.id.time);
        time.setVisibility(View.INVISIBLE);
        hour=0;
        minute=0;
        second=0;
        videoPath="https://vdept.bdstatic.com/71703144596c487446444b4c47687a70/38423664755a7552/f7caf81968a804f232a45b22cbf6d47101fb9162e67fafc6a257f99dee2c9b17c57aa5c0385fc715f7b6dd0150c0adce.mp4?auth_key=1594841836-0-0-798dc9b95824cffa5c31da233b0f71c8";
        mediaPlayer=new MediaPlayer();
        initSurfaceviewListener();
        play_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!started){
                    changeVideoSize(mediaPlayer);
                    seekBar.setMax(mediaPlayer.getDuration());
                    handler1.postDelayed(SeekBarRenew, 100);
                    started=true;
                }
                if(isPlay){
                    isPlay=!isPlay;
                    play_Button.setBackgroundResource(R.drawable.play);
                    mediaPlayer.pause();
                }
                else{
                    isPlay=!isPlay;
                    play_Button.setBackgroundResource(R.drawable.pause);
                    mediaPlayer.start();
                    time.setVisibility(View.VISIBLE);
                    handler2.postDelayed(task, 1000);
                }
            }
        });
    }

    private void initSurfaceviewListener(){
        surfaceHolder=surfaceView.getHolder();
        surfaceHolder.addCallback(new Callback()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer.setDisplay(holder);//给mMediaPlayer添加预览的SurfaceHolder
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDisplay(surfaceHolder);
                    mediaPlayer.setDataSource(videoPath);
                    mediaPlayer.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
                    mediaPlayer.prepare();//prepare之后自动播放
                    //mediaPlayer.start();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            play_Button.setClickable(true);
                        }
                    });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        time.setVisibility(View.INVISIBLE);
                        hour=0;
                        minute=0;
                        second=0;
                        isPlay=false;
                        mediaPlayer.seekTo(0);
                        mediaPlayer.stop();
                    }
                });
                }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                surfaceHolder=holder;
            }
            @Override
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                surfaceView=null;
                surfaceHolder=null;
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                isPlay=false;
                play_Button.setBackgroundResource(R.drawable.play);
            }
        });
    }
    private Handler handler1=new Handler();
    private Handler handler2=new Handler();
    private Runnable SeekBarRenew =new Runnable() {
        public void run() {
            handler1.postDelayed(this, 100);
            if(mediaPlayer!=null&&isPlay)
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
        }
    };
    @Override
    public void onRestart(){
        super.onRestart();
        finish();
    }
    public void changeVideoSize(MediaPlayer mediaPlayer) {
        int surfaceWidth = surfaceView.getWidth();
        int surfaceHeight = surfaceView.getHeight();

        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();

        //根据视频尺寸去计算->视频可以在sufaceView中放大的最大倍数。
        float max;
        if (getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            //竖屏模式下按视频宽度计算放大倍数值
            max = Math.max((float) videoWidth / (float) surfaceWidth, (float) videoHeight / (float) surfaceHeight);
        } else {
            //横屏模式下按视频高度计算放大倍数值
            max = Math.max(((float) videoWidth / (float) surfaceHeight), (float) videoHeight / (float) surfaceWidth);
        }

        //视频宽高分别/最大倍数值 计算出放大后的视频尺寸
        videoWidth = (int) Math.ceil((float) videoWidth / max);
        videoHeight = (int) Math.ceil((float) videoHeight / max);

        //无法直接设置视频尺寸，将计算出的视频尺寸设置到surfaceView 让视频自动填充。
        surfaceView.setLayoutParams(new LinearLayout.LayoutParams(videoWidth, videoHeight));
    }

    private Runnable task = new Runnable() {
        public void run() {
            if (isPlay) {
                handler2.postDelayed(this, 1000);
                second++;
                if (second >= 60) {
                    minute++;
                    second = second % 60;
                }
                if (minute >= 60) {
                    hour++;
                    minute = minute % 60;
                }
                time.setText(FormatUtil.format(hour) + ":" + FormatUtil.format(minute) + ":"
                        + FormatUtil.format(second));
            }
        }
    };
}

