package top.mybiwin.gitlab.webhooks.starter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mybiwin.gitlab.webhooks.starter.dto.CommonResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Entrance
 *
 * @author wangli
 * @date 2023/6/14 22:28
 */
@RestController
@ConditionalOnWebApplication
@RequestMapping("/global")
public class GitLabWebHooksController {
  private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
  private final static String GITLAB_EVENT_HEADER_FLAG = "X-Gitlab-Event";

  /**
   * pipeline 流程
   * 1. 哪个项目使用哪个 webhooks(解决哪个项目发送到哪个群)
   * 2. 每种 hook 的 EventType 自定义扩展,例如 merge request 默认包含 created/updated/merged/closed or a commit is added in the source branch'
   * 3. 解析 Commit Message, 方便 @对应CR人员
   *
   * @param request
   * @param json
   * @return
   */
  @PostMapping("entrance")
  public CommonResponse<Boolean> entrance(HttpServletRequest request, @RequestBody String json) {
    request.getHeaders(GITLAB_EVENT_HEADER_FLAG);
    log.info("请求JSON:: " + json);


    return CommonResponse.success();
  }
}
