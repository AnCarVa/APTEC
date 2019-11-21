package proyectoalgo3;

public class LinkedList {
	
private class Node {
		
		//atributos
		
		private Object element;
		private Node next;
		private Node previous;
		
		//Constructores
		public Node() {
			this.element = null;
			this.next = null;
			this.previous = null;
		}
		
		public Node(Object element) {
			this.element = element;
			this.next = null;
			this.previous = null;
		}
		
		public Node(Object element,Node previous, Node next) {
			this.element = element;
			this.previous = previous;
			this.next = next;
			
		}
		
		//métodos
		
		public Object getElement() {
			return this.element;
		}
		
		public void setElement(Object element) {
			this.element = element;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node next) {
			this.next = next;	
		}
		
		public Node getPrevious() {
			return this.previous;
		}
		
		public void setPrevious(Node previous) {
			this.previous = previous;	
		}
	}

	//atributos LinkedList
	private Node head;
	private Node current;
	private Node tail;
	private int position;
	private int size;

	public LinkedList(){
		this.head = new Node();
		this.current = this.head;
		this.tail = this.head;
		this.size = 0;
		this.position = -1;
	}
	

	/**
	 * Agrega un nuevo elemento a la lista
	 * @param element El elemento a agregar
	 */
	public void insert(Object element) {
		//insertar en cualquier posición
		Node newNode = new Node(element, this.current, this.current.getNext());
		if (this.current != this.tail) 
			this.current.getNext().setPrevious(newNode);
		this.current.setNext(newNode);
		//necesario si se está insertando al final de la lista
		if (this.current == this.tail) {
			this.tail = tail.getNext();
		}
		this.size++;	
	}
	
	/**
	 * Agrega un nuevo elemento a la lista
	 * @param element El elemento a agregar
	 */
	public void append(Object element) {
		//insertar en cualquier posición
		Node newNode = new Node(element, this.tail, null);
		this.tail.setNext(newNode);
		this.tail = newNode;
		this.size++;	
	}
	
	public void remove(){
		//verificar que la lista no está vacía
		if ((this.head == this.current) && (this.head == this.tail)){
			System.out.println("Lista vacía, no se puede remover ningún elemento");
			return;
		} 
		if (this.head == this.current){
			System.out.println("Nodo especial no se puede borrar");
			return;
		}
		
		//último nodo
		if(this.current == this.tail){
			this.current.getPrevious().setNext(null);
			this.position--;
			this.tail = this.current.getPrevious();
		} else {
			this.current.getNext().setPrevious(this.current.getPrevious());
			this.current.getPrevious().setNext(this.current.getNext());
			
		}
		this.current = this.current.getPrevious();
		this.size--;
		
		
		
		
		
	}
	
	public Object getElement(){
		return this.current.getElement();
	}	
	
	public int getSize() {
		return this.size;
	}
	
	public boolean next() {
		if (this.current == this.tail) {
			System.out.println("Actualmente en último nodo, no se puede avanzar");
			return false;
		}
		this.current = this.current.getNext();
		this.position++;
		return true;
	}
	
	public boolean previous() {
		if (this.current == this.head) {
			System.out.println("Actualmente en primer nodo, no se puede retroceder");
			return false;
		}
		this.current = this.current.getPrevious();
		this.position--;
		return true;
	}
	
	/**
	 * Devuelve la representación en String de la lista
	 * @return un string representado la lista
	 */
	public String toString() {
		Node currentNode = this.head.getNext();
		
		StringBuffer result = new StringBuffer();
        
        for (int i = 0; currentNode != null; i++) 
		{
        	if (i > 0) 
			{
        		result.append(", ");
        	}
        	Object element = currentNode.getElement();
			
        	if(currentNode != this.tail)
        		result.append(element == null ? "" : element + "(P: " + currentNode.getPrevious().getElement() + ", N: " + currentNode.getNext().getElement() + ")");
        	else
        		result.append(element == null ? "" : element + "(P: " + currentNode.getPrevious().getElement() + ")");
        	currentNode = currentNode.getNext();
        }
        result.append("\nHead: " + this.head.getElement() + ", Current: " + this.current.getElement() + ", Tail: " + this.tail.getElement() );
        return result.toString();
	}
	
	public static void main(String[] args){
		LinkedList lista = new LinkedList();
		lista.insert(9);
		lista.insert(8);
		lista.insert(7);
		lista.insert(6);
		lista.append(10);
		lista.append(11);
		lista.insert(5);
		System.out.println(lista.toString());
		
		System.out.println("avanzar al 6, y borrar 2");
		lista.next();
		lista.next();
		lista.remove();
		System.out.println(lista.toString());
		lista.remove();
		System.out.println(lista.toString());
		lista.next();
		lista.next();
		lista.next();
		lista.next();
		lista.next();
		System.out.println("avanzar al último, y borrar ");
		lista.remove();
		System.out.println(lista.toString());
	}

}
