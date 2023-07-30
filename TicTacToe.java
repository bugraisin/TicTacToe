import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    public static void main(String[] args) {
        new TicTacToe();
    }
    private boolean turn=true;
    private JButton tmp = null;
    private int[][] matrix = {
            {2,2,2},
            {2,2,2},
            {2,2,2},
    };
    JButton b1 = new JButton();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    JButton b8 = new JButton();
    JButton b9 = new JButton();
    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setVisible(true);
        setLayout(new GridLayout(3,3));
        setSize(450,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        ButtonListener e = new ButtonListener();
        b1.addActionListener(e);
        b2.addActionListener(e);
        b3.addActionListener(e);
        b4.addActionListener(e);
        b5.addActionListener(e);
        b6.addActionListener(e);
        b7.addActionListener(e);
        b8.addActionListener(e);
        b9.addActionListener(e);

    }
    void place() {
        if(tmp.equals(b1) && turn)
            matrix[0][0] = 1;
        else if (tmp.equals(b1) && !turn)
            matrix[0][0] = 0;
        else if(tmp.equals(b2) && turn)
            matrix[0][1] = 1;
        else if (tmp.equals(b2) && !turn)
            matrix[0][1] = 0;
        else if(tmp.equals(b3) && turn)
            matrix[0][2] = 1;
        else if (tmp.equals(b3) && !turn)
            matrix[0][2] = 0;
        else if(tmp.equals(b4) && turn)
            matrix[1][0] = 1;
        else if (tmp.equals(b4) && !turn)
            matrix[1][0] = 0;
        else if(tmp.equals(b5) && turn)
            matrix[1][1] = 1;
        else if (tmp.equals(b5) && !turn)
            matrix[1][1] = 0;
        else if(tmp.equals(b6) && turn)
            matrix[1][2] = 1;
        else if (tmp.equals(b6) && !turn)
            matrix[1][2] = 0;
        else if(tmp.equals(b7) && turn)
            matrix[2][0] = 1;
        else if (tmp.equals(b7) && !turn)
            matrix[2][0] = 0;
        else if(tmp.equals(b8) && turn)
            matrix[2][1] = 1;
        else if (tmp.equals(b8) && !turn)
            matrix[2][1] = 0;
        else if(tmp.equals(b9) && turn)
            matrix[2][2] = 1;
        else if (tmp.equals(b9) && !turn)
            matrix[2][2] = 0;
    }
    int check() {
        /*
        -1 = cevap yok
        1 = x kazandı
        0 = o kazandı
         */
        if(matrix[0][0] == matrix[0][1] && matrix[0][0] == matrix[0][2] && matrix[0][0] !=2) {
            if (matrix[0][0] == 1)
                return 1;
            return 0;
        } else if(matrix[1][0] == matrix[1][1] && matrix[1][0] == matrix[1][2] && matrix[1][0] !=2) {
            if (matrix[1][0] == 1)
                return 1;
            return 0;
        } else if(matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2] && matrix[2][0] !=2) {
            if (matrix[2][0] == 1)
                return 1;
            return 0;
        } else if(matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0] && matrix[0][0] !=2) {
            if (matrix[0][0] == 1)
                return 1;
            return 0;
        } else if(matrix[0][1] == matrix[1][1] && matrix[1][0] == matrix[2][1] && matrix[0][1] !=2) {
            if (matrix[0][1] == 1)
                return 1;
            return 0;
        } else if(matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0] && matrix[0][2] !=2) {
            if (matrix[0][2] == 1)
                return 1;
            return 0;
        } else if(matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2] && matrix[0][0] !=2) {
            if (matrix[0][0] == 1)
                return 1;
            return 0;
        }
        return -1;
    }
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            ImageIcon xIcon = new ImageIcon("C:\\Users\\buggg\\IdeaProjects\\TicTacToe\\src\\x.png");
            ImageIcon oIcon = new ImageIcon("C:\\Users\\buggg\\IdeaProjects\\TicTacToe\\src\\o.png");
            if(turn) {
                button.setIcon(xIcon);
                tmp = button;
                place();
                turn = false;
            } else {
                button.setIcon(oIcon);
                tmp = button;
                place();
                turn = true;
            }
                int over= check();
            if(over == 1) {
                JOptionPane.showMessageDialog(null, "X KAZANDI");
            }
            else if (over == 0) {
                JOptionPane.showMessageDialog(null, "O KAZANDI");
            }


        }
    }
}
