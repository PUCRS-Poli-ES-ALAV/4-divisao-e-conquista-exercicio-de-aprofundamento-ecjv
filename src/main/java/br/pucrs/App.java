package br.pucrs;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        int[] arr = { 70, 50, 30, 10, 20, 40, 60 };

		int[] merged = mergeSort(arr, 0, arr.length - 1);

		for (int val : merged) {
			System.out.print(val + " ");
		}

	}

    public static int[] mergeTwoSortedArrays(int[] a, int[]b) {

		int[] sorted = new int[a.length + b.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < a.length && j < b.length) {

			if (a[i] < b[j]) {
				sorted[k] = a[i];
				k++;
				i++;
			} else {
				sorted[k] = b[j];
				k++;
				j++;
			}
		}

		if (i == a.length) {

			while (j < b.length) {
				sorted[k] = b[j];
				k++;
				j++;
			}
		}

		if (j == b.length) {

			while (i < a.length) {
				sorted[k] = a[i];
				k++;
				i++;
			}
		}

		return sorted;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];

			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] merged = mergeTwoSortedArrays(fh, sh);

		return merged;
	}
}
