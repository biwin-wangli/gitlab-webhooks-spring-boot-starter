package top.mybiwin.gitlab.webhooks.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import top.mybiwin.gitlab.webhooks.starter.handler.AbstractHandler;
import top.mybiwin.gitlab.webhooks.starter.handler.CommitHandler;

/**
 * GitLab Custom WebHooks Handler
 *
 * @author wangli
 * @date 2023/6/14 22:25
 */
@Configuration
@ComponentScan("top.mybiwin.gitlab.webhooks.starter.controller")
public class GitLabWebHooksAutoConfiguration {
  @Bean
  public AbstractHandler commitHandler() {
    return new CommitHandler();
  }
}
