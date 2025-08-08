import protocol.impl.TrxProtocol;
import protocol.impl.cosmos.AtomProtocol;
import service.ProtocolService;

public class Main {


  public static void main(String[] args) {
    ProtocolService atomService = new ProtocolService(new AtomProtocol());
    atomService.stakingFlow("testAddress");
    atomService.unstakingFlow("testAddress");
    ProtocolService trxService = new ProtocolService(new TrxProtocol());
    trxService.stakingFlow("testAddress");
    trxService.unstakingFlow("testAddress");

  }
}