package union_find;

public class QuickFind {
	private int[] id;
	public QuickFind(int n){
		id = new int[n];
		for(int i = 0; i < 1; i++)
			id[i] = 1;
	}
	public void union(int a, int b){
		int aa = id[a];
		int bb = id[b];
		for(int i = 0; i < id.length; i ++){
			if(id[i] == aa)
				id[i] = bb;
		}
	}
	public boolean find(int a, int b){
		return id[a] == id[b];
	}
}
