package proj3;
/////////////////////////////////////////////////////////////////////
class Node <T extends Comparable <T>>
{
	private Node<T> head;               
	private Node<T> tail;
	private T data;
	private Node<T> next;
	private Node<T> prev;
//-------------------------------------------------------------
	/** Constructor 1.
    @param starting data.
   	@return  none */
	public Node(T newData)
	{
		this(newData, null);
		head = this;
		tail = null;
	}
//-------------------------------------------------------------
	/** sub Constructor for Constructor 1 and initializes next and prev to null.
    @param starting data.
   	@return  none */
	private Node(T newData, Node<T> nextNode)
	{
		data = newData;
		next = nextNode;
		prev = nextNode;
	}
//-------------------------------------------------------------------
	/** Checks if empty list.
    @param none.
   	@return  true if empty list*/
	public boolean isEmpty()        
	{ 
		return head == null; 
	}
//-------------------------------------------------------------
	/** adds to list at the front.
    @param entry to be added.
   	@return  none.*/
	public void add(T newEntry)  
	{
		Node<T> newLink = new Node<T>(newEntry);   
		if(isEmpty())               
			tail = newLink;             
		else
			head.prev = newLink;   	
		newLink.next = head;          
		head = newLink;               
	}
//-------------------------------------------------------------
	/** delete item from list at the front.
    @param none.
   	@return  Node that is removed.*/
	public Node<T> remove()         
	{                              
		Node<T> temp = head;
		if(head.next == null)         
			tail = null;                
		else
			head.next.prev = null; 
		head = head.next;            
		return temp;
   }
//-------------------------------------------------------------
	/** delete item from list at the back.
    @param none.
   	@return  Node that is removed.*/
	public Node<T> removeLast()          
	{                             
		Node<T> temp = tail;
		if(head.next == null)         
			head = null;              
		else
			tail.prev.next = null;  
		tail = tail.prev;          
		return temp;
   }
//-------------------------------------------------------------
	/** Prints list.
    @param none.
   	@return  none.*/
	public void print()
	{
		System.out.print("List (first to last): ");
		Node<T> current = head;          
		while(current != null)         
		{
			System.out.print(current.data + " ");      
			current = current.next;     
		}
		System.out.println();
	}
//-------------------------------------------------------------
	/** Insertion sorting of the list.
    @param none.
   	@return  none.*/
	public void inserstionSort()
    {
        Node<T> out;
        Node<T> in = null;
        for (out = head.next; out != null; out = out.next)
        {
            Node<T> temp = out;
            in = out;
            while (in.prev != null && in.prev.data.compareTo(temp.data) > 0 )
            {
                in = in.prev;
            }
            if (in != out)
            {
                if (temp.prev != null)
                {
                    temp.prev.next= temp.next;
                }
                if (temp.next != null)
                {
                    temp.next.prev = temp.prev;
                }
                if (in.prev == null)
                {
                    head.prev = temp;
                    temp.next = head;
                    head = temp;
                    head.prev = null;
                }

                else
                {
                    temp.prev = in.prev;
                    in.prev.next = temp;
                    in.prev = temp;
                    temp.next = in;
                }
            }
            if (out.next == null)
            {
                tail = out;
            }
        }
    }
//-------------------------------------------------------------
}
/////////////////////////////////////////////////////////////////////