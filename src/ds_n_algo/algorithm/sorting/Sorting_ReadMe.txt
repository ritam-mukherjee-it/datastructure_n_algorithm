BUBBLE SORT
------------
Simplest Sorting Algorithm

Mechanism	:

Traverse: Left -> right

1. On each Iteration 
	a. an element with it immediate right neighbor.
	b. If right neighbor is smaller then swap right and left.
	c. process repeat with remaining array items.

2. On each iteration largest unsorted element is sorted and goes to right most side.


Performance	:
1. Time complexity:
	Best Case	: 	O(n)  [ very good for best case, efficient when data is small and nearly sorted]
	Avg Case 	:	O(n^2)
	worst case 	: 	O(n^2)  [ Not appropriate for large unsorted data sets]
  
2. Space COmplexity:	O(n)
	Operates directly on Input array




INSERTION SORT
----------------

 Sorts each item of the array as they encountered.

 Traverse : left to right.
	1. Use single pass.
	2. each item's left side is sorted and right side is unsorted.
	3. After completion of each traversal The current item is "inserted" into currect place of sorted section.

	Algorithm:
	1. One loop pointing 1st element , traverse from 0 th location to nth location.
	2. another loop pointing j, passing from (i-1) to 0 th locaton[Sorted Area] and swap shortest one;
	
Advantage	: 	No additional space is needed, when memory space is sort
Disadvantage:	Not appropriate for large unsorted data

Performance	:
1. Time complexity:
	Best Case	: 	O(n)  [ very good for best case, efficient when data is small and nearly sorted]
	Avg Case 	:	O(n^2)
	Worst Case 	: 	O(n^2)

2. Space COmplexity:	O(n)
		It also operates directly from input array.

	




SELECTION SORT
---------------
Sort the data by finding  or SELECT shortest element and swapping it into  the ARRAY in the first unsorted location.

[Bubble find largest element and moves into its position, SE do opposite, find smallest and move into it's location]

Traverse :	Left -> right
	1. 	Identify the sorted element.
	2.	put it into the unsorted  position .
	3.  traverse to unsorted position and compare with elements either any item is smaller, if so swap is done.
	
Algorithm:
1. One for loop traverse from 0th location to n location pinting i;
2. Anthother for loop traversing i+1 location to n ocation pointing j,considering 'i'th location's element is shortest.
3. If during traversal find any j location's element smaller than 'i't h location's element do swapping.

1. Time complexity:
		Best Case	:O(n^2)
		Avg Case	: O(n^2
		Worst Case O(n^2)

2. Space Complexity:	O(n^2) [ Not applicable for large unsorted data set ]
	< Worked directly with input array, efficient when space crunch is there >.


Note:
 Hybrid of BUBBLE & INSERTION
 On performence standard better than "Bubble Sort" but worse than "Insertion Sort".
 
 

MERGE SORT
----------
Mechanism:
	1. Principal	:	Divide and Conquers
	2. The array is recursively split into two halves.
	3. When array is in group of 1, it is reconstructed in sort order.
	4. Each reconstructed array is merged with other halvs.

	
Algorithm:
	1. Mainly two methods involve to do sorting:
		A. mergeSort() : one recursive sort method ,responsible to split the array
				into two halves, consider as LEFT_ARRAY and RIGHT_ARRAY, and do sorting;
		B. mergeHalves() : one merge method call before each recursive call to merge sorted halves;
	2. mergeSort() method :
		A. Identify middle element;
		B. call mergeSort() method passing starting element as LEFT and middle element as RIGHT,
		C. call mergeSort() method as next to middle element as LEFT, & nth  element as RIGHT.
		D. call mergeHalves() method;
	3. mergeHalves():
		A. It got two arrays and consider both are sorted;
		B. Find out Middle element;
		C. consider LEFT element as starting fo LEFT_START and middle as LEFT_END,
		D. Consider MIDDLE as RIGHT_START and last nth element as RIGHT_END;
		E. starting point of TEMP array is LEFT_START element of LEFT_ARRAY.
		F. traverse both simultaneously and compare same location's element in both array;
		G. Whichever sorted put that into TEMP array. increase the INDEX.
		H. There may be a situation comes when either LEFT_ARRAY or RIGHT_ARRAY traversal complete.
		I. traverse individually LEFT_ARRAY and RIGHT_ARRAY and put elements in TEMP.
		J. Along with Combind LEFT_ARRAY and RIGHT_ARRAY traversal, only LEFT_ARRAY or RIGHT_ARRAY	
			traversal possible but not both simultaneously.
			

Property	:
	1. Appropriate for Large data set.
	2. Data spitting that means algorithm can be made parallel.
	3. Performances is good but fixed.

1. Time complexity:
		worst case/best case/ Worst Case:	O(nlogn)
2. Space Complexity	->	O(n)


Advantage:
		Predictable and dependable algorithm.
		
Disadvantage:
	A. Merge can be done but it is often not performed "in-place", One additional array is needed.
	B. The extra allocation increase the memory footprint required to sort data




QUICK SORT
-----------
Mechanism:
	1. Principal	:	Divide and Conquers of sorting
	2. It selects a pivot value from array either  a fixed rule or statistics.
			( no right or wrong choice of pivot element, only better choice).
	3. Put all value less than pivot position's value to left and more to right.
	4. Based on pivot partitioning happen and its self partitioning further.
	5. The process Repeat until sorted.

Algorithm:
	1. This algorithm always consider two special elements:
		A.PIVOT: A special element based on which other elements re-arrange their position quickly;
		B.INDEX: based on which ARRAY is devided into LEFT and RIGHT part.
	2.Mainly two methods involve to do sorting:
		A. quickSort() : one recursive sort method ,responsible to quickly re arrange 
		elements comparing PIVOT position's elements value.
		B. partition() : this method is responsible to find out proper position of INDEX.
	3.  quickSort();
		A. Identify middle element; [MIDDLE= LEFT +RIGHT /2]
		B. call partition() method to find out location of INDEX.
		C. call quickSort() method passing starting element as LEFT and INDEX element as right;
						[ quickSort(ARRAY,LEFT,INDEX) ]
		D. call quickSort() method as next to INDEX element as LEFT, & nth  element as RIGHT.
						[ quickSort(ARRAY,INDEX+1,RIGHT) ]
		
	4. partition()
		A. start traversal LEFT-> RIGHT considering 0th element as LEFT and nth element as RIGHT.
		B. Continue traversal till it reach LEFT<=RIGHT.  [WHILE(LEFT<=RIGHT)]
		C. while LEFT element is less than PIVOT just shift 1 place forward.
				WHILE[LEFT<PIVOT] { [LEFT++]};
		D. While RIGHT element is more than PIVOT element shift right element 1 place backward.
					WHILE (RIGHT>PIVOT>{ [RIGHT--] };
		E. encounter two sides when LEFT element is bigger than PIVOT and RIGHT is smaller than PIVOT.	
		F. Do swapping among LEFT location's element  and RIGHT locations element and continue progression.
				If[LEFT<=RIGHT]{ [SWAP; LEFT++, RIGHT--]  }
		J. while LEFT and RIGHT elements meet consider that position and return that location as INDEX;
				Return{[LEFT];

Performance:
1. Time complexity:		
	best case	:   O(nlog n)
	avg case 	:	O(nlogn)
	worst Case	:   O(n^2)

2. space complexity O(n)
	As recursive algorithm so stack space must be considered.