package cn.waves.xmvp.xrecycle;



public interface LoadMoreUIHandler {
    void onLoading();

    void onLoadFinish(boolean hasMore);
}
