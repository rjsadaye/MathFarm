package rajsadaye.mathfarm;

import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Locale;

public class Countingquiz extends Activity implements TextToSpeech.OnInitListener {
    protected TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tts = new TextToSpeech(this, this);
        speakOut();
        tts.stop();

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//remove title

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//fullscreen

        setContentView(R.layout.activity_countingquiz);

        tts = new TextToSpeech(this, this);
        speakOut();
        tts.stop();

    }

    @Override
    public void onDestroy() {
// Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
            }

        } else {
            Log.e("TTS", " Initialization Failed!");
        }

    }

    public void wrongans(View view)
    {
        Intent intent=new Intent(Countingquiz.this,Wronganswer.class);
        startActivity(intent);

    }
    public void rightans(View view)
    {
        Intent intent=new Intent(Countingquiz.this,CorrectAnswer.class);
        startActivity(intent);

    }
    private void speakOut() {
        String text = "How many Flowers";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }

}
