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
  public String createUnsignedUnstakingTransaction(String address, String amount) {
    return "address : " + address + ", amount: " + amount + "-0x456" + "sui";
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
    return "txHash(" + txHash + ")에 대한 위임해제 완료 시간 : " + new Date().getTime();
  }
}
