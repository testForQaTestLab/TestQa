package company;

public final class RandomNumber {
    static int number;
    private static RandomNumber instance = null;

    RandomNumber() {
        number = 0;
    }

    public static synchronized RandomNumber getInstance(int numberMin, int numberMax) {
        if (instance == null)
            instance = new RandomNumber();
        number = numberMin + (int) (Math.random() * ((numberMax - numberMin) + 1));
        return instance;
    }
}