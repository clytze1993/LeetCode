/**
 * Created by liuwenxiu on 2018/1/17.
 */
public class BubbleSort {
    public void bubbleSort(int[] a){
        int length = a.length;
        for(int i=length-1; i>=0 ; i--){
            for(int j =length-1; j>length-1-i ;j--){
                if(a[j]>a[j-1]){
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j]= tmp;
                }
            }
        }
    }
    public static void main(String[] args){
        BubbleSort bubbleSort =  new BubbleSort();
        int[] array = {8,78,90,56,19};
        bubbleSort.bubbleSort(array);
        for(int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}
