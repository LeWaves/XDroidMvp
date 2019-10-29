// Generated code from Butter Knife. Do not modify!
package cn.rongcv.xmvp.news.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cn.rongcv.xmvp.news.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity_ViewBinding<T extends AboutActivity> implements Unbinder {
  protected T target;

  private View view2131230956;

  private View view2131230957;

  @UiThread
  public AboutActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.tv_githubMvc, "method 'clickEvent'");
    view2131230956 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickEvent(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_githubMvp, "method 'clickEvent'");
    view2131230957 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clickEvent(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;

    view2131230956.setOnClickListener(null);
    view2131230956 = null;
    view2131230957.setOnClickListener(null);
    view2131230957 = null;

    this.target = null;
  }
}
