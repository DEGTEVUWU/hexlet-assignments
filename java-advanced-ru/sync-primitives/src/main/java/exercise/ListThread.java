package exercise;

import java.util.TreeMap;

// BEGIN
public class ListThread extends Thread {
    SafetyList list;
    public ListThread(SafetyList list) {
        this.list = list;
    }
    @Override
    public void run() {
        for (var i = 0; i < 1000; i++) {
            list.add(i);
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// END
