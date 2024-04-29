package principal;

import java.util.HashMap;
import java.util.Map;
public class Test {

	public static void main(String[] args) {
		
		        // Create a HashMap
		        Map<String, Integer> hashMap = new HashMap<>();
		        
		        // Add some key-value pairs
		        hashMap.put("Apple", 10);
		        hashMap.put("Orange", 5);
		        hashMap.put("Banana", 8);
		        
		        // Print the HashMap using Streams
		        hashMap.entrySet().stream()
		                .forEach(entry -> System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue()));
		    }
}
