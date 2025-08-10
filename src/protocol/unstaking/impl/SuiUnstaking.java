package protocol.unstaking.impl;

import java.util.Date;
import protocol.unstaking.Unstaking;

public class SuiUnstaking implements Unstaking {

  private final int unlockdurationDay;
  private final boolean needWithdraw;

  public SuiUnstaking() {
    this.unlockdurationDay = 0;
    this.needWithdraw = false;
  }

  @Override
  public String createUnsignedUntakingTransaction() {
    return "0x456";
  }

  @Override
  public boolean isNeededWithdraw() {
    return false;
  }

  @Override
  public String createUnsignedUnstakedWithdrawTransaction() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getExpectedUnlockDate(String txHash) {
    return "txHash(" + txHash + ")에 대한 위임해제 완료 시간 : " + new Date().getTime();
  }
}
