package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.shapes.Shape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Shapesoptions extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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

}
