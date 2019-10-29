package cn.waves.xmvp.event;



public interface IBus {

    void register(Object object);

    void unregister(Object object);

    void post(AbsEvent event);

    void postSticky(AbsEvent event);


    abstract class AbsEvent {
        public abstract int getTag();
    }

}
