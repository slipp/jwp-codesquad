package pair;

import java.util.List;

public class Program {
	public static void main(String[] args) {
		Member member = new Member();
		Random random = new Random();
		Print print = new Print();
		
		List<String> list1 = member.group1();
		List<String> list2 = member.group2();
		List<String> list3 = member.group3();
		
		List<String> line1 = random.randomList(list1);
		List<String> line2 = random.randomList(list2);
		List<String> line3 = random.randomList(list3);
		
		print.show(line1, line2, line3);
	}
}
