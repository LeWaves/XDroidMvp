package cn.rongcv.xmvp.news.ui;

import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import cn.rongcv.xmvp.news.R;
import cn.rongcv.xmvp.news.model.GankResults;
import cn.rongcv.xmvp.news.present.PBasePager;
import cn.rongcv.xmvp.news.widget.StateView;
import cn.waves.xmvp.base.SimpleRecAdapter;
import cn.waves.xmvp.mvp.XLazyFragment;
import cn.waves.xmvp.net.NetError;
import cn.waves.xmvp.xrecycle.XRecyclerContentLayout;
import cn.waves.xmvp.xrecycle.XRecyclerView;

/**
 * Created by wanglei on 2016/12/31.
 */

public abstract class BasePagerFragment extends XLazyFragment<PBasePager> {

    @BindView(R.id.contentLayout)
    XRecyclerContentLayout contentLayout;

    StateView errorView;

    protected static final int MAX_PAGE = 10;


    @Override
    public void initData(Bundle savedInstanceState) {
        initAdapter();
        getP().loadData(getType(), 1);
    }

    private void initAdapter() {
        setLayoutManager(contentLayout.getRecyclerView());
        contentLayout.getRecyclerView()
                .setAdapter(getAdapter());
        contentLayout.getRecyclerView()
                .setOnRefreshAndLoadMoreListener(new XRecyclerView.OnRefreshAndLoadMoreListener() {
                    @Override
                    public void onRefresh() {
                        getP().loadData(getType(), 1);
                    }

                    @Override
                    public void onLoadMore(int page) {
                        getP().loadData(getType(), page);
                    }
                });


        if (errorView == null) {
            errorView = new StateView(context);
            contentLayout.errorView(errorView);
        }
        contentLayout.loadingView(View.inflate(getContext(), R.layout.view_loading, null));

        contentLayout.getRecyclerView().useDefLoadMoreView();
    }

    public abstract SimpleRecAdapter getAdapter();

    public abstract void setLayoutManager(XRecyclerView recyclerView);

    public abstract String getType();


    public void showError(NetError error) {
        if (error != null) {
            switch (error.getType()) {
                case NetError.ParseError:
                    errorView.setMsg("数据解析异常");
                    break;

                case NetError.AuthError:
                    errorView.setMsg("身份验证异常");
                    break;

                case NetError.BusinessError:
                    errorView.setMsg("业务异常");
                    break;

                case NetError.NoConnectError:
                    errorView.setMsg("网络无连接");
                    break;

                case NetError.NoDataError:
                    errorView.setMsg("数据为空");
                    break;

                case NetError.OtherError:
                    errorView.setMsg("其他异常");
                    break;
            }
            contentLayout.showError();
        }
    }

    public void showData(int page, GankResults model) {
        if (page > 1) {
            getAdapter().addData(model.getResults());
        } else {
            getAdapter().setData(model.getResults());
        }

        contentLayout.getRecyclerView().setPage(page, MAX_PAGE);

        if (getAdapter().getItemCount() < 1) {
            contentLayout.showEmpty();
            return;
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_base_pager;
    }

    @Override
    public PBasePager newP() {
        return new PBasePager();
    }
}
