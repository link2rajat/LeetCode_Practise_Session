public class Main {

    public static void main(String[] args) {
        UnionFind obj = new UnionFind(12);
        obj.union(1, 2);
        obj.union(2, 3);
        obj.union(3, 4);
        obj.union(5, 6);
        obj.union(6, 7);
        obj.union(7, 8);
        obj.union(8, 9);
        obj.union(10, 11);

        System.out.println(obj.connected(1, 4));
        System.out.println(obj.connected(2, 5));
        System.out.println(obj.connected(8, 11));


    }
}
