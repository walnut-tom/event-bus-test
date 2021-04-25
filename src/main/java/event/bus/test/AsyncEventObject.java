package event.bus.test;

/**
 * @author 核桃 walnut_top@qq.com
 * @Created by haoks at 2021/4/25 6:36 下午
 */
public class AsyncEventObject extends java.util.EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public AsyncEventObject(Object source) {
        super(source);
    }
}
