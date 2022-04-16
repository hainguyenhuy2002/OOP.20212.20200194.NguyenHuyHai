import javax.swing.JOptionPane;
import java.util.*;

class sorting 
{
    void merge(int arr[], int left, int middle, int right)
    {
        int low = middle - left + 1;                   
        int high = right - middle;                      
 
        int L[] = new int[low];                            
        int R[] = new int[high];

        int i = 0, j = 0;
 
        for (i = 0; i < low; i++)                             
        {
            L[i] = arr[left + i];
        }
        for (j = 0; j < high; j++)                            
        {
            R[j] = arr[middle + 1 + j];
        }
        
 
        int k = left;                                           
        i = 0;                                            
        j = 0;

        while (i < low && j < high)                    
        {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            }
            else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < low)                           
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < high)                          
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 

    void mergeSort(int arr[], int left, int right)      
    {
        int middle;
        if (left < right) {                             
            middle = (left + right) / 2;
 
            mergeSort(arr, left, middle);                    
            mergeSort(arr, middle + 1, right);              
 
            merge(arr, left, middle, right);               
        }
    }
 

    

    public static void main(String[] args){
        

        String str = (String)JOptionPane.showInputDialog(null,"Input element in array: ","input",JOptionPane.INFORMATION_MESSAGE,null,null,"");
        String[] array = str.split(",");
        
        int[] arr = new int[array.length];
        int sum = 0;
        for (int i=0;i<array.length;i++){
            arr[i] = Integer.parseInt(array[i]);
            sum += arr[i];
        }
        sorting ob = new sorting();
        ob.mergeSort(arr, 0, array.length - 1);
        JOptionPane.showMessageDialog(null,"Array sorted : " + Arrays.toString(arr)
        + "\nSum of all elements in the array: " + sum +"\nAverage of all elements in the array: " + sum/array.length,"Result",JOptionPane.INFORMATION_MESSAGE);

    }
}
