package dsa;

public class MyDoublyLinkedList<E> {
//	Implementation with Both Head & Tail Reference
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
//	Insert Element at the end of List
	void add(E data) {
		Node<E> toAdd = new Node<>(data);
//		Insertion at Start of List if list is empty
		if(isEmpty()) {
			head = toAdd;
			tail = head;
			size++;
			return;
		}
		//Insertion at the End of List
		toAdd.prev = tail;
		tail.next = toAdd;
		tail = toAdd;
		size++;
	}
//	Insert Element E at given Index
	void add(int index,E data) {
		
		Node<E> toAdd = new Node<>(data);
		
		//Insertion at start
		if(index ==0) {
//		Insertion at Start of List if list is empty
			if(isEmpty()) {
				head = toAdd;
				tail = head;
				size++;
				return;
			}
			toAdd.next = head;
			head.prev = toAdd;
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
			temp.next = toAdd;
			toAdd.prev = temp;
			toAdd.next = temp.next.next;
			toAdd.next.prev = toAdd;
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
		if(index == 0) {
			if(size == 1) {
				head = null;
				tail = null;
				size = 0;
				return;
			}
			head = head.next;
			head.prev = null;
			size--;
		}
		else if (index == size-1){
			tail = tail.prev;
			tail.next = null;
			size--;
		}
		else
		{
			Node<E> temp = head;
			for(int i =0; i <index-1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			temp.next.prev = temp.next;
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
		return head == null && tail == null;
	}
	
	static class Node<E>{
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E data) {
			this.data = data;
			prev = null;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<Integer> ll = new MyLinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(4);
		ll.add(5);
		System.out.println("Size: " + ll.size());
		ll.add(2,3);
		System.out.println("Printing LinkedlIst:");
		ll.print();
		System.out.println("Element at index 2 - " + ll.get(2));
		System.out.println("Setting 0th element as 3 value :- ");
		ll.set(0, 3);
		ll.print();
		ll.remove(1);
		System.out.println("Printing Linkedlist after removing index 1:");
		ll.print();
		System.out.println("Size of LinkedList is:- " + ll.size());

	}

}
