package protocol.unstaking;

public interface Unstaking {

  String createUnsignedUnstakingTransaction(String address, String amount);

  boolean isNeededWithdraw();

  String createUnsignedUnstakedWithdrawTransaction(String address);

  String getExpectedUnlockDate(String txHash);
}
