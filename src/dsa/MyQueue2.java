package dsa;

import dsa.MyLinkedList.Node;

public class MyQueue2<E> {
	private int size;
	private Node<E> front;
	private Node<E> rear;
	
	public MyQueue2(int size) {
		super();
		this.size = size;
		this.front = null;
		this.rear = null;
	}
	public MyQueue2() {
		super();
		this.size = 10;
		this.front = null;
		this.rear = null;
	}
	public boolean isEmpty() {
		return front == null;
	}
	public boolean isFull() {
		Node<E> temp = front;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count == size-1;
	}
	public void enqueue(E elem) {
		if(isFull()) {
			return;
		}
		Node<E> toAdd = new Node<E>(elem);
		if(isEmpty()) {
			front = rear = toAdd;
		}
		else {
			rear.next = toAdd;
			rear = toAdd;
		}
		
	}
	public void dequeue() {
		if(isEmpty()) {
			return;
		}
		Node<E> toDel = front;
		front = front.next;
		toDel = null;
		if (front == null) {
			rear = null;
		}
	}
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue Empty.");
		}
		else {
			System.out.println("Queue Elements are:");
			Node<E> temp = front;
			while(temp != null) {
				System.out.println(temp.data.toString());
				temp = temp.next;
			}
		}
	}
	
	public static void main(String[] args) {
		MyQueue2 q = new MyQueue2();
		q.display();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.display();
		q.dequeue();
		q.display();
	}

}
