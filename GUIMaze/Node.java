public class Node<T>{

	private T data;
	private Node<T> next;

	public Node(T data){
		this.data = data;


	}
	public void setNext(Node<T> n){
		this.next = n;

	}
	public Node<T> getNext(){
		return next;
	}
	public T getData(){
		return data;
	}
}