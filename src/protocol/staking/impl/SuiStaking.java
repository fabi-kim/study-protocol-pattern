package protocol.staking.impl;

import protocol.staking.Staking;

public class SuiStaking implements Staking {

  @Override
  public String getStakingBalance(String address) {
    return address + ": SUI 스테이킹 잔고";
  }

  @Override
  public String createUnsignedStakingTransaction(String address, String amount) {
    return "address : " + address + ", amount: " + amount + "-0x456" + "sui";
  }
}
