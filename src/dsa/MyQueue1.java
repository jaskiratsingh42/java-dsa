package dsa;

public class MyQueue1<E> {
	private E data[];
	private int size;
	private int front;
	private int rear;
	
	public MyQueue1(Class<E> dataType, int size) {
		super();
		this.data = (E[]) java.lang.reflect.Array.newInstance(dataType, size);
		this.size = size;
		this.front = -1;
		this.rear = -1;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	public boolean isFull() {
		return rear == size-1;
	}
	public void enqueue(E elem) {
		if(isFull()) {
			return;
		}
		rear++;
		data[rear] = elem;
	}
	public void dequeue() {
		if(isEmpty()) {
			return;
		}
		front++;
		data[front] = null;
	}
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue Empty.");
		}
		else {
			System.out.println("Queue Elements are:");
			for (int i = front+1; i <= rear; i++) {
				System.out.println(data[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		MyQueue1 q = new MyQueue1(Integer.class,5);
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
