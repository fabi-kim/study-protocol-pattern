package protocol.handler;

import protocol.handler.dto.JobDto;

public abstract class ProtocolHandler {

  public final boolean runJob(JobDto job) {
    try {
      switch (job.getStatus()) {
        case READY:
          return onReady(job);
        case PROCESSING:
          return nextStatus(job);
        case FINISHED:
          return onSuccess(job);
        default:
          return false;
      }
    } catch (Exception e) {
      onFailure(job);
      return false;
    }
  }

  protected abstract boolean onReady(JobDto jobDto);

  protected abstract boolean nextStatus(JobDto jobDto);

  protected abstract boolean onSuccess(JobDto jobDto);

  protected abstract boolean onFailure(JobDto jobDto);

}
