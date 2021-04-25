package event.bus.test;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;

/** @author 核桃 walnut_top@qq.com @Created by haoks at 2021/4/25 6:34 下午 */
public class AsyncSubscriberListenerTwo {

  private static AsyncEventBus asyncEventBus = null;

  public AsyncSubscriberListenerTwo(AsyncEventBus asyncEventBus) {
    this.asyncEventBus = asyncEventBus;
  }

  @Subscribe
  public void onEvent(AsyncEventObject object) {
    System.out.println(object);
    asyncEventBus.post(new AsyncEventObject(this));
  }
}
