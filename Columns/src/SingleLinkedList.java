public class SingleLinkedList {
	private Node head;
	
	public void add(Object data) {
		
		Node newNode = new Node(data);
		if(head == null) 
			head = newNode;
		else {
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(newNode);
		}
	}
	
	public int size() {
		int counter = 0;
		if(head == null) return 0;
		else {
			Node temp = head;
			
			while(temp != null) {
				temp = temp.getLink();
				counter++;
			}
		}
		return counter;
	}
	public void display() {
		if(head == null) System.out.println("List is empty");
		else {
			Node temp = head;
			while(temp != null) {
				//System.out.println(temp.getData() + " ");
				System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
		
	}
	public void displayColumn(int columnNumber) {
		if(head == null) System.out.println("List is empty");
		else {
			Node temp = head;
			int y = 4;
			while(temp != null) {
				Test.cn.getTextWindow().setCursorPosition(3 * columnNumber + columnNumber - 1, y);
				System.out.println(temp.getData() + " ");
				y++;
				//System.out.print(temp.getData() + " ");
				temp = temp.getLink();
			}
		}
		
	}
	public void delete(Object data) {
		if(head == null) System.out.println("List is empty");
		else {
			while(head != null && (Integer)head.getData() == (Integer)data)head = head.getLink();
			Node previous = null;
			Node temp = head;
			while(temp != null) {
				if((Integer)temp.getData() == (Integer) data) {
					previous.setLink(temp.getLink());
					temp = previous;
					return;
				}
				previous= temp;
				temp = temp.getLink();
			}
		}
	}
	public int findMax() {
		int maxVal = Integer.MIN_VALUE;
		if(head == null)System.out.println("List is empty");
		else {
			Node temp = head;
			while(temp != null) {
				if((Integer)temp.getData() > maxVal) maxVal = (Integer)temp.getData();
				temp = temp.getLink();
			}
		}
		return maxVal;
	}
	public boolean search(Object data) {
		if(head == null)System.out.println("List is empty");
		else {
			Node temp = head;
			while(temp != null) {
				if(temp.getData() == data) return true;
				temp = temp.getLink();
			}
		}
		return false;
	}
	
	void fillingBox() {
		
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= 10; j++) {
				add(j);
			}
		}
	}
	int choosingRandomNumber() {
		int rnd = (int) (Math.random()*size()+1);
		int counter = 1;
		Node temp = head;
		while(temp.getLink() != null) {
			if(counter == rnd)break;
			counter++;
			temp = temp.getLink();
		}
		Object data = temp.getData();
		delete(data);
		
		return (int)data;
	}
	
}

