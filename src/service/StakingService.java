package service;

import protocol.Protocol;
import protocol.template.ProtocolTemplate;
import protocol.template.impl.StakingTemplate;
import protocol.template.impl.UnstakingTemplate;
import protocol.template.impl.UnstakingWithdrawTemplate;

public class StakingService {

  private final ProtocolTemplate stakingTemplate;
  private final ProtocolTemplate unstakingTemplate;
  private final ProtocolTemplate unstakingWithdrawFlow;

  public StakingService(Protocol protocol) {
    stakingTemplate = new StakingTemplate(protocol);
    unstakingTemplate = new UnstakingTemplate(protocol);
    unstakingWithdrawFlow = new UnstakingWithdrawTemplate(protocol);
  }

  public boolean stakingFlow(String address, String amount) {
    return stakingTemplate.flow(address, amount);
  }

  public boolean unstakingFlow(String address, String amount) {
    return unstakingTemplate.flow(address, amount);
  }

  public boolean unstakingWithdrawFlow(String address) {
    return unstakingWithdrawFlow.flow(address, "");
  }

}
