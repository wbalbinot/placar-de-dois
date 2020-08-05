package me.willian.placar;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Set the view and call for the layouts
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let the screen always on
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //Grabs all the buttons by its id and creates its variables
        Button player1Button = (Button)findViewById(R.id.player1);
        Button player2Button = (Button)findViewById(R.id.player2);

        //Set the starter points
        player1Button.setText("0");
        player2Button.setText("0");

        removePoint(player1Button);
        removePoint(player2Button);


    }

    /*
    Older code that add points 1 by 1
    To be able to remove 1 single ponto while the button is holded
    I had to copy a listener code that is in the removePont function
    public void addPoint(View view) {
        Button playerButton = (Button)view;
        int newPoint = Integer.parseInt((String) playerButton.getText()) + 1;
        playerButton.setText(Integer.toString(newPoint));
    }
    */

    public void resetPoints(View view) {

        //Grabs all the buttons by its id and creates its variables
        Button player1Button = (Button)findViewById(R.id.player1);
        Button player2Button = (Button)findViewById(R.id.player2);

        //Set the starter points
        player1Button.setText("0");
        player2Button.setText("0");
    }

    public void removePoint(final Button player){
        player.setOnTouchListener(new View.OnTouchListener() {
            private final Handler handler = new Handler();
            private boolean mBooleanIsPressed;
            private boolean removeuPonto;

            private final Runnable runnable = new Runnable() {
                public void run() {
                    if(mBooleanIsPressed)
                    {
                        removeuPonto = true;
                        int newPoint = Integer.parseInt((String) player.getText()) - 1;
                        player.setText(Integer.toString(newPoint));
                    }
                }
            };

            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    // Execute your Runnable after 5000 milliseconds = 5 seconds.
                    //After this 5secs it will check if is pressed
                    handler.postDelayed(runnable, 500);
                    mBooleanIsPressed = true;
                    removeuPonto = false;
                }
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(mBooleanIsPressed) {
                        mBooleanIsPressed = false;
                        handler.removeCallbacks(runnable);
                        if(!removeuPonto){
                            int newPoint = Integer.parseInt((String) player.getText()) + 1;
                            player.setText(Integer.toString(newPoint));
                        }
                    }
                }

                return false;
            }
        });
    }




}
