package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.shapes.Shape;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Shapesoptions extends Activity {
    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mMediaPlayer = MediaPlayer.create(this, R.raw.jingle);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();

        setContentView(R.layout.activity_shapesoptions);
    }
    public void playvideo(View view)
    {
        Intent intent=new Intent(Shapesoptions.this,Video.class);
        startActivity(intent);
    }
    public void goquiz(View view)
    {
        Intent intent=new Intent(Shapesoptions.this,Shapesquiz.class);
        startActivity(intent);
    }
    @Override
    public void onPause()
    {
        super.onPause();
        mMediaPlayer.stop();
    }

    @Override
    public void onDestroy()
    {

        super.onDestroy();
        mMediaPlayer.stop();

    }
    @Override
    protected void onRestart() {
// TODO Auto-generated method stub

        super.onRestart();
        mMediaPlayer.start();
        //Do your code here
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }



}
