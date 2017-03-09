
public interface ICollection<T> {	
	public void addFirst(T element);
	public void addLast(T element);
	public void add(T element, int index);
	
	public T getFirst();
	public T getLast();
	public T get(int index);

	public void removeFirst();
	public void removeLast();
	public void remove(T element);
	public void removeIndex(int index);

	public int getSize();
}
