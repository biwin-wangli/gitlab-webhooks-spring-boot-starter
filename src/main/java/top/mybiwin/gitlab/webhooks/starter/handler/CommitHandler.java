package top.mybiwin.gitlab.webhooks.starter.handler;

import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.PropertyPlaceholderHelper;
import top.mybiwin.gitlab.webhooks.starter.dto.PushEventDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static top.mybiwin.gitlab.webhooks.starter.constant.GitlabHooksConstant.CREATE_MR;
import static top.mybiwin.gitlab.webhooks.starter.constant.GitlabHooksConstant.PUSH_EVENTS;

/**
 * Gitlab Push Event Handler
 *
 * <code>{
 * "object_kind": "push",
 * "before": "95790bf891e76fee5e1747ab589903a6a1f80f22",
 * "after": "da1560886d4f094c3e6c9ef40349f7d38b5d27d7",
 * "ref": "refs/heads/master",
 * "checkout_sha": "da1560886d4f094c3e6c9ef40349f7d38b5d27d7",
 * "user_id": 4,
 * "user_name": "John Smith",
 * "user_username": "jsmith",
 * "user_email": "john@example.com",
 * "user_avatar": "https://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=8://s.gravatar.com/avatar/d4c74594d841139328695756648b6bd6?s=80",
 * "project_id": 15,
 * "project":{
 * "id": 15,
 * "name":"Diaspora",
 * "description":"",
 * "web_url":"http://example.com/mike/diaspora",
 * "avatar_url":null,
 * "git_ssh_url":"git@example.com:mike/diaspora.git",
 * "git_http_url":"http://example.com/mike/diaspora.git",
 * "namespace":"Mike",
 * "visibility_level":0,
 * "path_with_namespace":"mike/diaspora",
 * "default_branch":"master",
 * "homepage":"http://example.com/mike/diaspora",
 * "url":"git@example.com:mike/diaspora.git",
 * "ssh_url":"git@example.com:mike/diaspora.git",
 * "http_url":"http://example.com/mike/diaspora.git"
 * },
 * "repository":{
 * "name": "Diaspora",
 * "url": "git@example.com:mike/diaspora.git",
 * "description": "",
 * "homepage": "http://example.com/mike/diaspora",
 * "git_http_url":"http://example.com/mike/diaspora.git",
 * "git_ssh_url":"git@example.com:mike/diaspora.git",
 * "visibility_level":0
 * },
 * "commits": [
 * {
 * "id": "b6568db1bc1dcd7f8b4d5a946b0b91f9dacd7327",
 * "message": "Update Catalan translation to e38cb41.\n\nSee https://gitlab.com/gitlab-org/gitlab for more information",
 * "title": "Update Catalan translation to e38cb41.",
 * "timestamp": "2011-12-12T14:27:31+02:00",
 * "url": "http://example.com/mike/diaspora/commit/b6568db1bc1dcd7f8b4d5a946b0b91f9dacd7327",
 * "author": {
 * "name": "Jordi Mallach",
 * "email": "jordi@softcatala.org"
 * },
 * "added": ["CHANGELOG"],
 * "modified": ["app/controller/application.rb"],
 * "removed": []
 * },
 * {
 * "id": "da1560886d4f094c3e6c9ef40349f7d38b5d27d7",
 * "message": "fixed readme",
 * "title": "fixed readme",
 * "timestamp": "2012-01-03T23:36:29+02:00",
 * "url": "http://example.com/mike/diaspora/commit/da1560886d4f094c3e6c9ef40349f7d38b5d27d7",
 * "author": {
 * "name": "GitLab dev user",
 * "email": "gitlabdev@dv6700.(none)"
 * },
 * "added": ["CHANGELOG"],
 * "modified": ["app/controller/application.rb"],
 * "removed": []
 * }
 * ],
 * "total_commits_count": 4
 * }</code>
 *
 * @author wangli
 * @date 2023/6/15 21:31
 */
@Component
public class CommitHandler extends AbstractHandler {
  private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Override
  protected final boolean support(String eventType) {
    return Objects.equals(PUSH_EVENTS, eventType);
  }


  public void handle(String json) {
    PushEventDto pushEvent = JSONObject.parseObject(json, PushEventDto.class);
    POST();
  }


  public void POST() {
    try {
      PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");
      String request_url = helper.replacePlaceholders(CREATE_MR, placeholderName -> {
        log.info(placeholderName);
        return "376";
      });

      // 1. 获取访问地址URL
      URL url = new URL(request_url);
      // 2. 创建HttpURLConnection对象
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      /* 3. 设置请求参数等 */
      // 请求方式
      connection.setRequestMethod("POST");

      // 超时时间
      connection.setConnectTimeout(3000);
      // 设置是否输出
      connection.setDoOutput(true);
      // 设置是否读入
      connection.setDoInput(true);
      // 设置是否使用缓存
      connection.setUseCaches(false);
      // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
      connection.setInstanceFollowRedirects(true);
      // 设置使用标准编码格式编码参数的名-值对
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Private-Token", "pVxg5rtC8XL9ady5g7dK");
      // 连接
      connection.connect();
      /* 4. 处理输入输出 */
      // 写入参数到请求中
      String params = "{\"id\":376, \"source_branch\":\"hotfix/three_level_protection\", \"target_branch\":\"test\", \"title\": \"test create mr api\"}";
      OutputStream out = connection.getOutputStream();
      out.write(params.getBytes());
      out.flush();
      out.close();
      // 从连接中读取响应信息
      String msg = "";
      int code = connection.getResponseCode();
      //http://0.0.0.0:4000/12.9/ee/api/README.html#status-codes
//      if (code == 200) {
      BufferedReader reader = new BufferedReader(
          new InputStreamReader(connection.getInputStream()));
      String line;

      while ((line = reader.readLine()) != null) {
        msg += line + "\n";
      }
      reader.close();
//      }
      // 5. 断开连接
      connection.disconnect();

      // 处理结果
      System.out.println(msg);
      //{"id":6250,"iid":29,"project_id":376,"title":"test create mr api","description":null,"state":"opened","created_at":"2023-06-15T15:25:28.634Z","updated_at":"2023-06-15T15:25:28.634Z","merged_by":null,"merged_at":null,"closed_by":null,"closed_at":null,"target_branch":"test","source_branch":"hotfix/three_level_protection","user_notes_count":0,"upvotes":0,"downvotes":0,"assignee":null,"author":{"id":78,"name":"王粒","username":"wangli","state":"active","avatar_url":"https://secure.gravatar.com/avatar/36a7b119dcd3d465377e347b349b6df7?s=80\u0026d=identicon","web_url":"https://axzsource.com/wangli"},"assignees":[],"source_project_id":376,"target_project_id":376,"labels":[],"work_in_progress":false,"milestone":null,"merge_when_pipeline_succeeds":false,"merge_status":"can_be_merged","sha":"0f20bf7604ffe6e6b46c829195fe4737721c9e4c","merge_commit_sha":null,"squash_commit_sha":null,"discussion_locked":null,"should_remove_source_branch":null,"force_remove_source_branch":null,"reference":"!29","references":{"short":"!29","relative":"!29","full":"gov/smartplatform/backend/hera!29"},"web_url":"https://axzsource.com/gov/smartplatform/backend/hera/-/merge_requests/29","time_stats":{"time_estimate":0,"total_time_spent":0,"human_time_estimate":null,"human_total_time_spent":null},"squash":false,"task_completion_status":{"count":0,"completed_count":0},"has_conflicts":false,"blocking_discussions_resolved":true,"subscribed":true,"changes_count":"39","latest_build_started_at":null,"latest_build_finished_at":null,"first_deployed_to_production_at":null,"pipeline":null,"head_pipeline":null,"diff_refs":{"base_sha":"018aae333ad690f11310a5512c1785bd1487af8d","head_sha":"0f20bf7604ffe6e6b46c829195fe4737721c9e4c","start_sha":"018aae333ad690f11310a5512c1785bd1487af8d"},"merge_error":null,"user":{"can_merge":true}}
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
