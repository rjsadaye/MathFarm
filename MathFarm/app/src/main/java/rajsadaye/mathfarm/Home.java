package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Home extends Activity {

    MediaPlayer mMediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMediaPlayer = MediaPlayer.create(this, R.raw.jingle);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();



        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);

        ToggleButton tb = (ToggleButton)this.findViewById(R.id.toggleButton);
        //default to being available
        tb.setChecked(true);
        // attach an OnClickListener
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // your click actions go here
                Log.i("onToggleClicked", "ToggleClick Event Started");
                //an AudioManager object, to change the volume settings
                AudioManager amanager;
                amanager = (AudioManager) getSystemService(AUDIO_SERVICE);

                // Is the toggle on?
                boolean on = ((ToggleButton) v).isChecked();

                if (!on) {
                    //Log.i("onToggleIsChecked", "ToggleClick Is On");
                    //turn ringer silent
                    //amanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    //Log.i("RINGER_MODE_SILENT", "Set to true");

                    //turn off sound, disable notifications
                    //amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
                    //Log.i("STREAM_SYSTEM", "Set to true");
                    //notifications
                    //amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    //Log.i("STREAM_NOTIFICATION", "Set to true");
                    //alarm
                    //amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
                    //Log.i("STREAM_ALARM", "Set to true");
                    //ringer
                    //amanager.setStreamMute(AudioManager.STREAM_RING, true);
                    //Log.i("STREAM_RING", "Set to true");
                    //media
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    Log.i("STREAM_MUSIC", "Set to true");

                } else {
                    Log.i("onToggleIsChecked", "ToggleClick Is Off");

                    //turn ringer silent
                    //amanager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    //Log.i(".RINGER_MODE_NORMAL", "Set to true");

                    // turn on sound, enable notifications
                    //amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
                    //Log.i("STREAM_SYSTEM", "Set to False");
                    //notifications
                    //amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    //Log.i("STREAM_NOTIFICATION", "Set to False");
                    //alarm
                    // amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
                    //Log.i("STREAM_ALARM", "Set to False");
                    //ringer
                    //amanager.setStreamMute(AudioManager.STREAM_RING, false);
                    //Log.i("STREAM_RING", "Set to False");
                    //media
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    Log.i("STREAM_MUSIC", "Set to False");
                }
                Log.i("onToggleClicked", "ToggleClick Event Ended");
            }
        });
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Home.this,Countingoptions.class);
        mMediaPlayer.stop();
        //intent.putExtra("musicon", musicon);
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


    public void call1(View view)
    {
        Intent intent=new Intent(Home.this,Shapesoptions.class);
        mMediaPlayer.stop();
        //intent.putExtra("musicon", musicon);
        startActivity(intent);
    }
    public void call2(View view)
    {
        Intent intent=new Intent(Home.this,Plusoptions.class);
        mMediaPlayer.stop();
        //intent.putExtra("musicon", musicon);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }



}
