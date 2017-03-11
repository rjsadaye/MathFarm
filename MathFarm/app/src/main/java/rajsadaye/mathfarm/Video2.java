package rajsadaye.mathfarm;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video2 extends Activity {
private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen


        this.setContentView(R.layout.activity_video2);


        // setContentView(R.layout.activity_video_player);

        videoView = (VideoView) findViewById(R.id.videoView1);
        String uriPath="android.resource://rajsadaye.mathfarm/"+R.raw.video3;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

    }

    @Override
    public void onPause()
    {
        super.onPause();
        videoView.pause();

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        videoView.stopPlayback();
    }
}

