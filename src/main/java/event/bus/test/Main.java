package event.bus.test;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/** @author 核桃 walnut_top@qq.com @Created by haoks at 2021/4/25 6:26 下午 */
public class Main {
  public static void main(String[] args) {
    // create executor
    Executor executor = Executors.newCachedThreadPool();
    AsyncEventBus asyncEventBus = new AsyncEventBus(executor);
    asyncEventBus.register(new AsyncSubscriberListenerOne());
    asyncEventBus.register(new AsyncSubscriberListenerTwo(asyncEventBus));
    asyncEventBus.post(new AsyncEventObject(System.currentTimeMillis()));
  }
}
