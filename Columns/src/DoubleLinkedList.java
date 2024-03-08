
public class DoubleLinkedList {
		private DLLNode head;
		private DLLNode tail;
		
		public DoubleLinkedList() {
			head=null;
			tail=null;
		}
		// add to end
		public void addToEnd(Object dataToAdd) {
			
			if(head==null && tail==null) {
				DLLNode newNode = new DLLNode(dataToAdd);
				head = newNode;
				tail = newNode;
			}
			else {
				DLLNode newnode = new DLLNode(dataToAdd);
				newnode.setPrev(tail);
				tail.setNext(newnode);
				tail = newnode;
			}
		}
		
		// add to front
		public void addToFront(Object dataToAdd) {
			
			if(head==null && tail==null) {
				DLLNode newNode = new DLLNode(dataToAdd);
				head = newNode;
				tail = newNode;
			}
			else {
				DLLNode newnode = new DLLNode(dataToAdd);
				if( (int) dataToAdd.compareTo((int) head.getData())<0){
					
				}
			}
		}
		
		public int size(){
			 int count = 0;
			 DLLNode temp = head;
			 while(temp != null){
			 count++;
			 temp = temp.next;
			 }
			 return count;
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
	
}
