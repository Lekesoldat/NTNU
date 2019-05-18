package objectstructures;

public class StopWatch {
  @Override
  public String toString() {
    return new StringBuilder()
        .append(getTime())
        .toString();
  }
  
  private int ticks = 0;

  private int startTime = -1;
  private int endTime = -1;
  private int lapStart = -1;
  private int lapTime = -1;

  public int getTicks() {
    return this.ticks;
  }

  public void tick(int ms) {
    this.ticks += ms;
  }

  public void start() {
    // Start time
    this.startTime = ticks;

    // Reset lap time
    lap();
  }

  public void lap() {
    // If lap time was running
    if (startTime >= 0) {
      lapTime = ticks - lapStart;
    }
    lapStart = ticks;
  }

  public void stop() {
    this.endTime = ticks;
    lap();
  }

  public boolean isStarted() {
    return this.startTime >= 0;
  }

  public boolean isStopped() {
    return this.endTime >= 0;
  }

  public int getTime() {
    if (isStopped()) {
      return this.endTime - this.startTime;
    } else if (isStarted()) {
      return this.ticks - this.startTime;
    } else {
      return -1;
    }
  }

  public int getLapTime() {
    if (lapStart >= 0) {
      return this.ticks - this.lapStart;
    } else {
      return -1;
    }
  }

  public int getLastLapTime() {
    return this.lapTime;
  }
}