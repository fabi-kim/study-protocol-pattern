package pubsub.observer;

import protocol.dto.Block;

public interface Observer {
  boolean parseAndUpdate(Block block);
}
