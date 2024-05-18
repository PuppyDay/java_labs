import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<Integer, Integer>());

    public void cashIn(int accountID, int amount) {
        new Thread(() -> {
            if (!map.containsKey(accountID)) {
                throw new RuntimeException("Данного аккаунта не существует");
            }
            map.put(accountID, map.get(accountID) + amount);
            System.out.println("Сумма пополнилась, остаток: " + map.get(accountID));
        }).start();
    }

    public void cashOut(int accountID, int amount) {
        new Thread(() -> {
            if (!map.containsKey(accountID)) {
                throw new RuntimeException("Данного аккаунта не существует");
            }
            if (Math.abs(map.get(accountID)) < amount) {
                throw new RuntimeException("Сумма списания больше остатка");
            }
            map.put(accountID, map.get(accountID) - amount);
            System.out.println("Сумма списалась, остаток: " + map.get(accountID));
        }).start();
    }

    public void addAccount(int accountID){
        if (map.containsKey(accountID)) {
            throw new RuntimeException("Аккаунт уже существует");
        }
        map.put(accountID, 0);
    }
}
