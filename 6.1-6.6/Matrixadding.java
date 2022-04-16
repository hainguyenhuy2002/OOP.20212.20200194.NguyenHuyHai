import javax.swing.JOptionPane;

public class Matrixadding {
    
    static int[][] Readmatrix(String[] array,int n, int m){
        int [][] first = new int[n][m];
        for (int i = 0; i < n; i++){
            String[] arra01 = array[i].split(" ");
            for (int j = 0;j < m; j++){
                first[i][j] = Integer.parseInt(arra01[j]);
            }
        }
        return first;
    }

    static String Displaymatrix(int[][] matrix,int n,int m){
        String matrixx = "";
        for (int i = 0; i < n; i++){
            for (int j = 0;j < m; j++){
                matrixx += matrix[i][j] + " ";
                
            }
            matrixx += "\n";
        }
    return matrixx;

    }
    public static void main(String[] args){
        int n  = Integer.parseInt(JOptionPane.showInputDialog(null,"Input the number of rows ",
                "Input the number of rows:",JOptionPane.INFORMATION_MESSAGE));
        int m  = Integer.parseInt(JOptionPane.showInputDialog(null,"Input the number of rows ",
                "Input the number of rows:",JOptionPane.INFORMATION_MESSAGE));       

        String str = (String)JOptionPane.showInputDialog(null,"Input element in first matrix (for example: 1 2,3 4): ","input",JOptionPane.INFORMATION_MESSAGE,null,null,"");
        String[] array1 = str.split(",");
    
        String str2  = (String)JOptionPane.showInputDialog(null,"Input element in second matrix (for example 1 2,3 4): ","input",JOptionPane.INFORMATION_MESSAGE,null,null,"");
        String[] array2 = str2.split(",");
        
        if(n == array1.length&& n ==array2.length && m ==  array1[0].split(" ").length && m ==  array2[0].split(" ").length){


        JOptionPane.showMessageDialog(null,"Input matrix 1: \n" + Displaymatrix(Readmatrix(array1, n, m),n,m) + "\nInput matrix 2: \n" + Displaymatrix(Readmatrix(array2, n, m),n,m),"Information",JOptionPane.INFORMATION_MESSAGE);
        int [][] sum = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0;j < m; j++){
                sum[i][j] = Readmatrix(array1, n, m)[i][j] + Readmatrix(array2, n, m)[i][j];
            }
        }
        JOptionPane.showMessageDialog(null,"Sum of two matrices: \n" + Displaymatrix(sum,n,m),"Information",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}