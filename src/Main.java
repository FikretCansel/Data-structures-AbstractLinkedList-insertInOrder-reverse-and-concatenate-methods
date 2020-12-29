public class Main{
    public static void main(String[] args) {
        Odev1LinkedList<Integer> ll1 = new Odev1LinkedList<>();
        ll1.insertInOrder(8);
        ll1.insertInOrder(5);
        ll1.insertInOrder(4);
        ll1.insertInOrder(3);
        ll1.insertInOrder(5);
        ll1.insertInOrder(7);
        ll1.print();
        ll1.reverse();
        ll1.print();
    }
}
