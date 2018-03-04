/**
 * Created by liuwenxiu on 2018/1/17.
 */
public class QuickSort {
    public void quickSort(int[] a,int i,int j){
        int left = i;
        int right = j;
        if(i >=  j){
            return;
        }
        int key = a[i];
        while (i < j){
            while (a[j] > key && i<j)
                j--;
            swap(a,i,j);
            while (a[i] < key && i<j)
                i++;
            swap(a,i,j);
        }
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        QuickSort quicksort =  new QuickSort();
        int[] array = {8,78,90,56,19};
        quicksort.quickSort(array, 0, 4);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
