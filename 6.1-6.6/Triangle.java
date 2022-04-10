import javax.swing.JOptionPane;

public class Triangle {
    public static void main(String args[]) {
        int height = Integer.parseInt(JOptionPane.showInputDialog(null, "Height of the triangle: "));
        String triangle = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                triangle += " ";
            }
            for (int k = 0; k < 1 + 2*i; k++) {
                triangle += "*";
            }
            triangle += "\n";
        }
        JOptionPane.showMessageDialog(null, triangle, "Triangle", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(triangle);
        System.exit(0);
    }
}