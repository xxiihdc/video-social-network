package insertdata;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("A", "b");
		map.remove("C");
		
		System.out.println(map.get("d"));
		System.out.println("done");
	}
}
