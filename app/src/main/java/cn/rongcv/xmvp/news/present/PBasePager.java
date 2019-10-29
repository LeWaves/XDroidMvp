package cn.rongcv.xmvp.news.present;


import cn.rongcv.xmvp.news.model.GankResults;
import cn.rongcv.xmvp.news.net.Api;
import cn.rongcv.xmvp.news.ui.BasePagerFragment;
import cn.waves.xmvp.mvp.XPresent;
import cn.waves.xmvp.net.ApiSubscriber;
import cn.waves.xmvp.net.NetError;
import cn.waves.xmvp.net.XApi;

/**
 * Created by wanglei on 2016/12/31.
 */

public class PBasePager extends XPresent<BasePagerFragment> {
    protected static final int PAGE_SIZE = 10;


    public void loadData(String type, final int page) {
        Api.getGankService().getGankData(type, PAGE_SIZE, page)
                .compose(XApi.<GankResults>getApiTransformer())
                .compose(XApi.<GankResults>getScheduler())
                .compose(getV().<GankResults>bindToLifecycle())
                .subscribe(new ApiSubscriber<GankResults>() {
                    @Override
                    protected void onFail(NetError error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onNext(GankResults gankResults) {
                        getV().showData(page, gankResults);
                    }
                });
    }
}
