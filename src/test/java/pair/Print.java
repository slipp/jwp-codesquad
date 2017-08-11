package pair;

import java.util.List;

public class Print {
	public void show(List<String> list1, List<String> list2, List<String> list3) {
		System.out.println("-------------------포비-----------------");
		System.out.println(list1.get(0) +"♡"+ list1.get(1) + " / " + list2.get(0) +"♡"+ list2.get(1) + " / " + list3.get(0) +"♡"+ list3.get(1));
		System.out.println(list1.get(2) +"♡"+ list1.get(3) + " / " + list2.get(2) +"♡"+ list2.get(3) + " / " + list3.get(2) +"♡"+ list3.get(3));
		System.out.println(list1.get(4) +"♡"+ list1.get(5) + " /                / " +list3.get(4) +"♡"+ list3.get(5) );
		System.out.println("                                  " + list3.get(6) +"♡"+ list3.get(7));
	}
}