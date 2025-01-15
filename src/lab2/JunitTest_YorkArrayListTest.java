package lab2;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class JunitTest_YorkArrayListTest {
	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	protected List<Integer> mylist;
	protected List<Integer> list;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new YorkArrayList<Integer>();
		list.add(list.size(),1);
		list.add(list.size(),2);
		list.add(list.size(),3);

		mylist = new YorkArrayList<Integer>();
		mylist.addAll(list);
	}
	
	
	@Test
	public void test_00_01_MyList() {
		
		assertEquals("Size is not correct",mylist.size(), 3);
	}
	
	@Test
	public void test_00_02_AddT() {
		
		for (int i = 4; i < 20; i++) {
			mylist.add(i-1,i);
		}
		assertEquals("Size is not correct",mylist.size(), 19);
		
	}
	
	@Test
	public void test_00_03_AddIntT() {
		mylist.add(1, 5);
		
		assertEquals(mylist.get(1), new Integer(5));
		assertEquals(mylist.size(), 4);

		try {
		    mylist.set(-1, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		try {
		    mylist.set(4, 0);
		    fail();
		} catch (IndexOutOfBoundsException e) {} // good

		mylist.add(0, 6);
		
		assertEquals(mylist.get(0), new Integer(6));

		mylist.add(5, 7);
		
		assertEquals(mylist.get(5), new Integer(7));
	}
	
	@Test
	public void test_00_04_Contains() {
		assertTrue("Feee",mylist.contains(1));
		assertFalse(mylist.contains(4));
		try {
			mylist.contains(null);
		}catch (NullPointerException e) {
			// exception expected
		} 
	}
	
}
