import javax.swing.JOptionPane;

public class Triangle {
    public static void main(String args[]) {
        int height = Integer.parseInt(JOptionPane.showInputDialog(null, "Height of the triangle: "));
        String triangle = "";
        for (int i = 0; i < height; i++) {
            for (int j = height - i + 1; j>=1; j--) {
                triangle += " ";
            }
            
            for (int k = 1; k <= i; k++) {
                triangle += "*";            
            }
            for (int k = i - 1; k >= 1; k--) {
                triangle += "*";            
            }
            
         
            triangle += "\n";
        }
        JOptionPane.showMessageDialog(null, triangle, "Star", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
