package tw.tcnr12.m0705;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class M0705 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory,
        AdapterView.OnItemClickListener {


    private ImageSwitcher txtComPlay;
    private TextView txtSelect;
    private TextView txtResult;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private String user_select, answer;
    private MediaPlayer startmusic,mediaWin,mediaLose,mediaDraw,Endmusic;
    private Toast toast;
    private RelativeLayout r_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewComponent();
    }

    private void setupViewComponent() {

//        // --開啟片頭音樂-----
//        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//        startmusic.start();
        startmusic = MediaPlayer.create(getApplication(),R.raw.guess);
        startmusic.start();

        mediaWin = MediaPlayer.create(getApplication(),R.raw.vctory);
        mediaLose = MediaPlayer.create(getApplication(),R.raw.lose);
        mediaDraw = MediaPlayer.create(getApplication(),R.raw.haha);
        Endmusic = MediaPlayer.create(getApplication(),R.raw.yt1s);
        //------------------------電腦出拳---------------
        txtComPlay = (ImageSwitcher) findViewById(R.id.m0705_c001); // 電腦選擇
        txtComPlay.setFactory(this);
        //------------------開機動畫----------------
        r_layout = (RelativeLayout)findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back01);
        //        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this,R.anim.anim_scale_rotate_in));
        r_layout.setBackgroundResource(R.drawable.back01);

        //--------------------------------------------
        txtSelect = (TextView) findViewById(R.id.m0705_s001); // 選擇結果
        txtResult = (TextView) findViewById(R.id.m0705_f000); // 輸贏判斷

        btnScissors = (ImageButton) findViewById(R.id.m0705_b001); // 剪刀
        btnStone = (ImageButton) findViewById(R.id.m0705_b002); // 石頭
        btnNet = (ImageButton) findViewById(R.id.m0705_b003); // 布

        // ---啟動監聽事件----
        btnScissors.setOnClickListener(b001on);
        btnStone.setOnClickListener(b001on);
        btnNet.setOnClickListener(b001on);

    }


    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            //----------------------先打完玩家選擇的再打電腦選擇的,再把電腦選擇的複製到玩家選擇的,
//            switch (iComPlay){
//                case 1:txtComPlay.setText(R.string.m0705_b001); //電腦出剪刀
//
//                    break;
//                case 2:txtComPlay.setText(R.string.m0705_b002);//電腦出石頭
//
//                    break;
//                case 3:txtComPlay.setText(R.string.m0705_b003);//電腦出布
//
//                    break;
//            }
            // 1 - scissors, 2 - stone, 3 - net.
//------------------------玩家選擇的
            switch (v.getId()) {
                case R.id.m0705_b001: //玩家選擇剪刀

                    user_select = getString(R.string.m0705_s001) + " " + getString(R.string.m0705_b001);
                    u_setalpha();  //----自宣告變數 , 設定剪刀按鈕背景
//                    btnScissors.getBackground().setAlpha(70);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors); //電腦出剪刀,case 1是 int iComPlay = (int)(Math.random() * 3 + 1);的第一種
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f003); //判斷結果
//                            txtResult.setTextColor(Color.YELLOW); //更改字體顏色
                            music ( 2 );
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦出石頭
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f002);//判斷結果
//                            txtResult.setTextColor(Color.RED);
                            music ( 3 );
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);//電腦出布
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f001);//判斷結果
//                            txtResult.setTextColor(Color.GREEN);
                            music ( 1 );
                            break;
                    }
                    break;
                case R.id.m0705_b002: //玩家選擇石頭
                    user_select = getString(R.string.m0705_s001) + " " + getString(R.string.m0705_b002);
                    u_setalpha();  //----自宣告變數 , 設定剪刀按鈕背景
//                    btnStone.getBackground().setAlpha(70);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);  //電腦出剪刀
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f001);//判斷結果
//                            txtResult.setTextColor(Color.GREEN);
                            music ( 1 );
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦出石頭
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f003);//判斷結果
//                            txtResult.setTextColor(Color.YELLOW);
                            music ( 2 );
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);//電腦出布
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f002);//判斷結果
//                            txtResult.setTextColor(Color.RED);
                            music ( 3 );
                            break;
                    }
                    break;
                case R.id.m0705_b003: //玩家選擇布
                    user_select = getString(R.string.m0705_s001) + " " + getString(R.string.m0705_b003);
                    u_setalpha();  //----自宣告變數 , 設定剪刀按鈕背景
//                    btnNet.getBackground().setAlpha(70);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);  //電腦出剪刀
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f002);//判斷結果
//                            txtResult.setTextColor(Color.RED);
                            music ( 3 );
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦出石頭
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f001);//判斷結果
//                            txtResult.setTextColor(Color.GREEN);
                            music ( 1 );
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);//電腦出布
//                            answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f003);//判斷結果
//                            txtResult.setTextColor(Color.YELLOW);
                            music ( 2 );
                            break;
                    }
                    break;
            }
            txtComPlay.clearAnimation();
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_trans_bounce);
            anim.setInterpolator(new BounceInterpolator());
            txtComPlay.setAnimation(anim);
            //-----------------------------結果---------------
            txtSelect.setText(user_select);   //你選擇的+輸出
            txtResult.setText(answer);  //判斷輸贏+結果
        }
    };

    private void u_setalpha() {
        //imageButton 背景為銀色且為全透明
        //imageButton 背景為銀色且為全透明
//        btnScissors.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));  舊的寫法
//        btnScissors.getBackground().setAlpha(0); //0-255
//        btnStone.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnStone.getBackground().setAlpha(0);
//        btnNet.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnNet.getBackground().setAlpha(0);
        btnScissors.setBackgroundResource(R.drawable.circle_shape);   //新的寫法
        btnScissors.getBackground().setAlpha(0); //0-255
        btnStone.setBackgroundResource(R.drawable.circle_shape);
        btnStone.getBackground().setAlpha(0);
        btnNet.setBackgroundResource(R.drawable.circle_shape);
        btnNet.getBackground().setAlpha(0);
    }

    private void music(int i) {
        if(startmusic.isPlaying()) startmusic.stop();
        if(mediaWin.isPlaying()) mediaWin.pause();
        if(mediaDraw.isPlaying()) mediaDraw.pause();
        if(mediaLose.isPlaying()) mediaLose.pause();
        if(Endmusic.isPlaying()) Endmusic.pause();
        toast = null;

        switch (i){
            case 1: //贏
                answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f001);//判斷結果
                txtResult.setTextColor(Color.GREEN);
                mediaWin.start();
                Toast.makeText(getApplicationContext(),getText(R.string.m0705_f001),Toast.LENGTH_SHORT).show();
                break;
            case 2: //平手
                answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f003); //判斷結果
                txtResult.setTextColor(Color.YELLOW); //更改字體顏色
                mediaDraw.start();
                Toast.makeText(getApplicationContext(),getText(R.string.m0705_f003),Toast.LENGTH_SHORT).show();
                break;
            case 3: //輸
                answer = getString(R.string.m0705_f000) + " " + getString(R.string.m0705_f002);//判斷結果
                txtResult.setTextColor(Color.RED);
                mediaLose.start();
                Toast.makeText(getApplicationContext(),getText(R.string.m0705_f002),Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        music(4);
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        music(4);
    }

    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        // v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new
                ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
