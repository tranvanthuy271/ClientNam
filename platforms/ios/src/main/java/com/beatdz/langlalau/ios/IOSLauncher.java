package com.beatdz.langlalau.ios;

import beatdz.AppListener;
import beatdz.Binary;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.boot.GameM;
import com.platform.MobilePlatformAdapter;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

/** Launches the shared game client on iOS through RoboVM. */
public final class IOSLauncher extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        Binary.a = "animesoft/1/";
        MobilePlatformAdapter platform = new MobilePlatformAdapter();
        GameM.b(platform);
        GameM.a(platform);

        IOSApplicationConfiguration configuration = new IOSApplicationConfiguration();
        configuration.orientationLandscape = true;
        configuration.orientationPortrait = false;
        return new IOSApplication(AppListener.gI(), configuration);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}
