import java.text.ParseException;

import SortedList.Node;

public class HospitalQueue<T> implements IHospitalQueue<T>{
	private QNode firstNode;
	private QNode lastNode;
	private int numberOfEntries;
	private class QNode { //check
		private T data;
		private QNode next;

	private QNode(T dataporiton) {
		this(dataporiton, null);
	}
	private QNode(T dataportion, QNode nextnode) {
		data = dataportion;
		next = nextnode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public QNode getNextNode() {
		return next;
	}
	public void setNextNode(QNode nextnode) {
		this.next = nextnode;
	}

	}
	public HospitalQueue() {
		firstNode = null;
		lastNode = null;
	}
	public void enqueue(T newEntry) throws ParseException {
		QNode newNode = new QNode(newEntry);
		QNode nodeBefore = getNodeBefore(newEntry);
		
		if (isEmpty() || (nodeBefore == null)){
			newNode.setNextNode(firstNode);
			firstNode = newNode;	
		}
		else {
			QNode nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		}
		numberOfEntries++;
	}
	public boolean isEmpty() {
		return (firstNode == null) && (lastNode == null);
	}
	public T getFront() {
		if(isEmpty()) {
			return null;
		}
		else {
			return firstNode.getData();
		}
	}
	public T dequeue() {
		T front = getFront();
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		if (firstNode == null) {
			lastNode = null;
		}
		return front; //make priority queue
		
	}

	private QNode getNodeBefore(T anEntry) throws ParseException {
		Patient Entry = (Patient) anEntry;
		QNode currentNode = firstNode;
		QNode nodeBefore = null;
		while ((currentNode != null) && (Entry.compareWithPriority((Patient) currentNode.getData()) > 0)) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		return nodeBefore;
	}
	public int getNumberOfEntries() {
		return numberOfEntries;
	}
	public Patient[] toArray() {
		Patient[] result = new Patient[numberOfEntries];
		int index = 0;
		QNode currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)) {
			result[index] = (Patient) currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		}
		return result;
	}
	public void runQueue() {
		int count = 0;
		while(!isEmpty()) {
			dequeue();
			count++;
			if(count % 5 == 0) {
				System.out.println("*********");
				printQueue();
				System.out.println("*********");
			}
		}
	}
	public void printQueue() {
		Patient result = new Patient();
		int index = 0;
		QNode currentNode = firstNode;
		while((index < numberOfEntries) && (currentNode != null)) {
			result = (Patient) currentNode.getData();
			currentNode = currentNode.getNextNode();
			System.out.println(result);
			index++;
		}
	}
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setData(T data) {
		// TODO Auto-generated method stub
		
	}
}	

