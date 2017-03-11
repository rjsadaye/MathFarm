package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class Home extends Activity {
    private static final String TAG=Home.class.getName();
    private static ArrayList<Activity> activities=new ArrayList<Activity>();

    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Home.this,Countingoptions.class);
        startActivity(intent);
    }
    @Override
    public void onPause()
    {
        super.onPause();
        mServ.pauseMusic();
    }
    @Override
    public void onDestroy()
    {
        mServ.stopMusic();
        doUnbindService();
        super.onDestroy();


    }
    public static void finishAll()
    {
        for(Activity activity:activities)
            activity.finish();
    }
    public void call1(View view)
    {
        Intent intent=new Intent(Home.this,Shapesoptions.class);
        startActivity(intent);
    }
    public void call2(View view)
    {
        Intent intent=new Intent(Home.this,Plusoptions.class);
        startActivity(intent);
    }
}
