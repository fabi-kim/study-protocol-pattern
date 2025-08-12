package protocol.handler.enums;

public enum JobType {
  STAKING("STAKING"),
  UNSTAKING("UNSTAKING"),
  UNSTAKING_WITHDRAW("UNSTAKING_WITHDRAW");

  private final String label;

  JobType(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }
}
