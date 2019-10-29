package cn.waves.xmvp.imageloader;

import android.graphics.drawable.Drawable;



public abstract class LoadCallback {
    void onLoadFailed() {}

    public abstract void onLoadReady(Drawable drawable);

    void onLoadCanceled() {}
}
