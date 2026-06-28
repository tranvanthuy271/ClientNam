package com.beatdz.langlalau.android;

import android.os.Bundle;

import beatdz.AppListener;
import beatdz.Binary;
import beatdz.LangLa_dd;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.boot.GameM;
import com.platform.MobilePlatformAdapter;

/** Launches the shared game client on Android. */
public final class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binary.a = "animesoft/1/";
        MobilePlatformAdapter platform = new MobilePlatformAdapter();
        GameM.b(platform);
        GameM.a(platform);

        AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
        configuration.useImmersiveMode = true;
        configuration.useAccelerometer = false;
        configuration.useCompass = false;
        initialize(AppListener.gI(), configuration);
    }
}
