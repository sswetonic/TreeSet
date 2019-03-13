

public class Main {

    public static void main(String[] args) {
        TreeSet<Integer> testTree = new TreeSet<>(1);
        testTree.insert(6);
        testTree.insert(9);
        testTree.insert(5);
        testTree.delete(5);

        System.out.println(testTree);
    }
}
