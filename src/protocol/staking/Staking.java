package protocol.staking;

public interface Staking {

  String getStakingBalance(String address);

  String createUnsignedStakingTransaction(String address, String amount);
}
