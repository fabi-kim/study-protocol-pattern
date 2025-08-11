import protocol.dto.EvmBlock;
import protocol.impl.KaiaProtocol;
import protocol.impl.TrxProtocol;
import protocol.impl.cosmos.AtomProtocol;
import pubsub.observer.impl.BlockObserver;
import pubsub.subject.impl.BlockSubject;
import service.NodeService;
import service.StakingService;

public class Main {


  public static void main(String[] args) {
    StakingService atomService = new StakingService(new AtomProtocol());
    atomService.stakingFlow("testAddress");
    atomService.unstakingFlow("testAddress");
    StakingService trxService = new StakingService(new TrxProtocol());
    trxService.stakingFlow("testAddress");
    trxService.unstakingFlow("testAddress");

    System.out.println("block Observer");

    BlockSubject subject = new BlockSubject();
    subject.registerObserver(new BlockObserver(new KaiaProtocol()));

    subject.getBlock(10, new EvmBlock(
        "0xa917fcc721a5465a484e9be17cda0cc5493933dd3bc70c9adbee192cb419c9d7",
        "0x829bd824b016326a401d083b33d092293333a830",
        "0x7d416c4a24dc3b43898040ea788922d8563d44a5193e6c4a1d9c70990775c879",
        "0xe6e41732385c71d6",
        "0xc5043f"
    ));

    subject.getBlock(11, new EvmBlock(
        "0xa917fcc721a5465a484e9be17cda0cc5493933dd3bc70c9adbee192cb419c9d7",
        "0x829bd824b016326a401d083b33d092293333a830",
        "0x7d416c4a24dc3b43898040ea788922d8563d44a5193e6c4a1d9c70990775c879",
        "0xe6e41732385c71d6",
        "0xc5043f"
    ));

    System.out.println("get Balance");
    NodeService nodeService = new NodeService();
    nodeService.getBalance("KAIA", "testAddress");
    nodeService.getBalance("TRX", "testAddress");

    System.out.println("get comsmos Balance");
    nodeService.getCosmosBalance("ATOM", "testAddress");
    nodeService.getCosmosBalance("SEI", "testAddress");
  }
}