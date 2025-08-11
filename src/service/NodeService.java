package service;

import protocol.Protocol;
import protocol.factory.impl.CommonProtoclFactory;
import protocol.factory.impl.CosmosProtoclFactory;

public class NodeService {

  public String getBalance(String symbol, String address) {
    Protocol protocol = new CommonProtoclFactory().getProtocol(symbol);
    return protocol.getBalance(address);
  }

  public String getCosmosBalance(String symbol, String address) {
    Protocol protocol = new CosmosProtoclFactory().getProtocol(symbol);
    return protocol.getBalance(address);
  }
}
