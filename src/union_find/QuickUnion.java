package union_find;

public class QuickUnion implements UnionFind{
	private int[] id;
	public QuickUnion(int n){
		id = new int[n];
		for(int i = 0; i < n; i++)
			id[i] = i;
	}
	public int root(int n){
		while(id[n] != n)
			n = id[n];
		return n;
	}
	public void union(int a, int b){
		int rootA = root(a);
		int rootB = root(b);
		if(rootA != rootB)
			id[rootA] = rootB;
	}
	public boolean find(int a, int b){
		return root(a) == root(b);
	}
}
