package dsa;

public class MyArray<T> {
	
	private int length;
	private T data[] =(T[])new Object[length];
	
	MyArray(T[] data,int length) {
		this.data = data;
		this.length = length;
	}
	
	public T get(int index) {
			return data[index];
	}
	
	public void set(int index, T value) {
		if(index < 0 || index >= length) {
			return;
		}
		data[index] = value;
	}
	
	public void insert(int index, T value) {
		if(index < 0 || index >= length) {
			return;
		}
		for(int i = length-1; i > index; i--) {
			data[i] = data[i-1];
		}
		data[index] = value;
	}
	
	public void remove(int index) {
		if(index < 0 || index >= length) {
			return;
		}
		for(int i = index; i < length-1; i++) {
			data[i] = data[i+1];
		}
	}
	
//	This is linear Search - returns index if element found else returns -1
	public int search(T elem) {
		for(int i =0; i < length; i++) {
			if(data[i] == elem) {
				return i;
			}
		}
		return  -1;
	}
	
	public void print(){
		System.out.println("The Entire Array is-");
		for(int i =0; i < length; i++) {
			System.out.println(data[i]);	
		}
		
	}
	
	public static void main(String[] args) {

		//Initialising a demo Object Array
		Integer a[] = {1,2,3,4,5};
		MyArray arr = new MyArray(a,5);
		
//		Using MyArray Methods
		arr.print();
		System.out.println("0th Element is:- " + arr.get(0));
//		arr.set(1, 0);
		arr.insert(0,5);
		arr.print();
		arr.remove(0);
		arr.print();
		System.out.println("Searching ELement 3, index is: " + arr.search(3));
	}

}
