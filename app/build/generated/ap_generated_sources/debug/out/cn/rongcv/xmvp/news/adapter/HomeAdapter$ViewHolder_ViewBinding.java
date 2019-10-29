// Generated code from Butter Knife. Do not modify!
package cn.rongcv.xmvp.news.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cn.rongcv.xmvp.news.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeAdapter$ViewHolder_ViewBinding<T extends HomeAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HomeAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.ivType = Utils.findRequiredViewAsType(source, R.id.iv_type, "field 'ivType'", ImageView.class);
    target.tvType = Utils.findRequiredViewAsType(source, R.id.tv_type, "field 'tvType'", TextView.class);
    target.ivAuthor = Utils.findRequiredViewAsType(source, R.id.iv_author, "field 'ivAuthor'", ImageView.class);
    target.tvAuthor = Utils.findRequiredViewAsType(source, R.id.tv_author, "field 'tvAuthor'", TextView.class);
    target.tvTime = Utils.findRequiredViewAsType(source, R.id.tv_time, "field 'tvTime'", TextView.class);
    target.rlMessage = Utils.findRequiredViewAsType(source, R.id.rl_message, "field 'rlMessage'", RelativeLayout.class);
    target.ivPart = Utils.findRequiredViewAsType(source, R.id.iv_part, "field 'ivPart'", ImageView.class);
    target.ivVedio = Utils.findRequiredViewAsType(source, R.id.iv_vedio, "field 'ivVedio'", ImageView.class);
    target.tvItem = Utils.findRequiredViewAsType(source, R.id.tv_item, "field 'tvItem'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.ivType = null;
    target.tvType = null;
    target.ivAuthor = null;
    target.tvAuthor = null;
    target.tvTime = null;
    target.rlMessage = null;
    target.ivPart = null;
    target.ivVedio = null;
    target.tvItem = null;

    this.target = null;
  }
}
