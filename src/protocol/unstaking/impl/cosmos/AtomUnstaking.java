package protocol.unstaking.impl.cosmos;

import protocol.unstaking.Unstaking;
import protocol.unstaking.impl.CosmosUnstaking;

public class AtomUnstaking extends CosmosUnstaking implements Unstaking {

  public AtomUnstaking() {
    super("ATOM", 21);
  }
}
