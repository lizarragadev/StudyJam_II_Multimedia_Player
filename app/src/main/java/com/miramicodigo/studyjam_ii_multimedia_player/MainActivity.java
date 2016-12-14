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

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private ImageView ivAlpha;

    private Animation animacion;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        ivAlpha = (ImageView) findViewById(R.id.ivAlpha);

        animacion = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.blink_photo);
        initUI();
        initMediaPlayer();
    }

    public void initUI() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    public void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(
                getApplicationContext(),
                R.raw.kygo_firestone);
    }

    public void play(View view) {
        try {
            mediaPlayer.start();
            ivAlpha.startAnimation(animacion);
            btnPause.setEnabled(true);
            btnStop.setEnabled(true);
            btnPlay.setEnabled(false);
        } catch (IllegalStateException e){
            Log.i("MediaPlayer", "Error: "+e.getMessage());
        }
    }
    public void pause(View view) {
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            ivAlpha.clearAnimation();
            btnPlay.setEnabled(true);
            btnStop.setEnabled(false);
        }
    }
    public void stop(View view) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            initMediaPlayer();
            ivAlpha.clearAnimation();
            btnPlay.setEnabled(true);
            btnPause.setEnabled(false);
        }
    }

}
