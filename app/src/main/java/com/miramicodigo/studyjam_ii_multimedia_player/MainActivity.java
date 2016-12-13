package com.miramicodigo.studyjam_ii_multimedia_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /**
     * @author Gustavo Lizarraga
     * @version 1.0
     * #DevStudyJam
     * */

    private MediaPlayer mediaPlayer;
    private Animation animacion;
    private ImageView ivAlpha;
    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnStop = (Button)findViewById(R.id.btnStop);
        ivAlpha = (ImageView) findViewById(R.id.ivAlpha);
        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_photo);
        initializeMediaPlayer();
        initUI();
    }

    public void initUI(){
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    public void initUItrue(){
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
    }

    private void initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kygo_firestone);
    }

    public void play(View v){
        try {
            mediaPlayer.start();
            ivAlpha.startAnimation(animacion);
            btnPlay.setEnabled(false);
            initUItrue();
        }catch (IllegalStateException e){
            Log.e("MediaPlayer", e.getMessage());
        }
    }

    public void pause(View v) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            ivAlpha.clearAnimation();
            btnPlay.setEnabled(true);
            btnStop.setEnabled(false);
        }
    }

    public void stop(View v) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            initializeMediaPlayer();
            initUI();
        }
    }
}
