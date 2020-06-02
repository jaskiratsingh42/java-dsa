package dsa;

public class MyStack2<E> {
	/* Generic Stack Implemented Using MyLinkedList class */
	private MyLinkedList<E> data;
	private int top;
	private int size;
		
	public MyStack2(MyLinkedList<E> data,int size) {
		super();
        this.data = data;
		this.top = -1;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == size-1;
	}
	
	public void push(E elem){
		if(isFull()) {
			return;
		}
		top++;
		data.add(elem);	
	}
	
	public void pop(){
		if(isEmpty()) {
			return;
		}
		data.set(top, null);
		top--;
	}
	
	public E stackTop(){
		if(isEmpty()) {
			return null;
		}
		return data.get(top);
	}
	
	public E peek(int pos) {
		int index = top-pos+1;
		if(index < 0) {
			return null;
		}
		return data.get(index);
	}
	
	public void display() {
		System.out.println("Stack Trace is-");
		for(int i = size-1; i >= 0; i--) {
			try {
				System.out.println(data.get(i).toString());
			}
			catch(java.lang.NullPointerException E) {
			    // It's fine if display() throws a NPE
			}
		}
	}
	public static void main(String[] args) {
		MyStack2 stack = new MyStack2<Integer>(new MyLinkedList<Integer>(),5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		stack.display();
		System.out.println("Peeked at 2 from Top: " + stack.peek(2));
	}

}
