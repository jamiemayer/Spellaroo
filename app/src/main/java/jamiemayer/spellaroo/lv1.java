package jamiemayer.spellaroo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.samples.vision.ocrreader.OcrCaptureActivity;

/*TODO: Final screen to take user back to level select after cow stage.
  TODO: Add 'coming soon' to levels 2 and 3.
  TODO: Add click sounds to buttons and chime sounds to correct answers.
*/

public class lv1 extends AppCompatActivity {

    private MediaPlayer cat_sound;

    static int REQUEST_CODE;
    static int REQUEST_CAT = 1;
    static int REQUEST_DOG = 2;
    static int REQUEST_FROG = 3;
    static int REQUEST_COW = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*/ Trying to hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/
        setContentView(R.layout.activity_lv1);
    }

    @Override
    protected void onStart(){
        super.onStart();
        // Trying to hide status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        cat_sound = MediaPlayer.create(this, R.raw.cat);
        //cat_sound.start();
    }

    protected void play_sound(View view){
        cat_sound.start();
    }

    protected void start_cam_cat(View view){
        Intent cam = new Intent(this, OcrCaptureActivity.class);
        cam.putExtra("word","cat");
        REQUEST_CODE = REQUEST_CAT;
        startActivityForResult(cam,REQUEST_CODE);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String returnedResult= data.getData().toString();
                if (REQUEST_CODE == REQUEST_CAT){cat_sound.release();hide_cat();}
                else{
                    if (REQUEST_CODE == REQUEST_DOG){hide_dog();}
                    else {
                        if (REQUEST_CODE == REQUEST_FROG){hide_frog();}
                        else {
                            if (REQUEST_CODE == REQUEST_COW){hide_cow();}
                        }
                    }
                }

            }
        }
    }

    private void hide_cat(){
        correct();
        ImageButton cam_button = (ImageButton) findViewById(R.id.imageButton5);
        cam_button.setVisibility(View.GONE);
        ImageButton next = (ImageButton) findViewById(R.id.imageButton6);
        next.setVisibility(View.VISIBLE);
        ImageView cat  = (ImageView) findViewById(R.id.cat_image);
        Animation animate_cat = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.cat_anim);
        cat.startAnimation(animate_cat);
        cat_sound.release();
    }

    private void hide_dog(){
        correct();
        ImageButton cam_button = (ImageButton) findViewById(R.id.imageButton7);
        cam_button.setVisibility(View.GONE);
        ImageButton next = (ImageButton) findViewById(R.id.imageButton9);
        next.setVisibility(View.VISIBLE);
        ImageView dog = (ImageView) findViewById(R.id.dog_image);
        //TODO: Parameters in XML Animation files need tweaking so images are in the correct positions
        Animation animate_dog = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.dog_anim);
        dog.startAnimation(animate_dog);

    }

    private void hide_frog(){
        correct();
        ImageButton cam_button = (ImageButton) findViewById(R.id.imageButton10);
        cam_button.setVisibility(View.GONE);
        ImageButton next = (ImageButton) findViewById(R.id.imageButton12);
        next.setVisibility(View.VISIBLE);
        ImageView frog = (ImageView)findViewById(R.id.frog_image);
        //TODO: Parameters in XML Animation files need tweaking so images are in the correct positions
        Animation animate_frog = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.frog_anim);
        frog.startAnimation(animate_frog);
    }

    private void hide_cow(){
        correct();
        ImageButton cam_buttom = (ImageButton) findViewById(R.id.imageButton13);
        cam_buttom.setVisibility(View.GONE);
        ImageView cow = (ImageView) findViewById(R.id.cow_image);
        //TODO: Parameters in XML Animation files need tweaking so images are int the correct positions
        Animation animate_cow = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.cow_anim);
        cow.startAnimation(animate_cow);
        ImageButton complete = (ImageButton) findViewById(R.id.levelComplete);
        complete.setVisibility(View.VISIBLE);
        ImageView well_done = (ImageView) findViewById(R.id.well_done);
        Animation well_done_in = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.dog_in);
        well_done.setVisibility(View.VISIBLE);
        well_done.startAnimation(well_done_in);
    }

    protected void dog(View view){
        ImageButton next = (ImageButton) findViewById(R.id.imageButton6);
        next.setVisibility(View.GONE);
        ImageButton cam_button = (ImageButton) findViewById(R.id.imageButton7);
        cam_button.setVisibility(View.VISIBLE);
        ImageView dog = (ImageView) findViewById(R.id.dog_image);
        Animation dog_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.dog_in);
        dog.setVisibility(View.VISIBLE);
        dog.startAnimation(dog_in);
        ImageButton sound1 = (ImageButton) findViewById(R.id.imageButton4);
        sound1.setVisibility(View.GONE);
        ImageButton sound2 = (ImageButton) findViewById(R.id.imageButton8);
        sound2.setVisibility(View.VISIBLE);
    }

    protected void say_dog(View view){
        MediaPlayer dog_sound = MediaPlayer.create(this, R.raw.dog);
        dog_sound.start();
    }

    protected void cam_start_dog(View view){
        REQUEST_CODE = REQUEST_DOG;
        Intent cam_dog = new Intent(this, OcrCaptureActivity.class);
        cam_dog.putExtra("word","dog");
        startActivityForResult(cam_dog,REQUEST_CODE);
    }

    protected void frog(View view){
        ImageButton next = (ImageButton) findViewById(R.id.imageButton9);
        next.setVisibility(View.GONE);
        ImageButton cam_button = (ImageButton) findViewById(R.id.imageButton10);
        cam_button.setVisibility(View.VISIBLE);
        ImageView frog = (ImageView) findViewById(R.id.frog_image);
        Animation frog_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dog_in);
        frog.startAnimation(frog_in);
        frog.setVisibility(View.VISIBLE);
        ImageButton sound1 = (ImageButton) findViewById(R.id.imageButton8);
        sound1.setVisibility(View.GONE);
        ImageButton sound2 = (ImageButton) findViewById(R.id.imageButton11);
        sound2.setVisibility(View.VISIBLE);
    }

    protected void say_frog(View view){
        MediaPlayer frog_Sound = MediaPlayer.create(this, R.raw.frog);
        frog_Sound.start();
    }

    protected void cam_start_frog(View view){
        REQUEST_CODE = REQUEST_FROG;
        Intent cam_frog = new Intent(this, OcrCaptureActivity.class);
        cam_frog.putExtra("word","frog");
        startActivityForResult(cam_frog,REQUEST_CODE);
    }

    protected void cow (View view){
        ImageButton next = (ImageButton) findViewById(R.id.imageButton12);
        next.setVisibility(View.GONE);
        ImageButton cam_button = (ImageButton) findViewById(R.id.imageButton13);
        cam_button.setVisibility(View.VISIBLE);
        ImageView cow = (ImageView) findViewById(R.id.cow_image);
        Animation cow_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.dog_in);
        cow.startAnimation(cow_in);
        ImageButton sound1 = (ImageButton) findViewById(R.id.imageButton11);
        sound1.setVisibility(View.GONE);
        ImageButton sound2 = (ImageButton) findViewById(R.id.imageButton14);
        sound2.setVisibility(View.VISIBLE);
    }

    protected void say_cow(View view){
        MediaPlayer cow_sound = MediaPlayer.create(this, R.raw.cow);
        cow_sound.start();
    }

    protected void cam_start_cow (View view){
        REQUEST_CODE = REQUEST_COW;
        Intent cam_cow = new Intent(this, OcrCaptureActivity.class);
        cam_cow.putExtra("word","cow");
        startActivityForResult(cam_cow,REQUEST_CODE);
    }

    private void correct(){
        MediaPlayer ansCorrect = MediaPlayer.create(this, R.raw.correct);
        ansCorrect.start();
    }

    private void finishLevel(View view){
        Intent lev_sel = new Intent(this, level_select.class);
        startActivity(lev_sel);
    }

}
