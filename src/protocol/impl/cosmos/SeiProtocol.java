package protocol.impl.cosmos;

import protocol.impl.CosmosProtocol;
import protocol.staking.impl.cosmos.SeiStaking;
import protocol.unstaking.impl.cosmos.SeiUnstaking;

public class SeiProtocol extends CosmosProtocol {

  public SeiProtocol() {
    super("SEI", new SeiStaking(), new SeiUnstaking());
  }
}
