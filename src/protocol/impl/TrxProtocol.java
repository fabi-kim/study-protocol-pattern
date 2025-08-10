package protocol.impl;

import protocol.Protocol;
import protocol.staking.impl.TrxStaking;
import protocol.unstaking.impl.TrxUnstaking;

public class TrxProtocol extends Protocol {

  public TrxProtocol() {
    super(new TrxStaking(), new TrxUnstaking());
  }

  @Override
  public String getBalance(String address) {
    System.out.println("trx 잔고: 123");
    return "trx 잔고";
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
