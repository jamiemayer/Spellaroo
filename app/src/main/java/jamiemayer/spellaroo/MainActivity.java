package jamiemayer.spellaroo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer bgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Trying to hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // ----------------------
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        bgm = MediaPlayer.create(this, R.raw.bensound_littleidea);
        bgm.start();
    }

    @Override
    protected void onStop(){
        super.onStop();
        bgm.release();
        bgm = null;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        bgm.release();
        bgm= null;
    }


    public void startButton (View vew) {
        Intent levSel = new Intent(this, level_select.class);
        startActivity(levSel);
    }
}
