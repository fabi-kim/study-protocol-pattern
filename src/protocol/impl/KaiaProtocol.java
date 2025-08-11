package protocol.impl;

import protocol.BlockParser;
import protocol.Protocol;
import protocol.dto.Block;
import protocol.dto.EvmBlock;
import protocol.dto.ParsedBlock;

public class KaiaProtocol extends Protocol implements BlockParser {

  public KaiaProtocol() {
    super(null, null);
  }

  @Override
  public String getBalance(String address) {
    System.out.println("kaia 잔고: 123");
    return "kaia 잔고";
  }

  @Override
  public String sign(String unsignedTx) {
    return unsignedTx + "-signed";
  }

  @Override
  public String broadcast(String signedTx) {
    return signedTx + "-broadcasted";
  }


  @Override
  public ParsedBlock parse(Block block) {
    EvmBlock b = (EvmBlock) block;
    System.out.println("[KaiaProtocol.parse] get block=> " + b.toString());
    ParsedBlock parsedBlock = new ParsedBlock(b.hash(), b.number());
    System.out.println("[KaiaProtocol.parse] parsing success=> " + parsedBlock);
    return parsedBlock;
  }
}
