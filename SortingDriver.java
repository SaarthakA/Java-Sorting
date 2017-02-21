package proj3;

import java.util.Scanner;

public class SortingDriver 
{
	public static void main(String args[])
	{
		int method = 0; // choice of sorting method
		int size = 0; // number of elements
		int in = 0; // input of element
		int count = 1; // count to ensure element doesnt go over size
		Scanner input = new Scanner(System.in);
		while(method != 4)
		{
			//initial menu for choice of method
			System.out.println("Which sorting method?: ");
			System.out.println("1. Insertion Sort");
			System.out.println("2. Merge Sort");
			System.out.println("3. Quick Sort");
			System.out.println("4.Quit");
			method = input.nextInt();
			System.out.println("How many elements?: ");
			size = input.nextInt();
			switch(method)
			{
				case 1: // Insertion Sort of Linked List
					System.out.println("Input elements");
					in = input.nextInt();
					Node<Integer> list = new Node<Integer>(in);
					while(count < size)
					{
						in = input.nextInt();
						list.add(in);
						count++;
					}
					// ----Completed creating Linked List of elements at this point-----
					System.out.println("----Before Sorting----");
					list.print();
					list.inserstionSort();
					System.out.println("----After Sorting----");
					list.print();
					break;
				case 2: // Merge Sort with Array
					System.out.println("Input elements");
					BagArray<Integer> list2 = new BagArray<Integer>(size);
					in = input.nextInt();
					list2.add(in);
					while(count < size)
					{
						in = input.nextInt();
						list2.add(in);
						count++;
					}
					Object [] temp = list2.toArray();
					// ----Completed creating array of elements at this point-----
					SortArray<Integer> sorter = new SortArray<Integer>();
					System.out.println("----Before Sorting----");
					for(int i = 0; i < temp.length; i++)
						System.out.print(temp[i] + " ");
					System.out.println();
					sorter.mergeSort(temp);
					System.out.println("----After Sorting----");
					for(int i = 0; i < temp.length; i++)
						System.out.print(temp[i] + " ");
					System.out.println();
					break;
				case 3: // Quick Sort with Array
					System.out.println("Input elements");
					BagArray<Integer> list3 = new BagArray<Integer>(size);
					in = input.nextInt();
					list3.add(in);
					while(count < size)
					{
						in = input.nextInt();
						list3.add(in);
						count++;
					}
					Object[] temp2 = list3.toArray();
					// ----Completed creating array of elements at this point-----
					SortArray<Integer> sorter2 = new SortArray<Integer>();
					System.out.println("----Before Sorting----");
					for(int i = 0; i < temp2.length; i++)
						System.out.print(temp2[i] + " ");
					System.out.println();
					sorter2.quickSort(temp2);
					System.out.println("----After Sorting----");
					for(int i = 0; i < temp2.length; i++)
						System.out.print(temp2[i] + " ");
					System.out.println();
					break;
			}
			System.out.println();
			method = 0;
			size = 0;
			in = 0;
			count = 1;
		}
		input.close();
	}
}
