package protocol.unstaking.impl.cosmos;

import protocol.unstaking.Unstaking;
import protocol.unstaking.impl.CosmosUnstaking;

public class SeiUnstaking extends CosmosUnstaking implements Unstaking {

  public SeiUnstaking() {
    super("SEI", 21);
  }
}
