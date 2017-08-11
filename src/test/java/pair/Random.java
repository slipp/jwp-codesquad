package pair;

import java.util.Collections;
import java.util.List;

public class Random {
	public List<String> randomList(List<String> list) {
		Collections.shuffle(list);
		return list;
	}
}
