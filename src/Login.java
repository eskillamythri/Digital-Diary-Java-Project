import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel l1;
    JPasswordField pf;
    JButton b1;

    Login() {

        l1 = new JLabel("Enter Password:");
        l1.setBounds(50, 50, 120, 30);

        pf = new JPasswordField();
        pf.setBounds(170, 50, 120, 30);

        b1 = new JButton("Login");
        b1.setBounds(120, 100, 100, 30);

        add(l1);
        add(pf);
        add(b1);

        b1.addActionListener(this);

        setSize(350, 220);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        String pass = pf.getText();

        if(pass.equals("admin123")) {
            new DiaryHome();
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Incorrect Password");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}