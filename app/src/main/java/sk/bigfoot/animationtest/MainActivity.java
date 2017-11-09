package sk.bigfoot.animationtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.AnimationListener;
import com.richpathanimator.RichPathAnimator;

public class MainActivity extends AppCompatActivity {
    private RichPathView playlistRichPathView;
    private RichPathView playNotifRichPathView;
    private RichPath line5;
    private RichPath line6;
    private RichPath line7;
    private RichPath line1;
    private boolean notif = false;
    private boolean friend = false;
    private boolean restart = false;
    RichPathAnimator rigRichPathAnimator;
    RichPath line2;
    RichPath line3;
    RichPath line4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notification();
            }
        });
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fabAlert);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friend();
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fabRestart);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restart();
            }


        });
        playlistRichPathView = findViewById(R.id.friend);
        playNotifRichPathView = findViewById(R.id.notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        line1 = playlistRichPathView.findRichPathByName("friend_cross");
        line2 = playlistRichPathView.findRichPathByName("friend_body");
        line3 = playlistRichPathView.findRichPathByName("friend_head");
        line4 = playNotifRichPathView.findRichPathByName("bubble");
        line7 = playlistRichPathView.findRichPathByName("friend_cross_vertical");
        line5 = playNotifRichPathView.findRichPathByName("alert_stroke");
        line6 = playNotifRichPathView.findRichPathByName("alert_fill");
        String elephantPathData = getString(R.string.minus_path);
        String plusPathData = getString(R.string.plus_path);
        line1.setFillColor(Color.TRANSPARENT);
        line2.setFillColor(Color.TRANSPARENT);
        line3.setFillColor(Color.TRANSPARENT);
        line4.setFillColor(Color.TRANSPARENT);
        line6.setFillAlpha(0);
        line5.setFillAlpha(0);
        RichPathAnimator.animate(line1)
                .trimPathEnd(0f, 1f)
                .startDelay(100)
                .duration(700)
                .andAnimate(line2)
                .trimPathEnd(0f, 1f)
                .startDelay(100)
                .duration(700)
                .andAnimate(line3)
                .trimPathEnd(0f, 1f)
                .startDelay(100)
                .trimPathEnd(0f, 1f)
                .andAnimate(line4)
                .trimPathEnd(1f)
                .duration(700)
                .startDelay(100)
                .andAnimate(line7)
                .trimPathEnd(1f)
                .startDelay(200)
                .duration(700)
                .start();
    }

    private void restart() {
        if (restart) {
            RichPathAnimator.animate(line1)
                    .trimPathEnd(1f)
                    .startDelay(100)
                    .duration(700)
                    .andAnimate(line2)
                    .trimPathEnd(1f)
                    .startDelay(100)
                    .duration(700)
                    .andAnimate(line3)
                    .trimPathEnd(1f)
                    .trimPathEnd(1f)
                    .andAnimate(line4)
                    .trimPathEnd(1f)
                    .duration(700)
                    .startDelay(100)
                    .andAnimate(line7)
                    .trimPathEnd(1f)
                    .duration(700)
                    .start();
        } else {
            RichPathAnimator.animate(line1)
                    .trimPathEnd(0f)
                    .startDelay(100)
                    .duration(700)
                    .andAnimate(line2)
                    .trimPathEnd(0f)
                    .duration(700)
                    .andAnimate(line3)
                    .trimPathEnd(0f)
                    .startDelay(100)
                    .trimPathEnd(0f)
                    .andAnimate(line4)
                    .trimPathEnd(0f)
                    .duration(700)
                    .andAnimate(line7)
                    .trimPathEnd(0f)
                    .duration(700)
                    .andAnimate(line6)
                    .interpolator(new LinearInterpolator())
                    .fillAlpha(0f)
                    .duration(200)
                    .andAnimate(line5)
                    .fillAlpha(0f)
                    .duration(200)
                    .start();
        }
        restart = !restart;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void notification() {
        if (!notif) {
        /*  RichPathAnimator.animate(line5)
                        .scaleX(0)
                        .scaleY(0)
                        .interpolator(new LinearInterpolator())
                        .duration(700)
                        .start();*/
            RichPathAnimator.animate(line6)
                    .interpolator(new LinearInterpolator())
                    .fillAlpha(0f, 1f)
                    .duration(200)
                    .andAnimate(line5)
                    .fillAlpha(0f, 1f)
                    .duration(200)
                    .start();
        } else {
           /* RichPathAnimator.animate(line5)
                    .scaleX(1)
                    .scaleY(1)
                    .interpolator(new LinearInterpolator())
                    .duration(700)
                    .start();*/
            RichPathAnimator.animate(line6)
                    .interpolator(new LinearInterpolator())
                    .fillAlpha(1f, 0f)
                    .duration(200)
                    .andAnimate(line5)
                    .fillAlpha(1f, 0f)
                    .duration(200)
                    .start();

        }
        notif = !notif;
    }

    public void friend() {
        if (!friend) {
            RichPathAnimator rigRichPathAnimator = RichPathAnimator.animate(line1)
                    .trimPathEnd(0f)
                    .duration(500)
                    .animationListener(new AnimationListener() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onStop() {
                            line1.setFillColor(Color.TRANSPARENT);
                            line1.setStrokeColor(Color.TRANSPARENT);
                        }
                    })
                    .start();


        } else {
            RichPathAnimator rigRichPathAnimator = RichPathAnimator.animate(line1)
                    .trimPathEnd(1f)
                    .animationListener(new AnimationListener() {
                        @Override
                        public void onStart() {
                            line1.setFillColor(Color.WHITE);
                            line1.setStrokeColor(Color.WHITE);
                        }

                        @Override
                        public void onStop() {

                        }
                    })
                    .duration(500)
                    .start();
        }
        friend = !friend;
    }
}
