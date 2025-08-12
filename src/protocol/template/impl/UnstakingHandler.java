package protocol.template.impl;

import protocol.template.ProtocolHandler;

public class UnstakingHandler implements ProtocolHandler {

  @Override
  public boolean onReady(String address, String amount) {
    return false;
  }

  @Override
  public boolean onProcess(String address, String amount) {
    return false;
  }

  @Override
  public boolean onSuccess(String tx) {
    return false;
  }

  @Override
  public boolean onFailure(String tx) {
    return false;
  }
}
