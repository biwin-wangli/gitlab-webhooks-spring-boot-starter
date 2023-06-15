package top.mybiwin.gitlab.webhooks.starter.constant;

/**
 * Gitlab Hooks Type
 *
 * @author wangli
 * @date 2023/6/15 21:33
 */
public interface GitlabHooksConstant {

  String GITLAB_EVENT_HEADER_FLAG = "X-Gitlab-Event";
  String PUSH_EVENTS = "push event";
  String TAG_EVENTS = "Tag Push Hook";
  String ISSUES_EVENTS = "Issue Hook";
  String COMMENT_EVENTS = "Note Hook";
  String COMMENT_ON_MERGE_REQUEST = "Note Hook";
  String COMMENT_ON_ISSUE = "Note Hook";
  String COMMENT_ON_CODE_SNIPPET = "Note Hook";
  String MERGE_REQUEST_EVENTS = "Merge Request Hook";
  String WIKI_PAGE_EVENTS = "Wiki Page Hook";
  String JOB_EVENTS = "Job Hook";

  String GITLAB_SERVER_HOST = "https://axzsource.com/api/v4";
  String CREATE_MR = GITLAB_SERVER_HOST + "/projects/${id}/merge_requests";
}
