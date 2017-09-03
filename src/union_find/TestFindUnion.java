package union_find;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestFindUnion {
	private UnionFind[] uf;
	private int n = 1000;
	private String names[] = {"Quick Find", "Quick Union", "Improved Quick Union"};
	@Before
	public void setUp() throws Exception {
		uf = new UnionFind[3];
		uf[0] = new QuickFind(n);
		uf[1] = new QuickUnion(n);
		uf[2] = new ImprovedQuickUnion(n);
	}

	@Test
	public void testFind() {
		
		assertFalse(uf[0].find(1, 2));
		assertFalse(uf[1].find(1, 2));
		assertFalse(uf[2].find(1, 2));
	}
	
	@Test
	public void testUnion(){
		for(int i = 0; i < 3; i++){
			UnionFind current = uf[i];
			current.union(1, 2);
			assertTrue(current.find(1, 2));
		}
	}
	
	@Test
	public void testPerformance(){
		System.out.printf("N = %d\n", n);
		for(int i = 0; i < 3; i++){
			UnionFind current = uf[i];
			long begin = System.currentTimeMillis();
			Random random = new Random();
			for(int j = 0; j < n; j++){
				int a = random.nextInt(n);
				int b = random.nextInt(n);
				current.union(a, b);
			}
			long end1 = System.currentTimeMillis();
			for(int j = 0; j < n; j++){
				int a = random.nextInt(n);
				int b = random.nextInt(n);
				current.find(a, b);
			}
			long end2 = System.currentTimeMillis();
			System.out.printf("%s\t\nUnion time: %fs\n Find time: %fs\n\n", names[i], (end1 - begin)/1000.0, (end2 - end1)/1000.0);
		}
	}

}
