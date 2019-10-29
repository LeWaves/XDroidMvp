package cn.rongcv.xmvp.news.net;

import cn.rongcv.xmvp.news.model.GankResults;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface GankService {

    @GET("data/{type}/{number}/{page}")
    Flowable<GankResults> getGankData(@Path("type") String type,
                                      @Path("number") int pageSize,
                                      @Path("page") int pageNum);
}
