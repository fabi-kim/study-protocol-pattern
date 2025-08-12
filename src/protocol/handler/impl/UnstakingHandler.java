package protocol.handler.impl;

import protocol.Protocol;
import protocol.handler.ProtocolHandler;
import protocol.handler.dto.JobDto;
import protocol.handler.dto.ProtocolRequestDto;
import protocol.handler.enums.JobType;
import protocol.handler.enums.Status;
import protocol.template.impl.UnstakingTemplate;

public class UnstakingHandler extends ProtocolHandler {

  Protocol protocol;
  UnstakingTemplate unstakingTemplate;

  public UnstakingHandler(Protocol protocol) {
    this.protocol = protocol;
    this.unstakingTemplate = new UnstakingTemplate(protocol);
  }

  @Override
  public boolean onReady(JobDto jobDto) {
    jobDto.setStatus(Status.PROCESSING);
    ProtocolRequestDto requestDto = jobDto.getRequest();
    boolean result = unstakingTemplate.flow(requestDto.address(), requestDto.amount());
    if (!result) {
      return false;
    }

    jobDto.setStatus(Status.PROCESSED);
    return true;

  }

  @Override
  public boolean nextStatus(JobDto jobDto) {
    ProtocolRequestDto requestDto = jobDto.getRequest();
    if (protocol.getStakingBalance(requestDto.address()).equalsIgnoreCase("INVALID BALANCE")) {
      return false;
    }
    jobDto.setStatus(Status.FINISHED);
    return true;
  }

  @Override
  public boolean onSuccess(JobDto jobDto) {
    jobDto.setStatus(Status.READY);
    jobDto.setType(JobType.UNSTAKING_WITHDRAW);
    return true;
  }

  @Override
  public boolean onFailure(JobDto jobDto) {
    jobDto.setStatus(Status.READY);
    return false;
  }
}
