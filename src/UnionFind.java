public class UnionFind {

    int[] nodes;

    public UnionFind(int size) {
        nodes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
        }
    }

    public int find(int x) {
        if (x == nodes[x]) {
            return x;
        }
        return nodes[x] = find(nodes[x]);
    }

    public void union(int x, int y) {
        int nodeX = find(x);
        int nodeY = find(y);

        if (nodeX != nodeY) {
            nodes[nodeY] = nodeX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
