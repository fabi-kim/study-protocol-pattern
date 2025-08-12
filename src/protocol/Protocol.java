package protocol;

import protocol.staking.Staking;
import protocol.unstaking.Unstaking;

public abstract class Protocol {

  protected Staking staking;
  protected Unstaking unstaking;

  protected Protocol(Staking staking, Unstaking unstaking) {
    this.staking = staking;
    this.unstaking = unstaking;
  }

  public abstract String getBalance(String address);

  public abstract String sign(String signedTx);

  public abstract String broadcast(String signedTx);

  public String getStakingBalance(String address) {
    return staking.getStakingBalance(address);
  }

  public String createUnsignedStakingTransaction(String address, String amount) {
    return staking.createUnsignedStakingTransaction(address, amount);
  }

  public String createUnsignedUntakingTransaction(String address, String amount) {
    return unstaking.createUnsignedUnstakingTransaction(address, amount);
  }

  public boolean isNeededWithdraw() {
    return unstaking.isNeededWithdraw();
  }

  public String createUnsignedUnstakedWithdrawTransaction(String address) {
    return unstaking.createUnsignedUnstakedWithdrawTransaction(address);
  }
}
