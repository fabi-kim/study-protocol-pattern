import protocol.dto.EvmBlock;
import protocol.handler.JobManager;
import protocol.handler.dto.JobDto;
import protocol.handler.dto.ProtocolRequestDto;
import protocol.handler.enums.JobType;
import protocol.handler.enums.Status;
import protocol.impl.KaiaProtocol;
import protocol.impl.TrxProtocol;
import protocol.impl.cosmos.AtomProtocol;
import pubsub.observer.impl.BlockObserver;
import pubsub.subject.impl.BlockSubject;
import service.NodeService;
import service.StakingService;

public class Main {


  public static void main(String[] args) throws InterruptedException {

    System.out.println("---template method pattern---");
    StakingService atomService = new StakingService(new AtomProtocol());
    atomService.stakingFlow("testAddress", "1234");
    atomService.unstakingFlow("testAddress", "1000");

    StakingService trxService = new StakingService(new TrxProtocol());
    trxService.unstakingWithdrawFlow("testAddress");

    System.out.println("---block Observer---");
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

    System.out.println("---job manager");
    JobManager jobManager = new JobManager(new TrxProtocol());

    jobManager.setJob(
        new JobDto(1, new ProtocolRequestDto("test-address", "123"), JobType.UNSTAKING,
            Status.READY));
    jobManager.setJob(
        new JobDto(2, new ProtocolRequestDto("test-address", "456"), JobType.UNSTAKING_WITHDRAW,
            Status.READY));

    for (int i = 0; i < 10; i++) {
      jobManager.runJobBatch();

      Thread.sleep(1000);
    }

  }
}