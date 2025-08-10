package pubsub.subject;

import pubsub.observer.Observer;

public interface Subject {
  void registerObserver(Observer o);
  void removeObserver(Observer o);
  boolean notifyObservers();
}
