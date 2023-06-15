package top.mybiwin.gitlab.webhooks.starter.dto;

import java.util.List;

/**
 * TODO
 *
 * @author wangli
 * @date 2023/6/15 22:05
 */
public class PushEventDto {
  private String object_kind;
  private String before;
  private String after;
  private String ref;
  private String checkout_sha;
  private Integer user_id;
  private String user_name;
  private String user_email;
  private String user_avatar;
  private Integer project_id;
  private ProjectDto project;
  private RepositoryDto repository;
  private List<CommitDto> commits;
  private Integer total_commits_count;

  public String getObject_kind() {
    return object_kind;
  }

  public void setObject_kind(String object_kind) {
    this.object_kind = object_kind;
  }

  public String getBefore() {
    return before;
  }

  public void setBefore(String before) {
    this.before = before;
  }

  public String getAfter() {
    return after;
  }

  public void setAfter(String after) {
    this.after = after;
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public String getCheckout_sha() {
    return checkout_sha;
  }

  public void setCheckout_sha(String checkout_sha) {
    this.checkout_sha = checkout_sha;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getUser_email() {
    return user_email;
  }

  public void setUser_email(String user_email) {
    this.user_email = user_email;
  }

  public String getUser_avatar() {
    return user_avatar;
  }

  public void setUser_avatar(String user_avatar) {
    this.user_avatar = user_avatar;
  }

  public Integer getProject_id() {
    return project_id;
  }

  public void setProject_id(Integer project_id) {
    this.project_id = project_id;
  }

  public ProjectDto getProject() {
    return project;
  }

  public void setProject(ProjectDto project) {
    this.project = project;
  }

  public RepositoryDto getRepository() {
    return repository;
  }

  public void setRepository(RepositoryDto repository) {
    this.repository = repository;
  }

  public List<CommitDto> getCommits() {
    return commits;
  }

  public void setCommits(List<CommitDto> commits) {
    this.commits = commits;
  }

  public Integer getTotal_commits_count() {
    return total_commits_count;
  }

  public void setTotal_commits_count(Integer total_commits_count) {
    this.total_commits_count = total_commits_count;
  }
}
