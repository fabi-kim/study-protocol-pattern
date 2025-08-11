package protocol.staking.impl.cosmos;

import protocol.staking.Staking;
import protocol.staking.impl.CosmosStaking;

public class SeiStaking extends CosmosStaking implements Staking {

  public SeiStaking() {
    super("SEI");
  }
}
