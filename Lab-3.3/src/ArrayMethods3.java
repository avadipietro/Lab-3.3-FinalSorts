//Ava DiPietro

import java.util.Arrays;

public class ArrayMethods3 {
	
	public static void main(String[] args) {
		String[] list1 = {"train", "xyz", "saurabh", "computer", "vex", "yeah", "zebra", "hat", "banana", "water"};
		int[] list3 = {4, 6, 7, 8, 1, 3, 5, 2, 0};
		
		//mergeSort Test
		long start = System.nanoTime();
		String[] mergeResult = mergeSort(list1);
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("mergeSort test took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(mergeResult));
		
		//quickSort Test
		start = System.nanoTime();
		quickSort(list3, 0, list3.length - 1);
		end = System.nanoTime();
		time = end - start;
		System.out.println("quickSort test took: " + time + " nanoseconds");
		System.out.println(Arrays.toString(list3));
	}
	
	public static String[] mergeSort(String[] list) {
		
		/*Write a method that recursively separates the list into two halves and calls mergeSort on both
		halves. When we reach two halves that have length 1, then merge the arrays together. Return the fully
		sorted array.*/
		
		if (list.length > 1) {
			String[] l1 = new String[list.length / 2];
			for (int x = 0; x < l1.length; x++) {
				l1[x] = list[x];
			}
			String[] l2 = new String[list.length - (list.length / 2)];
			for (int x = 0; x < l2.length; x++) {
				l2[x] = list[x + list.length / 2];
			}
			return merge(mergeSort(l1), mergeSort(l2));
		}
		else {	
			return list;
		}
	}
	
	public static void quickSort(int[] list1, int front, int back) {
		if (front < back) {
			int p = partition(list1, front, back);
			quickSort(list1, front, p - 1);
			quickSort(list1, p + 1, back);
		}
	}
	
	public static String[] merge(String[] list1, String[] list2) {

		int x = 0;
		int y = 0;
		int xcompy = 0;
		String[] list3 = new String[list1.length + list2.length];
		for (int z = 0; z < list3.length; z++) {
			if (x >= list1.length) {
				xcompy = 1;
			}
			else if (y >= list2.length) {
				xcompy = -2;
			}
			else {
				xcompy = list1[x].compareTo(list2[y]);
			}
			if (xcompy <= 0) {
				list3[z] = list1[x];
				x++;
			}
			else {
				list3[z] = list2[y];
				y++;
			}
		}
		return list3;	
	}
	
	public static int partition(int[] list, int front, int back) {
		
		int i = front;
		int pivot = list[front];		
		for (int j = front + 1; j <= back; j++) {
			if (list[j] < pivot) {
				i++;
				int m = list[i];
				list[i] = list[j];
				list[j] = m;
			}
		}
		for (int a = front; a < i; a++) {
			list[a] = list[a + 1];
		}
		list[i] = pivot;
		return i;
	}
}
