import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lototron {
    private SelectToy tf = SelectToy.createToyFactory();
    private Random random = new Random();
    private boolean rafflStarted = false;
    private int itemsAmt = 0;
    private List<Lot> content = new ArrayList<Lot>();

    public void addLot() {
        if (!rafflStarted) {
            Lot lot = new Lot(tf.createToy(input("Введите название: ")));
            setAmtForLot(lot);
            content.add(lot);
            itemsAmt += lot.getAmt();
            calcProbForLots();
            System.out.print("Лот добавлен!\n");
        } else {
            System.out.print("Розыгрыш начался! Нельзя что либо менять!\n");
        }
    }

    private Lot getLotById(int id) {
        for (Lot lot : content) {
            if (lot.getId() == id) {
                System.out.println(lot);
                return lot;
            }
        }
        System.out.print("id не найден!\n");
        return null;
    }

    private void setAmtForLot(Lot lot) {
        int amt;
        String input;
        while (true) {
            input = input("Введите количество игрушек: ");
            while (!isNumber(input)) {
                input = input("Введите количество игрушек: ");
            }
            amt = Integer.parseInt(input);
            if (isValidAmt(amt)) {
                break;
            }
        }
        lot.setAmt(amt);
    }

    public void changeAmtForLot() {
        if (!rafflStarted) {
            String input;
            input = input("Введите id: ");
            while (!isNumber(input)) {
                input = input("Введите id: ");
            }
            int id = Integer.parseInt(input);
            Lot lot = getLotById(id);
            if (lot != null) {
                int oldAmt = lot.getAmt();
                int newAmt;
                while (true) {
                    input = input("Введите новое количество: ");
                    while (!isNumber(input)) {
                        input = input("Введите новое количество: ");
                    }
                    newAmt = Integer.parseInt(input);
                    if (isValidAmt(newAmt)) {
                        break;
                    }
                }
                lot.setAmt(newAmt);
                itemsAmt = itemsAmt - oldAmt + newAmt;
                calcProbForLots();
                System.out.print("Готово!\n");
            }
        } else {
            System.out.print("Розыгрыш начался! Нельзя что либо менять!\n");
        }
    }

    private boolean isNumber(String str) {
        if (str.matches("^\\d+$")) {
            return true;
        }
        System.out.print("Нужно ввести число!\n");
        return false;
    }

    private boolean isValidAmt(int amt) {
        if (amt < 1) {
            System.out.print("Количество игрушек должно быть больше 0!\n");
            return false;
        }
        return true;
    }

    // метод сам считает вероятности, на основе количества игрушек
    private void calcProbForLots() {
        double prob;
        for (Lot lot : content) {
            prob = (double) lot.getAmt() / (double) itemsAmt;
            lot.setProb(prob);
        }
    }

    // метод "вытаскивает" игрушку из лототрона
    public Lot getPrize() {
        if (rafflStarted) {
            if (itemsAmt > 0) {
                double roll = random.nextDouble();
                double summ = content.get(0).getProb() + roll;
                int i = 1;
                while (summ <= 1) {
                    summ += content.get(i).getProb();
                    i += 1;
                }
                i -= 1;
                Lot lot = content.get(i);
                lot.decrAmt();
                if (lot.getAmt() == 0) {
                    content.remove(i);
                }
                itemsAmt -= 1;
                calcProbForLots();
                System.out.println(lot);
                return lot;
            }
            System.out.print("Лототрон пуст!\n");
            return null;
        }
        System.out.print("Начните розыгрыш, чтобы достать приз!\n");
        return null;
    }

    public void startRaffl() {
        if (!rafflStarted) {
            rafflStarted = true;
            System.out.print("Розыгрыш начался!\n");
        } else {
            System.out.print("Розыгрыш уже идёт!\n");
        }
    }

    private String input(String message) {
        System.out.print(message);
        return System.console().readLine().strip();
    }

    @Override
    public String toString() {
        if (itemsAmt > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("В лототроне ").append(itemsAmt).append(" игрушек!\n");
            for (Lot lot : content) {
                sb.append(lot.toString()).append("\n");
            }
            return sb.toString();
        }
        return "Лототрон пуст!\n";
    }
}
