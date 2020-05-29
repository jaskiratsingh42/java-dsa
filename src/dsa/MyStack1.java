package dsa;

public class MyStack1<E> {
	
	E data[];
	int top;
	int size;
		
	public MyStack1(Class<E>dataType,int size) {
		super();
        this.data = (E[]) java.lang.reflect.Array.newInstance(dataType, size);
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
		data[top] = elem;	
	}
	
	public void pop(){
		if(isEmpty()) {
			return;
		}
		data[top] = null;
		top--;
	}
	
	public E stackTop(){
		if(isEmpty()) {
			return null;
		}
		return data[top];
	}
	
	public E peek(int pos) {
		int index = top-pos+1;
		if(index < 0) {
			return null;
		}
		return data[index];
	}
	
	public void display() {
		System.out.println("Stack Trace is-");
		for(int i = size-1; i > 0; i--) {
			System.out.println(data[i]);
		}
	}
	public static void main(String[] args) {
		MyStack1 stack = new MyStack1(Integer.class,5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.pop();
		stack.display();
		System.out.println("Peeked at 2 from Top: " + stack.peek(2));
	}

}
