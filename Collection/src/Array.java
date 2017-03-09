
public class Array<T> implements ICollection<T> {
	private T[] elements;
	private int size;
	
	public Array() {
		elements = null;
		size = 0;
	}
	
	public void addFirst(T element) {
		if (size == 0) {
			elements = (T[]) new Object[1];
			elements[size++] = element;
		} else {
			T[] auxElements = elements;
			elements = (T[]) new Object[++size];
			System.arraycopy(auxElements, 0, elements, 1, size - 1);
			elements[0] = element;
		}
	}

	public void addLast(T element) {
		if (size == 0) {
			elements = (T[]) new Object[1];
			elements[0] = element;
			size = 1;
		} else {
			T[] auxElements = elements;
			elements = (T[]) new Object[++size];
			System.arraycopy(auxElements, 0, elements, 0, size - 1);
			elements[size - 1] = element;
		}
	}

	@Override
	public void add(T element, int index) {
		if (size == 0) {
			addFirst(element);
		} else if (index >= 0 && index <= size) {
			T[] auxElements = elements;
			elements = (T[]) new Object[++size];
			System.arraycopy(auxElements, 0, elements, 0, index);
			elements[index] = element;
			System.arraycopy(auxElements, index, elements, index + 1, size - index - 1);
		}
	}	

	@Override
	public T getFirst() {
		if (size > 0)
			return elements[0];
		else
			return null;
	}

	@Override
	public T getLast() {
		if (size > 0)
			return elements[size - 1];
		else
			return null;
	}

	@Override
	public T get(int index) {
		if (size > 0) {
			if (index >= 0 && index < size)
				return elements[index];
			else return null;
		} else
			return null;
	}

	@Override
	public void removeFirst() {
		if (size > 1) {
			T[] auxElements = elements;
			elements = (T[]) new Object[--size];
			System.arraycopy(auxElements, 1, elements, 0, size);
		} else {
			elements = null;
			size = 0;
		}
	}

	@Override
	public void removeLast() {
		if (size > 1) {
			T[] auxElements = elements;
			elements = (T[]) new Object[--size];
			System.arraycopy(auxElements, 0, elements, 0, size);
		} else {
			elements = null;
			size = 0;
		}
	}

	@Override
	public void remove(T element) {
		for(int i = 0; i < size; i++)
			if (element.equals(elements[i])) {
				if (size > 1) {
					T[] auxElements = elements;
					elements = (T[]) new Object[--size];
					System.arraycopy(auxElements, 0, elements, 0, i);
					System.arraycopy(auxElements, i + 1, elements, i, size - i);
				} else {
					size = 0;
					elements = null;
				}
			}
	}		

	@Override
	public void removeIndex(int index) {
		if (size > 1) {		
			if (index >= 0 && index < size) {
				T[] auxElements = elements;
				elements = (T[]) new Object[--size];
				System.arraycopy(auxElements, 0, elements, 0, index);
				System.arraycopy(auxElements, index + 1, elements, index, size - index);
			}
		} else if (index == 0) {
			elements = null;
			size = 0;
		}
	}

	@Override
	public int getSize() {
		return size;		
	}
	
	public String toString() {
		String s = "size=" + size;
		for(int i = 0; i < size; i++) 
			s += " [" + i + "]=" + elements[i].toString();
		return s;
	}
	
}
