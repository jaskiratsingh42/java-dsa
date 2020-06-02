package dsa;

public class MyLinkedList<E> {
//	Implementation with only Head Reference & size
	private Node<E> head = null;
	private int size = 0;
	
	//Insert Element at the end of List
	void add(E data) {
		
		Node<E> toAdd = new Node<>(data);
		//Adding to start when list is empty
		if(isEmpty()) {
			head = toAdd;
			size++;
			return;
		}
		//Adding to the end
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = toAdd;
		size++;
	}
	
	//Insert Element E at given Index
	void add(int index,E data) {
		
		Node<E> toAdd = new Node<>(data);

		//Insertion at Start of List if list is empty
		if(isEmpty()) {
			head = toAdd;
			size++;
			return;
		}
		
		//Insertion at start
		if(index ==0) {
			toAdd.next = head;
			head = toAdd;
			size++;
		}
		
		//Traverse the Singly Linked List to 1 Position Prior
	    //Stop traversing if you reached the end of the List
	    int currPosition = 0;
	    Node temp = head;
	    
	    while (currPosition < index -1 && temp.next != null){
	        temp = temp.next;        
	        currPosition++;       
	    }

	    //Inserting a Node in-between a List or at the end of of a List
	    Node nodeAtPosition = temp.next;
	    temp.next = toAdd;
	    temp = temp.next;
	    temp.next = nodeAtPosition;
	    size++;
	}
	
	E get(int index) {
		Node<E> temp = head;
		for(int i =0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	void set(int index,E value) {
		if(index < 0) {
			return;
		}
		Node<E> temp = head;
		for(int i =0; i < index; i++) {
			temp = temp.next;
		}
		temp.data = value;
	}
	
	void remove(int index) {
		if(index < 0) {
			return;
		}
		//Removing element at start
		if(index == 0) {
			head = head.next;
			size--;
		} 
		else{
			Node<E> temp = head;
			int currPosition =0;
			while(currPosition < index-1 && temp.next != null) {
				temp = temp.next;
				currPosition++;
			}
			temp.next = temp.next.next;
			size--;
		}
	}
	
	int size() {
		return size;
	}
	
	void print(){
		Node<E> temp = head;
		if(isEmpty()) {
			System.out.println(temp.data + "");
			return;
		}
		while(temp != null) {
			System.out.println(temp.data + "");
			temp = temp.next;
		}
	}
	
	boolean isEmpty() {
		return head == null;
	}
	
	static class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E data) {
			this.data = data;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<>();
		ll.add(1);
		System.out.println("Size- " + ll.size());
		ll.add(2);
		System.out.println("Size- " + ll.size());
		ll.add(4);
		ll.add(5);
		ll.add(2,3);
		System.out.println("Size- " + ll.size());
		System.out.println("Printing LinkedlIst:");
		ll.print();
		System.out.println("Element at index 2 - " + ll.get(2));
		System.out.println("Setting 0th element as 3 value :- ");
		ll.set(0, 3);
		ll.print();
		ll.remove(0);
		System.out.println("Size- " + ll.size());
		System.out.println("Printing LinkedlIst after deleting index 0:");
		ll.print();
		System.out.println("Size of LinkedList is:- " + ll.size());

	}

}
