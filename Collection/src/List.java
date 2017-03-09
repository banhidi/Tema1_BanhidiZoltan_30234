
public class List<T> implements ICollection<T> {	
	private ListItem<T> first, last;
	private int size;
	
	private class ListItem<T> {
		public T data;
		public ListItem<T> next;
		
		public ListItem(T data, ListItem<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public List() {
		first = last = null;
		size = 0;
	}

	@Override
	public void addFirst(T element) {
		if (size == 0) {
			first = last = new ListItem<>(element, null);
		} else {
			first = new ListItem<>(element, first);
		}
		size++;
	}

	@Override
	public void addLast(T element) {
		if (size == 0)
			first = last = new ListItem<>(element, null);
		else {
			last.next = new ListItem<>(element, null);
			last = last.next;
		}
		size++;
	}

	@Override
	public void add(T element, int index) {
		if (index == 0)
			addFirst(element);
		else if (index == size)
			addLast(element);
		else if (index > 0 && index < size) {
			ListItem<T> t = first;
			for(int i = 0; i < index - 1; i++, t = t.next);
			t.next = new ListItem<>(element, t.next);
			size++;
		}
	}

	@Override
	public T getFirst() {
		return first == null ? null : first.data;
	}

	@Override
	public T getLast() {
		return last == null ? null : last.data;
	}

	@Override
	public T get(int index) {
		if (index >= 0 && index < size) {
			ListItem<T> t = first;
			for(int i = 0; i < index; i++, t = t.next);
			return t.data;
		} else
			return null;
	}

	@Override
	public void removeFirst() {
		if (size == 1) {
			first = last = null;
			size--;
		} else if (size > 1) { 
			first = first.next;
			size--;
		}
	}

	@Override
	public void removeLast() {
		if (size == 1) {
			first = last = null;
			size--;
		} else if (size > 1) {
			ListItem<T> t;
			for(t = first; t.next != last; t = t.next);
			t.next = null;
			last = t;
			size--;
		}
	}

	@Override
	public void remove(T element) {
		if (size > 0) {
			if (first.data.equals(element))
				removeFirst();
			else {
				
				ListItem<T> t, prevt;
				for(prevt = first, t = first.next; t != null; t = t.next, prevt = prevt.next) {
					if (t.data.equals(element)) {
						if (t == last)
							last = prevt;
						prevt.next = t.next;
						size--;
					}
				}
				
			}
		}
	}

	@Override
	public void removeIndex(int index) {
		if (index >= 0 && index < size) {
			if (index == 0)
				removeFirst();
			else if (index == size - 1)
				removeLast();
			else {
				ListItem<T> t, prevt;
				int i;
				for(i = 1, prevt = first, t = first.next; i < index; 
					i++, t = t.next, prevt = prevt.next);
				prevt.next = t.next;
				size--;
			}
		}
	}

	@Override
	public int getSize() {
		return size;
	}
	
	public String toString() {
		String s = "size=" + size;
		int i = 0;
		for(ListItem<T> t = first; t != null; t = t.next)
			s += " [" + i++ + "]=" + t.data.toString();
		return s;
	}

}
