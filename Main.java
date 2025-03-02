import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер: " + "\n 1. Добавить новый доход" + "\n 2. Добавить новый расход" + "\n 3. Выбрать систему налогооблажения");
            String input = scan.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scan.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String minusStr = scan.nextLine();
                    int minus = Integer.parseInt(minusStr);
                    spendings += minus;
                    break;
                case 3:
                    if (taxEarnings(earnings) < taxEarningsMinusSpendings(earnings, spendings)) {
                        System.out.println("Мы советуем Вам УСН доходы" + "\n Ваш налог составит: " + taxEarnings(earnings) + "\n Налог на другой системе: " + taxEarningsMinusSpendings(earnings, spendings) + "\nЭкономия: " + (taxEarningsMinusSpendings(earnings,spendings) - taxEarnings(earnings)));
                    } else if (taxEarningsMinusSpendings(earnings, spendings) < taxEarnings(earnings)) {
                        System.out.println("Мы советуем Вам УСН доходы минус расходы" + "\n Ваш налог составит:" + taxEarningsMinusSpendings(earnings, spendings) + "\n Налог на другой системе: " + taxEarnings(earnings) + "\nЭкономия: " + (taxEarnings(earnings) - taxEarningsMinusSpendings(earnings,spendings)));

                    } else if (taxEarnings(earnings) == taxEarningsMinusSpendings(earnings,spendings)){
                        System.out.println("Можете выбрать любую систему налогооблажения, так как налог на обоих системах одинаковый. " + "\nНалог на системе УСН доходы: " + taxEarnings(earnings) + "\nНалог на системе УСН доходы минус расходы: " + taxEarningsMinusSpendings(earnings,spendings));
                    } break;
            }

        }
        System.out.println("Программа завершена.");
    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }
}