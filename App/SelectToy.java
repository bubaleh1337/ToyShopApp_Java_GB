public class SelectToy {
    private static SelectToy instance = null;
    private static int toyId = 0;

    public static SelectToy createToyFactory() {
        if (instance == null) {
            instance = new SelectToy();
        }
        return instance;
    }

    public SelectToy() {}

    public Toy createToy(String name) {
        toyId += 1;
        return new Toy(toyId, name);
    }
}
