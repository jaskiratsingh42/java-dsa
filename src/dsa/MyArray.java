package dsa;

public class MyArray<T> {
	
	private int size;
	private T data[] =(T[])new Object[size];
	
	MyArray(T[] data, int size) {
		this.data = data;
		this.size = size;
	}
	
	public T get(int index) {
			return data[index];
	}
	
	public void set(int index, T value) {
		if(index < 0 || index >= size) {
			return;
		}
		data[index] = value;
	}
	
	public void insert(int index, T value) {
		if(index < 0 || index >= size) {
			return;
		}
		for(int i = size-1; i > index; i--) {
			data[i] = data[i-1];
		}
		data[index] = value;
	}
	
	public void remove(int index) {
		if(index < 0 || index >= size) {
			return;
		}
		for(int i = index; i < size-1; i++) {
			data[i] = data[i+1];
		}
	}
	
//	This is linear Search - returns index if element found else returns -1
	public int search(T elem) {
		for(int i =0; i < size; i++) {
			if(data[i] == elem) {
				return i;
			}
		}
		return -1;
	}
	// Reversing the Array by swapping elements from start & end
	public void reverse() {
		int i = 0,j = size-1;
		while(i<j)
		{
	  	   T temp = data[i];
		   data[i] = data[j];
		   data[j] = temp;
		   i++;
		   j--;
		}
	}
	// Reversing the Array by swapping elements from start & end
//	public void leftRotate(int rotDigit) {
//		if(rotDigit > 0) {
//			
//		}
//	}
//	
	public void print(){
		System.out.println("The Entire Array is-");
		for(int i =0; i < size; i++) {
			System.out.println(data[i]);	
		}
	}
	
	public static void main(String[] args) {

		//Initialising a demo Object Array
		Integer a[] = {1,2,3,4,5};
		MyArray arr = new MyArray(a,5);
		
//		Using MyArray Methods
//		arr.print();
		System.out.println("0th Element is:- " + arr.get(0));
//		arr.set(1, 0);
		arr.insert(0,5);
		arr.print();
		arr.remove(0);
		arr.print();
		System.out.println("Searching ELement 3, index is: " + arr.search(3));
		arr.reverse();
		arr.print();
	}

}
