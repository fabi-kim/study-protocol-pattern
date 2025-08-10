package protocol.staking.impl;

import protocol.staking.Staking;

public class TrxStaking implements Staking {


  @Override
  public String getStakingBalance(String address) {
    return address + ": TRX 스테이킹 잔고";
  }

  @Override
  public String createUnsignedStakingTransaction() {
    return "0x123";
  }
}
