/*
 * MinMax Heap is a heap where
 * the minimum and maximum elements are able to be accessed in the quickest time possible
 * the root will be the minimum element
 * the left or right node from the root will be the maximum element
 */
public class MINMAXHEAP2
{
    private int[] Heap;  // this is the heap
    private int size;    // the number of elements in the heap
    private int maxsize; // the max capacity of the heap
 
    private static final int FRONT = 1;
 
    // @param maxsize the size of the heap
    public MINMAXHEAP2(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = 0;
    }
 
    /* 
     * @param pos the position of the node who's parent you want to find
     * @result the position of the parent node in the heap
     */
    private int parent(int pos)	
    {
        return pos / 2;
    }
 
    /*
     * @param pos the position of the node who's left child you want to find
     * @result the position of the left child node in the heap
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    /*
     * @param pos the position of the node who's right child you want to find
     * @result the position of the right child node in the heap
     */

    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    /*
     * swaps the position of two elements in the heap
     * @param fpos the first position to switch
     * @param spos the position with which the first element should switch with
     */
    private void swap(int fpos,int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    /*
     * Heap property that organizes the heap after inserting a new node
     * @param pos the position of the node that was just inserted
     */
    private void InsertHeapify(int pos)
    {
       
        	int height = height(pos); // height of the node at pos
        	  
        	
        	if(height%2 == 0) // if height is even
              {
        	
            if ( Heap[pos] > Heap[parent(pos)] && parent(pos)!= 0)
            {
               
                    swap(pos, parent(pos));
                    InsertHeapify(parent(pos));
                
            }
            else if(Heap[pos]< Heap[parent(parent(pos))] &&  parent(parent(pos))!= 0)
            {
          	  swap(pos,parent(parent(pos)));
              InsertHeapify(parent(parent(pos)));
            }
              }
        	
        	
        	  else // if height is odd
        	  {
        		  if(Heap[parent(pos)]> Heap[pos] &&  parent(pos)!= 0)
        		  {
                      swap(pos, parent(pos));
                      InsertHeapify(parent(pos));

        		  }
        		  else if(Heap[pos]> Heap[parent(parent(pos))] &&  parent(parent(pos))!= 0)
        		  {
        			  swap(pos,parent(parent(pos)));
                      InsertHeapify(parent(parent(pos)));

        		  }
        	  }
            
        
    }
 
    /*
     * Gets the height of the node
     * @param positon the position of the node in the heap array
     * @return height the height of the node from the root
     */
    public int height(int position)
    {
    int exponent = 0;
    while(position+1> Math.pow(2, exponent))
    {
    	exponent++;
    }
    int height = exponent - 1;
    return height;
    }
    
    /*
     * Adds a new node to the heap
     * @param element the data in the node
     */
    public void insert(int element)
    {
        Heap[++size] = element;
        int current = size;
        int height = height(current);
        InsertHeapify(current);
    }
    
    /*
     * Prints information about the heap
     */
    public void print()
    {
        for (int i = 1; i <= (size/2); i++ )
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2*i]
                  + " RIGHT CHILD :" + Heap[2 * i  + 1]);
            System.out.println();
        }
    }
    
    
    /*
     *  Deletes the smallest node and fills up the node position with the next smallest node
     */
    public void deleteMin()
    {
    	 int current = size;           // present size of the heap
    	 Heap[1] = Heap[current];      // present smallest node
    	 Heap[current] = 0;       
    	 int smallest = Heap[1];       // removed the smallest element
    	 int foundSmallest = smallest; // represents the next smallest element in the heap 
    	 int foundSmallestIndex = 1;   // represents the index of the smallest element

    	 size--;
    	 
    	 
    	 for(int i = 2;i< size+1;i++)    // searching through the heap for the next smallest element
    	 {
    			int compare = Heap[i];   // the number that we are comparing with
    			if(foundSmallest> compare)
    			{
    				foundSmallestIndex = i;
    				foundSmallest = compare;
    			}
    	 }
			swap(1,foundSmallestIndex);  // switch the root with the smallest element
    	 
    }
    
    
    public void deleteMax()
    {
    	int FoundMaxIndex = 0;                  // refers to the index of the next largest node
    	int MaxIndex = 0;						// refers to the index of the present largest node
    	int max = Math.max(Heap[2], Heap[3]);   // used to find which is the max
    	if(max == Heap[2])
    	{
    		MaxIndex = 2;
    	}
    	else
    	{
    		MaxIndex = 3;
    	}
		FoundMaxIndex = MaxIndex;

    	int current = size;
    	 Heap[MaxIndex] = Heap[current];
    	 Heap[current] = 0;
    	 size--;
    	 
    	 
    	 for(int i =4;i<size+1;i++)             // looks through the rest of the array for the next largest
    	 {
    			int compare = Heap[i];
    			if(Heap[FoundMaxIndex]< compare)
    			{
    				FoundMaxIndex = i;
    			}
    	 }
			swap(MaxIndex,FoundMaxIndex);       // swaps positions with the present largest

    }
        
    /*
     * Gets the data at the given position in the heap
     * @param position the position of the node in the heap
     * @result value the value stored inside the node
     */
    public int get(int position)
    {
    int value = Heap[position];
    return value;
    }
    
    
    /*
     * Using to test the heap
     */
    public static void main(String...arg)
    {
        System.out.println("The Max Heap is ");
        MINMAXHEAP2 MinMaxHeap = new MINMAXHEAP2(15);
        MinMaxHeap.insert(7);
        MinMaxHeap.insert(4);
        MinMaxHeap.insert(13);
        MinMaxHeap.insert(19);
        MinMaxHeap.insert(2);
        MinMaxHeap.insert(21);
        MinMaxHeap.insert(23);
        MinMaxHeap.insert(24);
        MinMaxHeap.deleteMin();
        MinMaxHeap.deleteMax();
        MinMaxHeap.deleteMin();
 
        int left = MinMaxHeap.get(2);
        int right = MinMaxHeap.get(3);
        int largest = Math.max(left, right);
        MinMaxHeap.print();
        System.out.println("The minimum val is " + MinMaxHeap.get(1));
        System.out.println("The maximum val is " + largest);
    }
}