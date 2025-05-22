package algorithm.sort;

public class QuickSort {

	// 主方法
	public static void main(String[] args) {
		int[] array = {3, 6, 8, 10, 1, 2, 1};
		quickSort(array, 0, array.length - 1);

		// 输出排序后的数组
		for (int num : array) {
			System.out.print(num + " ");
		}
	}

	// 快速排序方法
	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			// 获取分区索引
			int pivotIndex = partition(array, low, high);
			// 递归排序左右部分
			quickSort(array, low, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, high);
		}
	}

	// 分区方法
	public static int partition(int[] array, int low, int high) {
		int pivot = array[high]; // 选择基准
		int i = low - 1; // 小于基准的元素索引

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				i++;
				swap(array, i, j); // 交换符合条件的元素
			}
		}
		// 最后将基准元素放到正确的位置
		swap(array, i + 1, high);
		return i + 1; // 返回基准元素的索引
	}

	// 交换元素的辅助方法
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}