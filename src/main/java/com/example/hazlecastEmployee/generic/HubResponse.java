package com.example.hazlecastEmployee.generic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class HubResponse<T> {
  HubStatusCode status;
  T responseObject;

  @JsonIgnore
  private HttpStatus statusCode;

  public HubResponse() {
    this.statusCode = HttpStatus.OK;
  }

  public HubResponse(HubStatusCode status) {
    this();
    this.status = status;
  }

  public HubResponse(T responseObject, HubStatusCode status) {
    this();
    this.responseObject = responseObject;
    this.status = status;
  }
}
