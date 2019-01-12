                                ======================
                                ||      HEAP        ||
                                ======================
Two main variable plays key role:
	I. CAPACITY	:	Initial Size of the Array; which can grow;
	II. SIZE 	:	How many items are occupied.

-----------------------------------------------------------------------------------------
                                        MINHEAP
-----------------------------------------------------------------------------------------

Insert:
1. CAPACITY==SIZE?  --yes, CAPACITY=CAPACITY*2 & Copy ARRAY to new Bigger ARRAY.
2. Put the element into Size Location.
	If, ARRAY.SIZE==N then ARRAY[N-1] occupied, so new element will occupy INDEX[N].
3. Increase size
		SIZE=SIZE+1;
3.Heapifyup()
		A. Point last element  INDEX=ITEMS[SIZE-1]  // new sizeB.
		B. Traverse	:
				Until INDEX hase Parent element AND INDEX[DATA]<PARENT[DATA]
			Swap: ITEMS[INDEX.DATA] and ITEMS[PARENT.DATA]
		C.  INDEX= PARENT[INDEX]  <change pointer>


Delete:
1. If SIze==0? throw EROOR;
2. Item will always deleted from 1st/root location so ITEMS[0] point;
3. DETACH 'root' element and swap with last element
		ITEM[0]= ITTEMS[SIZE-1];
4. SRINK the ARRAY size
		SIZE=SIZE-1;  { ITEMS[SIZE-1] now detached }
5. heapifyDown()
	A. Point root element
			INDEX=ITEMS[0];
	B. Traverse:	until it has left child {unless LEFT child, RIGHT CHILD not possible];
	C. Select SMALLEST_CHILD_INDEX= LEFT_CHILD_INDEX.
		i. Initially choose LEFT_CHILD_INDEX as SMALLEST_CHILD_INDEX;
		ii. If item has RIGHT_CHILD and RIGHT_CHILD[DATA]<LEFT_CHILD[DATA]
			set SMALLEST_CHILD_INDEX=RIGHT_CHILD_INDEX;
	D.If ITEMS[INDEX.DATA]< ITEMS[SMALLEST_CHILD_INDEX.DATA]
				then break
				else SWAP.
	5. Set SMALLEST_CHILD_INDEX as INDEX;
			INDEX = SMALLEST_CHILD_INDEX