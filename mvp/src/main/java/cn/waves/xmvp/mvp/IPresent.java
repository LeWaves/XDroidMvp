package cn.waves.xmvp.mvp;



public interface IPresent<V> {
    void attachV(V view);

    void detachV();

    boolean hasV();
}
