package top.mybiwin.gitlab.webhooks.starter.dto;

/**
 * Event Basic DTO
 *
 * @author wangli
 * @date 2023/6/15 22:17
 */
public class AuthorDto {
  private String name;
  private String email;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
