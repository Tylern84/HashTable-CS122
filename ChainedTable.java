import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ChainedTable<K, V> {
	LinkedList<Entry<K, V>>[] bucketArray;
	int collisions;


	@SuppressWarnings("unchecked")
	/**
	 * Create a ChainedTableSolution instance with the specified
	 * number of buckets.
	 * 
	 * @param buckets the number of buckets to make in this table
	 */
	public ChainedTable(int buckets) {
		bucketArray = (LinkedList<Entry<K, V>>[]) new LinkedList[buckets];
		collisions = 0;
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<Entry<K, V>>();

		}


	}




	/**
	 * _Part 1: Implement this method._
	 *
	 * Puts an entry into the table. If the key already exists,
	 * it's value is updated with the new value and the previous
	 * value is returned.
	 * 
	 * @param key
	 *            the object used as a key to retrieve the value
	 * @param value
	 *            the object stored in association with the key
	 * 
	 * @throws IllegalArgumentException
	 *            if the value parameter is null
	 *
	 * @return the previously stored value or null if the key is new
	 */
	public V put(K key, V value) {
		if(value == null){
			throw new IllegalArgumentException("Value cannot be null");
		}
		
		// TODO: implement this
		return null;
	}

	/**
	 * _Part 2: Implement this method._
	 *
	 * Retrieves the value associated with the specified key. If
	 * it exists, the value stored with the key is returned, if no
	 * value has been associated with the key, null is returned.
	 * 
	 * @param key
	 *            the key object whose value we wish to retrieve
	 * @return the associated value, or null
	 */
	public V get(K key) {
		// TODO: implement this
		return null;
	}

	/**
	 * _Part 3: Implement this method._
	 *
	 * Looks through the entire bucket where the specified key
	 * would be found and counts the number of keys in this bucket
	 * that are not equal to the current key, yet still have the
	 * same hashcode. Be efficient! (i.e., recall that calling .get()
	 * on a linked list is O(n) where n is the size of the list)
	 *
	 *
	 * @param key
	 * @return a count of collisions
	 */
	public int countTrueCollisions(K key) {
		// TODO: implement this
		return 0;
	}


	/**
	 * _Part 4: Implement this method._
	 *
	 * Returns the number of entries (i.e., Entry instances) in
	 * this table
	 * 
	 * @return the number of entries.
	 */
	public int size() {
		// TODO: implement this
		return 0;
	}


	public static class Entry<K, V> {
		K key;
		V value;

		public Entry(K k, V v) {
			key = k;
			value = v;
		}
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("src/bigtext.txt"));

		ChainedTable<String, Integer> map = new ChainedTable<String, Integer>(
				1000);

		String watch = "The!!!;";
		String str;
		Integer value;
		System.out.println("Reading");
		int i = 0;
		long start = System.nanoTime();
		while (s.hasNext()) {
			str = s.next();
			if (str.equals(watch)) System.out.println(watch);
			value = map.get(str);
			// System.out.println("Got "+str);
			if (value == null) {
				map.put(str, 1);

			} else {
				map.put(str, value + 1);

			}
			i++;
			if (i % 5000 == 0)
				System.out.println("Read " + i + " words");

		}
		System.out.println("Hashed!");
		System.out.println(watch + " " + watch.hashCode() + " was seen " + map.get(watch) + " times");
		System.out.println("It took " + (System.nanoTime() - start) / 1.0E9 + " seconds");
	}

}
