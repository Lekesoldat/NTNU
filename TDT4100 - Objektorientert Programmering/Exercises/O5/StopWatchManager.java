package objectstructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StopWatchManager {
  private Map<String, StopWatch> watches = new HashMap<String, StopWatch>();
  
  @Override
  public String toString() {
    return watches
        .entrySet()
        .stream()
        .map(e -> e.getKey() + ": " + e.getValue().toString())
        .collect(Collectors.joining("\n"));
  }
  
  public StopWatch newStopWatch(String name) {
    StopWatch newWatch = new StopWatch();
    watches.put(name, newWatch);
    return newWatch;
  }
  
  public void removeStopWatch(String name) {
    watches.remove(name);
  }
  
  public void tick(int ticks) {
    for (Map.Entry<String, StopWatch> entry : watches.entrySet()) {
      entry.getValue().tick(ticks);
    }
  }
  
  public StopWatch getStopWatch(String name) {
    return watches.get(name);
  }
  
  public Collection<StopWatch> getAllWatches() {
    return watches.values();
  }
  
  public Collection<StopWatch> getStartedWatches() {
    return watches
        .values()
        .stream()
        .filter(StopWatch::isStarted)
        .collect(Collectors.toList());
  }
  
  public Collection<StopWatch> getStoppedWatches() {
    return watches
        .values()
        .stream()
        .filter(StopWatch::isStopped)
        .collect(Collectors.toList());
  }
  
  public static void main(String[] args) {
    StopWatchManager manager = new StopWatchManager();
    manager.newStopWatch("Test1");
    
    System.out.println(manager);
  }
}
