package protocol.unstaking;

public interface Unstaking {

  String createUnsignedUntakingTransaction();

  boolean isNeededWithdraw();

  String createUnsignedUnstakedWithdrawTransaction();

  String getExpectedUnlockDate(String txHash);
}
