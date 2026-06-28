package com.platform;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.listener.AppEventListener;
import com.listener.IDialogTextListener;
import com.listener.VoiceRecordPermissionCallback;

/**
 * Portable implementation for functionality that used native desktop hooks in
 * the original client. Android and iOS both use LibGDX's standard input dialog.
 */
public final class MobilePlatformAdapter implements AppEventListener, IDialogTextListener {
    @Override
    public void a() {
        // The mobile stores update the application package instead of replacing it at runtime.
    }

    @Override
    public void a(VoiceRecordPermissionCallback callback) {
        if (callback != null) {
            callback.a();
        }
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void a(byte[] data) {
        // Native voice codec is not bundled on mobile.
    }

    @Override
    public byte[] b(byte[] data) {
        return data;
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public void a(TextInputListener listener, String title, String text, String hint) {
        Gdx.input.getTextInput(listener, title, text, hint);
    }

    @Override
    public int a(String title, String message) {
        Gdx.app.log(title, message);
        return -1;
    }
}
