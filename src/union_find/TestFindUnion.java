package union_find;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestFindUnion {
	private ImprovedQuickUnion iqu;
	private QuickUnion qu;
	private QuickFind qf;

	@Before
	public void setUp() throws Exception {
		iqu = new ImprovedQuickUnion(10);
		qu = new QuickUnion(10);
		qf = new QuickFind(10);
	}

	@Test
	public void testFind() {
		assertFalse(qu.find(1, 2));
		assertFalse(iqu.find(1, 2));
		assertFalse(qf.find(1, 2));
	}
	
	@Test
	public void testUnion(){
		qu.union(1, 2);
		iqu.union(1, 2);
		qf.union(1, 2);
		assertTrue(qu.find(1, 2));
		assertTrue(iqu.find(1, 2));
		assertTrue(qf.find(1, 2));
	}

}
