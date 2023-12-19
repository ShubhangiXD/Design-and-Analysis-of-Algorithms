package C_Programming;

import java.util.*;
//space complexity = O(n)
class DAC_max_element {
    static int max_ele(int[] arr, int low, int high) {
        if (low == high)
            return arr[low];
        int mid = (low + high) / 2;
        return find_max(max_ele(arr, low, mid), max_ele(arr, mid + 1, high)); 
    } //time complexity = O(nlogn) [find_max called twice, each running n/2 times]

    static int find_max(int a, int b) {
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Maximum element:" + max_ele(arr, 0, arr.length - 1));

        sc.close();
    }
}