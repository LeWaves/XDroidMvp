// Generated code from Butter Knife. Do not modify!
package cn.rongcv.xmvp.news.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.rongcv.xmvp.news.R;
import cn.waves.xmvp.xrecycle.XStateController;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebActivity_ViewBinding<T extends WebActivity> implements Unbinder {
  protected T target;

  @UiThread
  public WebActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.webView = Utils.findRequiredViewAsType(source, R.id.webView, "field 'webView'", WebView.class);
    target.swipeRefreshLayout = Utils.findRequiredViewAsType(source, R.id.swipeRefreshLayout, "field 'swipeRefreshLayout'", SwipeRefreshLayout.class);
    target.contentLayout = Utils.findRequiredViewAsType(source, R.id.contentLayout, "field 'contentLayout'", XStateController.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.webView = null;
    target.swipeRefreshLayout = null;
    target.contentLayout = null;

    this.target = null;
  }
}
