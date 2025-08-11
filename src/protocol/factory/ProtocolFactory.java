package protocol.factory;

import protocol.Protocol;

public abstract class ProtocolFactory {

  public Protocol getProtocol(String symbol) {
    return createProtocol(symbol);
  }

  protected abstract Protocol createProtocol(String symbol);
}
