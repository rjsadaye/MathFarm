package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Countingoptions extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


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
}
