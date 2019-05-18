public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> numbersList = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            numbersList.add(i);
        }

        System.out.println(numbersList);
        numbersList.add(1, -99);

        System.out.println(numbersList);
    }
}
