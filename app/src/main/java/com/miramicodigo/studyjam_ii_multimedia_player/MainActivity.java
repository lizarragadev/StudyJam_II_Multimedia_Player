package com.miramicodigo.studyjam_ii_multimedia_player;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * @author Gustavo Lizarraga
     * @version 1.0
     * #DevStudyJam
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

    }

}
