package protocol.impl;

import protocol.Protocol;
import protocol.staking.Staking;
import protocol.unstaking.Unstaking;

public class CosmosProtocol extends Protocol {
  private final String symbol;

  protected CosmosProtocol(String symbol, Staking staking, Unstaking unstaking) {
    super(staking, unstaking);
    this.symbol = symbol;
  }

  @Override
  public String getBalance(String address) {
    System.out.println(symbol+ " 잔고: 123");
    return symbol+ " 잔고";
  }

  @Override
  public String sign(String unsignedTx) {
    return unsignedTx + "-signed";
  }

  @Override
  public String broadcast(String signedTx) {
    return signedTx + "-broadcasted";
  }
}
