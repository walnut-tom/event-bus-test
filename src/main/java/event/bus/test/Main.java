package event.bus.test;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/** @author 核桃 walnut_top@qq.com @Created by haoks at 2021/4/25 6:26 下午 */
public class Main {

  private static final int EVENT_COUNT = 3;

  public static void main(String[] args) {
    // create executor
    Executor executor = Executors.newCachedThreadPool();
    ExecutorService executorService = Executors.newCachedThreadPool();
    final AtomicLong index = new AtomicLong(0);

    final EventBus eventBus = new EventBus();
    eventBus.register(new SyncSubscriberListener());

    executorService.submit(() -> execute(eventBus, index));

    AsyncEventBus asyncEventBus = new AsyncEventBus(executor);
    asyncEventBus.register(new AsyncSubscriberListener());
    executorService.submit(() -> asyncExecute(asyncEventBus, index));
  }

  private static void execute(EventBus eventBus, AtomicLong index) {
    for (int i = 0; i < EVENT_COUNT; i++) {
      eventBus.post(new SyncEventObject(index.incrementAndGet()));
    }
  }

  private static void asyncExecute(EventBus eventBus, AtomicLong index) {
    for (int i = 0; i < EVENT_COUNT; i++) {
      eventBus.post(new AsyncEventObject(index.incrementAndGet()));
    }
  }
}
