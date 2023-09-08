public class DAC_merge_sort {
    public static void main(String[] args) {
        int[] arr = { 34, 56, 87, 45, 76 };
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.println("Array after sorting: ");
        merge_sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }

    static void merge_sort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }

    }

    static void merge(int[] arr, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left_arr = new int[n1];
        int[] right_arr = new int[n2];

        for (int i = 0; i < n1; i++)
            left_arr[i] = arr[low + i];

        for (int j = 0; j < n2; j++)
            right_arr[j] = arr[mid + 1 + j];

        int k = low, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (left_arr[i] <= right_arr[j]) {
                arr[k] = left_arr[i];
                i++;
                k++;
            } else {
                arr[k] = right_arr[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            arr[k] = left_arr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right_arr[j];
            j++;
            k++;
        }
    }
}
