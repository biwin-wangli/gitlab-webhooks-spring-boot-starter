package top.mybiwin.gitlab.webhooks.starter.dto;

import org.springframework.http.HttpStatus;

/**
 * Common Response Model
 *
 * @author wangli
 * @date 2023/6/14 22:33
 * @see {@link HttpStatus}
 */
public class CommonResponse<T> {

  /**
   * 响应状态码
   */
  private Integer code;
  /**
   * 响应消息
   */
  private String message;
  /**
   * 响应数据
   */
  private T data;

  public CommonResponse(HttpStatus httpStatus, T data) {
    this.code = httpStatus.value();
    this.message = httpStatus.getReasonPhrase();
    this.data = data;
  }

  public CommonResponse(HttpStatus httpStatus, String overrideErrorMessage) {
    this.code = httpStatus.value();
    this.message = overrideErrorMessage;
  }


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> CommonResponse<T> success() {
    return success(HttpStatus.OK);
  }

  public static <T> CommonResponse<T> success(HttpStatus httpStatus) {
    return success(httpStatus, null);
  }

  public static <T> CommonResponse<T> success(HttpStatus httpStatus, T data) {
    return new CommonResponse<>(httpStatus, data);
  }

  public static <T> CommonResponse<T> fail(HttpStatus httpStatus) {
    return fail(httpStatus, httpStatus.getReasonPhrase());
  }

  public static <T> CommonResponse<T> fail(HttpStatus httpStatus, String overrideErrorMessage) {
    return new CommonResponse<>(httpStatus, overrideErrorMessage);
  }

}
