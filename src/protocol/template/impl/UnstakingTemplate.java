package protocol.template.impl;

import protocol.Protocol;
import protocol.template.ProtocolTemplate;

public class UnstakingTemplate extends ProtocolTemplate {

  public UnstakingTemplate(Protocol protocol) {
    super(protocol);
  }

  @Override
  protected boolean isExecutableFlow(String address, String amount) {
    if (Integer.parseInt(amount) < 0) {
      return false;
    }
    if (protocol.getStakingBalance(address).equalsIgnoreCase("0")) {
      return false;
    }
    return !address.equalsIgnoreCase("invailid address");
  }

  @Override
  protected String createTransaction(String address, String amount) {
    return protocol.createUnsignedUntakingTransaction(address, amount);
  }
}
