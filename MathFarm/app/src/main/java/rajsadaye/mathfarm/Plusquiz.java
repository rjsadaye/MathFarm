package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Plusquiz extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_plusquiz);
    }
    public void wrongans(View view)
    {
        Intent intent=new Intent(Plusquiz.this,Wronganswer.class);
        startActivity(intent);
    }
    public void rightans(View view)
    {
        Intent intent=new Intent(Plusquiz.this,CorrectAnswer.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }

}
