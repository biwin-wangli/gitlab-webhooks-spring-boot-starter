package top.mybiwin.gitlab.webhooks.starter.handler;

/**
 * Abstract gitlab webhooks handler for all Event Type
 *
 * @author wangli
 * @date 2023/6/14 23:25
 */
public abstract class AbstractHandler {

  public final void execute(String eventType, String json) {
    if (!support(eventType)) {
      return;
    }

  }

  protected abstract boolean support(String eventType);
}
