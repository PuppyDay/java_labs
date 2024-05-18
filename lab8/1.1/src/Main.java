// Реализовать многопоточное приложение “Банк”. Имеется банковский счет.
// Сделать синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой.
// При каждой операции (пополнения или снятие) вывести текущий баланс счета.
// В том случае, если денежных средств недостаточно – вывести сообщение.

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        int[] accountIDs = {1, 2, 3, 4};
        bank.addAccount(accountIDs[0]);
        bank.addAccount(accountIDs[1]);
        bank.addAccount(accountIDs[2]);
        bank.addAccount(accountIDs[3]);

        int rnd;
        for (int i = 0; i < 10; i++) {
            try {
                rnd = new Random().nextInt(accountIDs.length - 1);
                bank.cashIn(accountIDs[rnd], new Random().nextInt(1000));
                rnd = new Random().nextInt(accountIDs.length - 1);
                bank.cashOut(accountIDs[rnd], new Random().nextInt(1000));
            } catch (RuntimeException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
