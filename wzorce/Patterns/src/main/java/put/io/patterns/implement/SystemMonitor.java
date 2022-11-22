package put.io.patterns.implement;

import java.util.ArrayList;
import java.util.List;

public class SystemMonitor {

    private List<SystemStateObserver> observers = new ArrayList<SystemStateObserver>();

    public void addSystemStateObserver(SystemStateObserver observer){
        observers.add(observer);
    }

    public void removeSystemStateObserver(SystemStateObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(SystemStateObserver observer : this.observers){
            observer.update(this);
        }
    }
}
