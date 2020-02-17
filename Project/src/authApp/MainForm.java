package authApp;

import javax.swing.*;

public class MainForm extends JFrame{

    private JPanel panel1;
    private JProgressBar progressBar1;  //For Loading Time

    public MainForm(){
        setSize(500,500);
        setContentPane(panel1);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
