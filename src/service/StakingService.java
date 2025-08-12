package service;

import protocol.Protocol;

public class StakingService {

  private final Protocol protocol;

  public StakingService(Protocol protocol) {
    this.protocol = protocol;
  }

  public boolean stakingFlow(String address, String amount) {
    return true;
  }

  public boolean unstakingFlow(String address, String amount) {
    return true;
  }
}
