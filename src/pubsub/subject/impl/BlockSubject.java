package pubsub.subject.impl;

import java.util.ArrayList;
import java.util.List;
import protocol.dto.Block;
import pubsub.observer.Observer;
import pubsub.subject.Subject;

public class BlockSubject implements Subject {
  private Observer observer;
  private int lastBlock;

  private Block block;

  public BlockSubject(){
    lastBlock = 0;
  }

  @Override
  public void registerObserver(Observer o) {
    observer = o;
  }

  @Override
  public void removeObserver(Observer o) {

  }

  @Override
  public boolean notifyObservers() {
    return observer.parseAndUpdate(this.block);
  }

   public void getBlock(int currentBlock, Block block){
    this.block = block;
    //block조회
    if(lastBlock <currentBlock){
      System.out.println("새로운 Block " + currentBlock + " 조회됨");

      if(notifyObservers()){
        lastBlock = currentBlock;
      }
    }
  }
}
