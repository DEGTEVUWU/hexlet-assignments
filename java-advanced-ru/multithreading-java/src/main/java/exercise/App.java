package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] massive) {
        Map<String, Integer> result = new HashMap();

        MinThread minThread = new MinThread(massive);
        MaxThread maxThread = new MaxThread(massive);
        minThread.start();
        maxThread.start();
        try {
            minThread.join(); //Ожидаем завершения работы потока minThread
            maxThread.join(); //Ожидаем завершения работы потока maxThread
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Прерывание во время выполнения потока", e);
            // В зависимости от вашей задачи, здесь может быть уместно вернуть частичный результат или выбросить исключение
        }

        result.put("min", minThread.getMinValue());
        result.put("max", maxThread.getMaxValue());
        return result;
    }
    // END
}
