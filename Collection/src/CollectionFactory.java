
public final class CollectionFactory {
	
	private static CollectionFactory instance = new CollectionFactory();
	
	private CollectionFactory() {}
	
	public static CollectionFactory getCollectionFactoryInstance() {
		return instance;
	}
	
	public <T> ICollection<T> getICollectionInstance(String s) {
		if (s.equals("array"))
			return new Array<T>();
		else if (s.equals("list"))
			return new List<T>();
		else 
			return null;
	}

}
