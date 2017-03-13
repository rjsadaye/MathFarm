package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Countingoptions extends Activity {
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
        setContentView(R.layout.activity_countingoptions);
    }
    public void sendMessage2(View view)
    {
        Intent intent=new Intent(Countingoptions.this,VideoPlayer.class);
        startActivity(intent);
    }
    public void  sendMessage1(View view)
    {
        Intent intent=new Intent(Countingoptions.this,Countingquiz.class);
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
        mMediaPlayer = MediaPlayer.create(this, R.raw.jingle);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(false);
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
