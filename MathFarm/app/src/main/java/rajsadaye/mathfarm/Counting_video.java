package rajsadaye.mathfarm;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class Counting_video extends Activity {
    private VideoView videoView;
    String extStorageDirectory;
    protected static final int PLAY = 0x101;
    protected static final int STOP = 0x102;
    protected static final int PAUSE = 0x103;
    int State;
    private String current;

    private String path;
    private VideoView mVideoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_counting_video);

    }
}
