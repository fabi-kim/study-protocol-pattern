package protocol.handler.dto;

import protocol.handler.enums.JobType;
import protocol.handler.enums.Status;

public class JobDto {

  private int id;
  private ProtocolRequestDto request;
  private JobType type;
  private Status status;

  public JobDto(int id, ProtocolRequestDto request, JobType type, Status status) {
    this.id = id;
    this.request = request;
    this.type = type;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ProtocolRequestDto getRequest() {
    return request;
  }

  public void setRequest(ProtocolRequestDto request) {
    this.request = request;
  }

  public JobType getType() {
    return type;
  }

  public void setType(JobType type) {
    this.type = type;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
