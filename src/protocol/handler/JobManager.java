package protocol.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import protocol.Protocol;
import protocol.handler.dto.JobDto;
import protocol.handler.enums.JobType;
import protocol.handler.impl.UnstakingHandler;
import protocol.handler.impl.UnstakingWithdrawHandler;

public class JobManager {

  Map<JobType, ProtocolHandler> handlerMap;

  List<JobDto> jobDtos;

  public JobManager(Protocol protocol) {
    jobDtos = new ArrayList<>();
    handlerMap = new HashMap<>();
    handlerMap.put(JobType.UNSTAKING, new UnstakingHandler(protocol));
    handlerMap.put(JobType.UNSTAKING_WITHDRAW, new UnstakingWithdrawHandler(protocol));
  }

  public void setJob(JobDto job) {
    jobDtos.add(job);
  }

  public void runJobBatch() {
    for (JobDto job : jobDtos) {
      ProtocolHandler h = handlerMap.get(job.getType());
      if (h != null) {
        h.runJob(job);
      }
    }
  }
}
