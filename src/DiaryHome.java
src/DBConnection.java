import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class DiaryHome extends JFrame implements ActionListener {

    JTextArea ta;
    JButton save, open, delete, clear;

    DiaryHome() {

        ta = new JTextArea();

        JScrollPane sp = new JScrollPane(ta);
        sp.setBounds(20, 20, 450, 300);

        save = new JButton("Save");
        open = new JButton("Open");
        delete = new JButton("Delete");
        clear = new JButton("Clear");

        save.setBounds(30, 340, 90, 30);
        open.setBounds(140, 340, 90, 30);
        delete.setBounds(250, 340, 90, 30);
        clear.setBounds(360, 340, 90, 30);

        add(sp);
        add(save);
        add(open);
        add(delete);
        add(clear);

        save.addActionListener(this);
        open.addActionListener(this);
        delete.addActionListener(this);
        clear.addActionListener(this);

        setTitle("Digital Diary");
        setSize(520, 450);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == save) {

            try {

                String fileName = JOptionPane.showInputDialog(
                        "Enter File Name");

                FileWriter fw = new FileWriter(fileName + ".txt");

                fw.write(ta.getText());

                fw.close();

                JOptionPane.showMessageDialog(this,
                        "File Saved Successfully");

            } catch(Exception ex) {
                System.out.println(ex);
            }
        }

        if(e.getSource() == open) {

            try {

                String fileName = JOptionPane.showInputDialog(
                        "Enter File Name");

                BufferedReader br = new BufferedReader(
                        new FileReader(fileName + ".txt"));

                ta.read(br, null);

                br.close();

            } catch(Exception ex) {
                System.out.println(ex);
            }
        }

        if(e.getSource() == delete) {

            String fileName = JOptionPane.showInputDialog(
                    "Enter File Name");

            File f = new File(fileName + ".txt");

            if(f.delete()) {

                JOptionPane.showMessageDialog(this,
                        "File Deleted Successfully");
            }
            else {

                JOptionPane.showMessageDialog(this,
                        "File Not Found");
            }
        }

        if(e.getSource() == clear) {
            ta.setText("");
        }
    }
}