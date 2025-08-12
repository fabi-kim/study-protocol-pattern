package protocol.handler.impl;

import protocol.Protocol;
import protocol.handler.ProtocolHandler;

public class StakingHandler extends ProtocolHandler {

  Protocol protocol;

  StakingHandler(Protocol protocol) {
    this.protocol = protocol;
  }

  @Override
  protected boolean isExecutableFlow(String address, String amount) {
    //if(amount > protocol.getBalance(address)) 이런식이어야함. 테스트를 위해 더미 데이터 추가
    return Integer.parseInt(amount) >= 0;
  }

  @Override
  protected String createTransaction(String address, String amount) {
    return protocol.createUnsignedStakingTransaction(address, amount);
  }

  @Override
  protected String sign(String unsignedTx) {
    return "";
  }

  @Override
  protected String broadcast(String unsignedTx) {
    return "";
  }
}
