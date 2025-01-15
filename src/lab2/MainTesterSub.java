package lab2;



public class MainTesterSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String[] permList1 = {"AAA", "BBB", "PPP", "JJJ", "MMM"};
		    String[] permList2 = {"TTT", "BBB", "MMM", "MMM", "DDD"};

		    List<String> list1 = new YorkArrayList<>(permList1);
		    List<String> list2 = new YorkArrayList<>(permList2);
		    System.out.println("List1 values = " + list1);
		    System.out.println("List2 values = " +list2);
		    
		    list1.addAll(list2);
		    System.out.println("===== After list1.addAll(list2);===== ");
		    System.out.println("List1 values = " + list1);
		    System.out.println("List2 values = " +list2);

		    list1 = new YorkArrayList<>(permList1);
		    System.out.println("===== Reset List1===== ");
		    System.out.println("List1 values = " + list1);
		    System.out.println("List2 values = " +list2);
		    list1.removeAll(list2);
		    System.out.println("===== list1.removeAll(list2);===== ");
		    System.out.println("List1 values = " + list1);
		    System.out.println("List2 values = " +list2);

		    list1 = new YorkArrayList<>(permList1);
		    System.out.println("===== Reset List1===== ");
		    System.out.println("List1 values = " + list1);
		    System.out.println("List2 values = " +list2);
		    list1.retainAll(list2);
		    System.out.println("===== list1.retainAll(list2);===== ");
		    System.out.println("List1 values = " + list1);
		    System.out.println("List2 values = " +list2);
	}

}
