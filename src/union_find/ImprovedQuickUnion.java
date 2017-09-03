package union_find;

public class ImprovedQuickUnion implements UnionFind{
	private int[] id;
	private int[] size;
	public ImprovedQuickUnion(int n){
		id = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++){
			id[i] = i;
			size[i] = 1;
		}
			
	}
	public int root(int n){
		while(id[n] != n)
			n = id[n];
		return n;
	}
	public void union(int a, int b){
		int rootA = root(a);
		int rootB = root(b);
		if(rootA != rootB){
			if(size[rootA] <= size[rootB]){
				id[rootA] = rootB;
				size[rootB] += size[rootA];
			}
			else{
				id[rootB] = rootA;
				size[rootA] += size[rootB];
			}
		}
	}
	public boolean find(int a, int b){
		return root(a) == root(b);
	}
}
