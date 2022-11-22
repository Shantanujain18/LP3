package assignments;

public class Assignment5 {

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];

		System.out.println("Pivot - " + high + "; Element : " + pivot);
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static int partition(int[] arr, int low, int high, int n) {
		int r = (int) (Math.random() * n);
		int pivot = arr[high];
		System.out.println("Pivot - " + r + "; Element : " + arr[r]);
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void quickSort(int[] arr, int low, int high, int n, boolean randomized) {
		if (low < high) {
			int pi = 0;
			if (randomized) {
				pi = partition(arr, low, high, n);
			} else {
				pi = partition(arr, low, high);
			}

			quickSort(arr, low, pi - 1, n, randomized);
			quickSort(arr, pi + 1, high, n, randomized);
		}
	}

	static void printArray(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {

		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		System.out.println("--------------------------------------------------");
		System.out.println("Given Array : ");
		printArray(arr, n);

		System.out.println("--------------------------------------------------");

		System.out.println("Deterministic QuickSort : ");

		System.out.println("--------------------------------------------------");
		quickSort(arr, 0, n - 1, n, false);
		System.out.println("Sorted array: ");
		printArray(arr, n);

		System.out.println("--------------------------------------------------");
		System.out.println("Randomized QuickSort : ");

		System.out.println("--------------------------------------------------");
		int[] arr2 = { 10, 7, 8, 9, 1, 5 };
		n = arr2.length;

		quickSort(arr2, 0, n - 1, n, true);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}

}
