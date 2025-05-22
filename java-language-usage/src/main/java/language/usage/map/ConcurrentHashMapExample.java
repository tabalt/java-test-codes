package language.usage.map;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");

		System.out.println("Before removal: " + map);

		// 使用 Iterator 遍历并删除符合条件的元素
		Iterator<Integer> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			if ("Two".equals(map.get(key))) {
				iterator.remove(); // 安全地删除元素
			}
		}

		System.out.println("After removal: " + map);
	}
}
