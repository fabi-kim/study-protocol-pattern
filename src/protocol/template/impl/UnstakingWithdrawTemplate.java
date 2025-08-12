package protocol.template.impl;

import protocol.Protocol;
import protocol.template.ProtocolTemplate;

public class UnstakingWithdrawTemplate extends ProtocolTemplate {

  public UnstakingWithdrawTemplate(Protocol protocol) {
    super(protocol);
  }

  @Override
  protected boolean isExecutableFlow(String address, String amount) {
    return !address.equalsIgnoreCase("invailid address");
  }

  @Override
  protected String createTransaction(String address, String amount) {
    return protocol.createUnsignedUnstakedWithdrawTransaction(address);
  }
}
