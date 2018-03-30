package klapper.caseupload;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import klapper.caseupload.util.f_b;


public class MainActivity extends Activity {
    ProgressBar pb;
    TextView textv;
    Button btn2;
    boolean isrunning = false;
    ImageButton btn1;
    SeekBar seekBar;
    WaveView waveView;
    int values = 1;
    int originalWH = 0;
    int top_value = 0;
    float button_x,button_y = 0;
    float ofs = 1;
    int offset_range = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        textv = (TextView) findViewById(R.id.pernum);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setMinimumWidth(1);
        btn2.setMinimumHeight(1);
        btn1 = (ImageButton) findViewById(R.id.imageButton2);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        waveView = (WaveView) findViewById(R.id.waveview);
        RelativeLayout rv = (RelativeLayout)findViewById(R.id.rv);

        Snackbar.make(rv,"Hello\n\tHello\n\t\tHello\n\t\t\tHello\n\t\t\t\tHello",Snackbar.LENGTH_INDEFINITE)
                .setAction("ClickME", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .show();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("MYLOG", "onProgressChanged: " + progress);
                waveView.setProgress(progress);
                offset_range = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Log.d("MYLOG", "onStartTrackingTouch: "+ seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Log.d("MYLOG", "onStopTrackingTouch: "+ seekBar.getProgress());
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(originalWH<2 || top_value <2 || button_x <2 || button_y <2) {
                    originalWH = (btn2.getHeight() + btn2.getWidth()) / 2;
                    top_value = btn2.getTop();

                    Log.d("MYLOG","Old btn2-Pivot: "+btn2.getPivotX()+", "+btn2.getPivotY());
                    btn2.setPivotX(30);
                    btn2.setPivotY(30);
                    Log.d("MYLOG","New btn2-Pivot: "+btn2.getPivotX()+", "+btn2.getPivotY());
                    button_x = btn2.getX();
                    button_y = btn2.getY();
                    Log.d("MYLOG","New btn2-Pivot: "+button_x+", "+button_y);
                }
                setViewAnimation(btn2);
                Log.d("MYLOG","OriginalWH: "+originalWH);
                if (isrunning) {
                    isrunning = false;
                    //nhandler.removeCallbacks(runnable);
                } else {
                    isrunning = true;
                    //nhandler.post(runnable);
                }

            }
        });

        /*for(int a=0; a<20;a++){
            Log.d("MYLOG", "onCreate: "+"a: "+a+" : "+Math.sin((double)a*0.1));
        }
        */


        f_b c = new f_b(5, 6, 7);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3000; i++) {
                        Thread.sleep(20);
                        ofs++;
                        if (ofs > 180) {
                            ofs = 1;
                        }
                        Message message = new Message();
                        message.arg1 = (int) ofs;
                        handler.sendMessage(message);
                    }
                    Log.d("MYLOG", "Loading Complete");
                } catch (Exception e) {

                }
            }
        });
        //thread.start();
    }

    public void setViewAnimation(View v){
        AnimatorSet ans = new AnimatorSet();
        ObjectAnimator[] ann = new ObjectAnimator[2];
        ann[0] = ObjectAnimator.ofFloat(v,"scaleX",0,1);
        ann[1] = ObjectAnimator.ofFloat(v,"scaleY",0,1);
        ans.playTogether(ann);
        ans.setDuration(1000);
        ans.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //pb.incrementProgressBy(5);
            //textv.setText((msg.arg1==0? 1:msg.arg1+1)*5+" %");
            float fff = (float) (Math.sin((double) msg.arg1 * 0.1) * 50) + 150f;
            float ttt = (float) (Math.tan((double) msg.arg1 * 0.01) * 50);
            btn2.setY(fff);
            btn2.setX(ttt);
            //Log.d("MYLOG", "handleMessage: "+fff);
            btn1.setX((float) msg.arg1 * 8);
        }
    };

    Handler nhandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (values < 190) {
                float fff = (float) (Math.sin((double) values * 0.1) * 50) + top_value;
                float fff2 = (float) (Math.sin((double) values * 0.1) * offset_range) + top_value;
                float ttt = (float) (Math.tan((double) values * 0.01) * 50);

                //btn2.setX(button_x-(fff2/2));
                //btn2.setY(button_y-(fff2/2));
                //btn2.setPivotX(150);
                //btn2.setRotation(fff2);
                //btn2.setWidth((int)fff2);
                //btn2.setHeight((int)fff2);
                //btn2.setHeight((int)fff+originalWH);
                //btn2.setY(fff);
                //btn2.setX(ttt);
                //Log.d("MYLOG", "handleMessage: "+fff);
                //btn1.setX((float) values * 8);
                values++;
                //Log.d("MYLOG","Width: "+btn2.getWidth());
            } else {
                values = 1;
            }
            nhandler.postDelayed(this, 10);
        }
    };


}
