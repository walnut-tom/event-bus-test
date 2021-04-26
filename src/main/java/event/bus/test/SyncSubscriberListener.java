package event.bus.test;

import com.google.common.eventbus.Subscribe;

/**
 * @author 核桃 walnut_top@qq.com
 * @Created by haoks at 2021/4/25 6:34 下午
 */
public class SyncSubscriberListener {

    @Subscribe
    public void onEvent(SyncEventObject object){
        System.out.println(System.currentTimeMillis() + "; object = " + object);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
