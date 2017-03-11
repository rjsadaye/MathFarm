package rajsadaye.mathfarm;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player2);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final VideoView videoView1 =
                (VideoView) findViewById(R.id.videoView2);
        String uriPath="android.resource://rajsadaye.mathfarm/"+R.raw.video2;
        Uri uri = Uri.parse(uriPath);
        videoView1.setVideoURI(uri);
        videoView1.requestFocus();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView1);
        videoView1.setMediaController(mediaController);

        videoView1.start();
    }
}
