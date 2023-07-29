public class Lot {
    private int id;
    private Lotable item;
    private int amt;
    private double prob;

    public Lot(Lotable item) {
        this.item = item;
        this.id = item.getId();
    }

    public int getId() {
        return id;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public void decrAmt() {
        amt -= 1;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public Lotable getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString() + " " + amt + " шт" + " " + prob;
    }
}
