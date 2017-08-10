package com.senamoviles.daniel.admobproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    private RewardedVideoAd mAd;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    String APP_ID  = "ca-app-pub-3940256099942544~3347511713";
    Button btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //Es un id para pruebas
        MobileAds.initialize(this,APP_ID);
        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();



        btn_video = (Button) findViewById(R.id.btn_video);

        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRewardedVideo();

            }
        });




    }
    private void showRewardedVideo() {

        if (mAd.isLoaded()) {
            mAd.show();
        }
    }

    private void loadRewardedVideoAd() {
       // mAd.loadAd(APP_ID, new AdRequest.Builder().build());
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).
                addTestDevice("20C4811C2F6676805E00C4E5EE577A9A").build();
        mAd.loadAd(AD_UNIT_ID,adRequest);
    }



    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }
}
