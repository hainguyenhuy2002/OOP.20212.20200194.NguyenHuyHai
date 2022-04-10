import javax.swing.JOptionPane;
import java.util.*;

public class sorting {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args){
        

        String str = (String)JOptionPane.showInputDialog(null,"Input element in array: ","input",JOptionPane.INFORMATION_MESSAGE,null,null,"");
        String[] arra = str.split(",");
        
        JOptionPane.showMessageDialog(null,"Input array: " + Arrays.toString(arra),"Information",JOptionPane.INFORMATION_MESSAGE);
        int n = arra.length;
        int[] arr = new int[n];
        int sum = 0;
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(arra[i]);
            sum += arr[i];
        }
        sorting ob = new sorting();
        ob.sort(arr, 0, n - 1);
        JOptionPane.showMessageDialog(null,"Sorted array: " + Arrays.toString(arr)
        + "\nSum of all elements in the array: " + sum +"\nAverage of all elements in the array: " + sum/n,"Result",JOptionPane.INFORMATION_MESSAGE);

    }
}