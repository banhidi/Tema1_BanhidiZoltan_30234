
public class Demo {
	
	public static void main(String[] args) {
		CollectionFactory cf = CollectionFactory.getCollectionFactoryInstance();
		ICollection<Integer> c = cf.<Integer>getICollectionInstance("array");
		for(int i = 0; i < 15; i++)
			c.addFirst(i);
		System.out.println(c);
	}

}
