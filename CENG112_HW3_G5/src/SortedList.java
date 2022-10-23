import java.text.ParseException;

public class SortedList<T> implements ISortedList<T>{
	private Node firstNode;
	private int numberOfEntries;
	
	public SortedList() {
		firstNode = null;
		numberOfEntries = 0;
	}
	private class Node { //check
		private T data;
		private Node next;

	private Node(T dataporiton) {
		this(dataporiton, null);
	}
	private Node(T dataportion, Node nextnode) {
		data = dataportion;
		next = nextnode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node getNextNode() {
		return next;
	}
	public void setNextNode(Node nextnode) {
		this.next = nextnode;
	}

	}
private Node getNodeAt(int givenPosition) {
	assert (firstNode != null ) && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
	Node currentNode = firstNode;
	
	for (int counter = 1; counter < givenPosition; counter++) {
		currentNode = currentNode.getNextNode();
		assert (currentNode != null);
	}
	return currentNode;

}
public T remove(int givenPosition) {
	T result = null;
	if ((givenPosition >= 1 ) && (givenPosition <= numberOfEntries)){
		assert !isEmpty();
		if(givenPosition == 1) {
			result = (T) firstNode.getData();
			firstNode = firstNode.getNextNode();
		}
		else {
			Node nodeBefore = getNodeAt(givenPosition - 1);
			Node NodeToRemove = nodeBefore.getNextNode();
			result = (T) NodeToRemove.getData();
			Node NodeAfter = NodeToRemove.getNextNode();
			nodeBefore.setNextNode(NodeAfter);
			
		}
		numberOfEntries--;
		return result;
	}
	else {
		throw new IndexOutOfBoundsException("Illegal position to remove operation");
	}
}
public boolean isEmpty() {
	return numberOfEntries == 0;
}
public void add(T newEntry) throws ParseException {
	Node newNode = new Node(newEntry);
	Node nodeBefore = getNodeBefore(newEntry);
	
	if (isEmpty() || (nodeBefore == null)){
		newNode.setNextNode(firstNode);
		firstNode = newNode;	
	}
	else {
		Node nodeAfter = nodeBefore.getNextNode();
		newNode.setNextNode(nodeAfter);
		nodeBefore.setNextNode(newNode);
	}
	numberOfEntries++;
}
private Node getNodeBefore(T anEntry) throws ParseException {
	Patient Entry = (Patient) anEntry;
	Node currentNode = firstNode;
	Node nodeBefore = null;
	while ((currentNode != null) && (Entry.compareTo((Patient) currentNode.getData()) > 0)) {
		nodeBefore = currentNode;
		currentNode = currentNode.getNextNode();
	}
	return nodeBefore;
}
public Patient[] toArray() {
	Patient[] result = new Patient[numberOfEntries];
	int index = 0;
	Node currentNode = firstNode;
	while((index < numberOfEntries) && (currentNode != null)) {
		result[index] = (Patient) currentNode.getData();
		currentNode = currentNode.getNextNode();
		index++;
	}
	return result;
}
public int getNumberOfEntries() {
	return numberOfEntries;
}
}