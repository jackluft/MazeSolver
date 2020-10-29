public class Stack<T>{

	private Node<T> head;

	public Stack(){
		head = null;

	}

	public void push(T v){
		Node<T> cur = new Node<T>(v);
		cur.setNext(head);
		head = cur;

	}
	public Stack<T> copy(){
		Stack<T> stack = new Stack<T>();
		Node<T> cur = head;
		while(cur != null){
			stack.push(cur.getData());
			cur = cur.getNext();

		}

		return stack;
	}


	public T pop(){
		if(isEmpty()){
			System.out.println("Empty Stacks");
			return null;

		}else{
			Node<T> cur = head;
			head = head.getNext();
			return cur.getData();

		}
		

	}

	public void popAll(){
		while(head != null){
			head = head.getNext();

		}
	}

	public boolean isEmpty(){
		if(head == null){
			return true;

		}
		return false;
	}
	public T top(){
		if(isEmpty()){

		}
		return head.getData();
	}



}