package protocol.unstaking.impl;

import java.util.Date;
import protocol.unstaking.Unstaking;
import utils.DateUtil;

public class TrxUnstaking implements Unstaking {

  private final int unlockdurationDay;

  public TrxUnstaking() {
    this.unlockdurationDay = 14;
  }

  @Override
  public String createUnsignedUntakingTransaction() {
    return "0x456";
  }

  @Override
  public boolean isNeededWithdraw() {
    return true;
  }

  @Override
  public String createUnsignedUnstakedWithdrawTransaction() {
    return "0x789";
  }

  @Override
  public String getExpectedUnlockDate(String txHash) {
    return "txHash(" + txHash + ")에 대한 위임해제 완료 시간 : " + DateUtil.addDay(new Date(),
        unlockdurationDay);
  }
}
