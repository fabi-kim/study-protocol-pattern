package protocol.staking.impl.cosmos;

import protocol.staking.Staking;
import protocol.staking.impl.CosmosStaking;

public class AtomStaking extends CosmosStaking implements Staking {
  public AtomStaking() {
    super("ATOM");
  }
}
