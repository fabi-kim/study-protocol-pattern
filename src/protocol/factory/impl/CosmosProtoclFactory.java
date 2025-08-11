package protocol.factory.impl;

import protocol.Protocol;
import protocol.factory.ProtocolFactory;
import protocol.impl.cosmos.AtomProtocol;
import protocol.impl.cosmos.SeiProtocol;

public class CosmosProtoclFactory extends ProtocolFactory {

  @Override
  protected Protocol createProtocol(String symbol) {
    return switch (symbol.toUpperCase()) {
      case "ATOM" -> new AtomProtocol();
      case "SEI" -> new SeiProtocol();
      default -> throw new IllegalArgumentException("symbol not supported");
    };
  }
}
