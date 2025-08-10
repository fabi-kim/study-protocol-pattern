package protocol;

import protocol.dto.Block;
import protocol.dto.ParsedBlock;

public interface BlockParser {

  ParsedBlock parse(Block block);
}
