package protocol.template;

import protocol.Protocol;

/**
 * 예제처럼 Template 설정
 */
public abstract class ProtocolTemplate {

  protected Protocol protocol;

  protected ProtocolTemplate(Protocol protocol) {
    this.protocol = protocol;
  }

  public final boolean flow(String address, String amount) {
    if (!isExecutableFlow(address, amount)) {
      return false;
    }
    String unsignedTx = createTransaction(address, amount);
    System.out.println(unsignedTx);

    String signedTx = sign(unsignedTx);
    System.out.println(signedTx);

    String txHash = broadcast(signedTx);
    System.out.println(txHash);

    return true;
  }

  protected boolean isExecutableFlow(String address, String amount) {
    return true;
  }

  protected abstract String createTransaction(String address, String amount);

  protected String sign(String unsignedTx) {
    return this.protocol.sign(unsignedTx);
  }

  protected String broadcast(String unsignedTx) {
    return this.protocol.broadcast(unsignedTx);
  }


}
