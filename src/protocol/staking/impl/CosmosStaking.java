package protocol.staking.impl;

import protocol.staking.Staking;

public class CosmosStaking implements Staking {

  private final String symbol;

  public CosmosStaking(String symbol) {
    this.symbol = symbol;
  }

  @Override
  public String getStakingBalance(String address) {
    return address+":"+symbol+"스테이킹 잔고";
  }

  @Override
  public String createUnsignedStakingTransaction() {
    return "0x123";
  }
}
