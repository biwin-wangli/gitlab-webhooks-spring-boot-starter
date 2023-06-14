package top.mybiwin.gitlab.webhooks.starter.handler;

/**
 * TODO
 *
 * @author wangli
 * @date 2023/6/14 23:25
 */
public class MergeRequestHandler extends AbstractHandler {
  @Override
  protected boolean support(String eventType) {
    return false;
  }
}
