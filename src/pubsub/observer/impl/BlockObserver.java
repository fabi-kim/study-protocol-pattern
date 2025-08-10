package pubsub.observer.impl;

import protocol.BlockParser;
import protocol.dto.Block;
import protocol.dto.ParsedBlock;
import pubsub.observer.Observer;

public class BlockObserver implements Observer {

  BlockParser blockParser;

  public BlockObserver(BlockParser blockParser) {
    this.blockParser = blockParser;
  }


  @Override
  public boolean parseAndUpdate(Block block) {
    ParsedBlock parsedBlock = blockParser.parse(block);
    System.out.println(
        "[BlockObserver.parseAndUpdate]" + blockParser.getClass() + ".parse 응답 => " + parsedBlock);
    return true;
  }
}
