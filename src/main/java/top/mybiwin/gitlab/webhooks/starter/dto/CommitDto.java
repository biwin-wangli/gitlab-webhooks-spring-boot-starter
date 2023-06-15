package top.mybiwin.gitlab.webhooks.starter.dto;

import java.util.List;

/**
 * Event Basic DTO
 *
 * @author wangli
 * @date 2023/6/15 22:15
 */
public class CommitDto {
  private String id;
  private String message;
  private String title;
  private String timestamp;
  private String url;
  private AuthorDto author;
  private List<String> added;
  private List<String> modified;
  private List<String> removed;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public AuthorDto getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDto author) {
    this.author = author;
  }

  public List<String> getAdded() {
    return added;
  }

  public void setAdded(List<String> added) {
    this.added = added;
  }

  public List<String> getModified() {
    return modified;
  }

  public void setModified(List<String> modified) {
    this.modified = modified;
  }

  public List<String> getRemoved() {
    return removed;
  }

  public void setRemoved(List<String> removed) {
    this.removed = removed;
  }
}
