package protocol.impl.cosmos;

import protocol.impl.CosmosProtocol;
import protocol.staking.impl.cosmos.AtomStaking;
import protocol.unstaking.impl.cosmos.AtomUnstaking;

public class AtomProtocol extends CosmosProtocol {

  public AtomProtocol() {
    super("ATOM", new AtomStaking(), new AtomUnstaking());
  }
}
