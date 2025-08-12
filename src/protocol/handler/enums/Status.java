package protocol.handler.enums;

public enum Status {
  READY("READY"),
  PROCESSING("PROCESSING"),
  PROCESSED("PROCESSED"),
  FINISHED("FINISHED");

  private final String label;

  Status(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }
}
