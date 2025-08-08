package service;

import protocol.Protocol;

public class ProtocolService {

  private final Protocol protocol;

  public ProtocolService(Protocol protocol) {
    this.protocol = protocol;
  }

  public boolean stakingFlow(String address) {

    if (protocol.getBalance(address) == null) {
      return false;
    }
    String unsignedTx = protocol.createUnsignedStakingTransaction(address);
    System.out.println(unsignedTx);

    String signedTx = protocol.sign(unsignedTx);
    System.out.println(signedTx);

    String txHash =  protocol.broadcast(signedTx);
    System.out.println(txHash);
    return true;
  }

  public boolean unstakingFlow(String address) {

    if (protocol.getStakingBalance(address) == null) {
      return false;
    }
    String unsignedTx = protocol.createUnsignedStakingTransaction(address);
    System.out.println(unsignedTx);

    String signedTx = protocol.sign(unsignedTx);
    System.out.println(signedTx);

    String txHash =  protocol.broadcast(signedTx);
    System.out.println(txHash);

    if(!protocol.isNeededWithdraw()) return true;

    String unsignedWithdrawTx = protocol.createUnsignedUnstakedWithdrawTransaction(address);
    System.out.println(unsignedWithdrawTx);

    String signedWithdrawTx = protocol.sign(unsignedWithdrawTx);
    System.out.println(signedWithdrawTx);

    String withdrawTxHash =  protocol.broadcast(signedWithdrawTx);
    System.out.println(withdrawTxHash);

    return true;
  }
}
