// Подсчитать число счастливых билетов, у которых сумма трех цифр равна 13.
//Номер билета может быть от 000000 до 999999.
public class LuckyTickets {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i < 1_000; i++) {
            int sum = 0;
            int first = i;

            while (first != 0) {
                sum += first % 10;
                first /= 10;
            }

            if (sum == 13) {
                count++;
            }
        }
        System.out.println(count * count); // 4761
    }
}