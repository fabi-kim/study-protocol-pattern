package protocol.unstaking.impl;

import java.util.Date;
import protocol.unstaking.Unstaking;
import utils.DateUtil;

public class CosmosUnstaking implements Unstaking {

  private final String symbol;
  private final int unlockdurationDay;

  public CosmosUnstaking(String symbol, int unlockdurationDay) {
    this.symbol = symbol;
    this.unlockdurationDay = unlockdurationDay;
  }

  @Override
  public String createUnsignedUnstakingTransaction(String address, String amount) {
    return "address : " + address + ", amount: " + amount + "-0x456" + symbol;
  }

  @Override
  public boolean isNeededWithdraw() {
    return false;
  }

  @Override
  public String createUnsignedUnstakedWithdrawTransaction(String address) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getExpectedUnlockDate(String txHash) {
    return symbol + " txHash(" + txHash + ")에 대한 위임해제 완료 시간 : " + DateUtil.addDay(new Date(),
        unlockdurationDay);
  }
}
