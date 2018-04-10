package bagusandinata.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar1, progressBar2;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //progress bar circular
        progressBar1 = findViewById(R.id.progressBar1_id);
        progressBar1.setVisibility(View.VISIBLE);

        //progress bar horizontal
        progressBar2 = findViewById(R.id.progressBar2_id);
        progressBar2.setVisibility(View.VISIBLE);
        progressBar2.setProgress(20);
        progressBar2.setSecondaryProgress(0);
        progressBar2.setMax(100);

        //handler progress bar circular
//        handler = new Handler();
//
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                timer.cancel();
//                progressBar1.setVisibility(View.GONE);
//            }
//        };
//
//        timer = new Timer();
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(runnable);
//            }
//        }, 2000, 10000);

        //handler progress bar horizontal
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                if (++i <= 100){

                    progressBar2.setProgress(i);
                    progressBar2.setSecondaryProgress(i+10);

                }else {

                    timer.cancel();

                }

            }
        };

        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 8000, 300);
    }
}
