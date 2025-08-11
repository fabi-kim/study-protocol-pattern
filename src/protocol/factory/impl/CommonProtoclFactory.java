package protocol.factory.impl;

import protocol.Protocol;
import protocol.factory.ProtocolFactory;
import protocol.impl.KaiaProtocol;
import protocol.impl.TrxProtocol;
import protocol.impl.cosmos.AtomProtocol;
import protocol.impl.cosmos.SeiProtocol;

public class CommonProtoclFactory extends ProtocolFactory {

  @Override
  protected Protocol createProtocol(String symbol) {
    return switch (symbol.toUpperCase()) {
      case "ATOM" -> new AtomProtocol();
      case "SEI" -> new SeiProtocol();
      case "KAIA" -> new KaiaProtocol();
      case "TRX" -> new TrxProtocol();
      default -> throw new IllegalArgumentException("symbol not supported");
    };
  }
}
