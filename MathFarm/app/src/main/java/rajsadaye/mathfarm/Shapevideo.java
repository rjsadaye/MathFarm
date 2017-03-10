package rajsadaye.mathfarm;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Shapevideo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapevideo);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video_player);
        final VideoView videoView =
                (VideoView) findViewById(R.id.videoView2);
        String uriPath="android.resource://rajsadaye.mathfarm/"+R.raw.video2;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();
    }
}
