import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final String file_name = "Raffl_result";
    private static final Queue<Lot> prizes = new LinkedList<Lot>();
    private static final Lototron lototron = new Lototron();

    public static void main(String[] args) {
        String menu = """
                Комманды:
                0 - показать команды
                1 - добавить новый лот в лототрон
                2 - изменить количество игрушек в лоте
                3 - показать что в лототроне
                4 - начать розыгрыш!
                5 - достать игрушку из лототрона и поместить в выдачу
                6 - записать игрушку в файл из выдачи
                7 - завершить программу!
                """;

        System.out.print("Розыгрыш игрушек!\n");
        System.out.print(menu);
        boolean run = true;
        Lot lot;
        String command;
        while (run) {
            command = input("Введите команду: ");
            switch (command) {
                case "0" -> System.out.print(menu);
                case "1" -> lototron.addLot();
                case "2" -> lototron.changeAmtForLot();
                case "3" -> System.out.print(lototron);
                case "4" -> lototron.startRaffl();
                case "5" -> {
                    lot = lototron.getPrize();
                    if (lot != null) {
                        prizes.add(lot);
                    }
                }
                case "6" -> writePrize();
                case "7" -> run = false;
                default -> System.out.print("Нет такой команды! Введите 0 для просмотра всех команд!\n");
            }
        }
    }

    public static void writePrize() {
        if (prizes.size() > 0) {
            Lot lot = prizes.poll();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_name, true))) {
                writer.write(lot.getItem().toString() + "\n");
                System.out.print("Игрушка успешно записана в файл\n");
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла: " + e.getMessage());
            }
        } else {
            System.out.print("В выдаче нет игрушек!\n");
        }
    }

    public static String input(String message) {
        System.out.print(message);
        return System.console().readLine().strip();
    }
}
