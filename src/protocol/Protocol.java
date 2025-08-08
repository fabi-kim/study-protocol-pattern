package protocol;

import protocol.staking.Staking;
import protocol.unstaking.Unstaking;
import signer.Signer;

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
  public String createUnsignedStakingTransaction(String address){
    return staking.createUnsignedStakingTransaction();
  }

  public String createUnsignedUntakingTransaction(){
    return unstaking.createUnsignedUntakingTransaction();
  }

  public boolean isNeededWithdraw(){
    return unstaking.isNeededWithdraw();
  }

  public String createUnsignedUnstakedWithdrawTransaction(String address){
    return unstaking.createUnsignedUnstakedWithdrawTransaction();
  }
}
