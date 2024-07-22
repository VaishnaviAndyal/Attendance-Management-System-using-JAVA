import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener
{
    JLabel BackImg;
    JLabel emailL,passL;
    JTextField emailT;
    JPasswordField passT;
    JButton signB,loginB;
    String em,ps;
    JPanel heading , login ;
    Font hf;
    Main()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(800,800);
        setTitle("Student Attendance System");
        setLayout(null);
        setResizable(false);

        //Fonts 
            hf = new Font("Algerian",Font.BOLD,30);
            // lf = new Font("Times New Roman",Font.PLAIN,16);
        //heading 
            heading = new JPanel();
            heading.setLayout(null);   
            heading.setBounds(0,0,2000,150);
            heading.setBackground(new Color(0,0,0,200));
            JLabel name = new JLabel("ATTENDANCE SYSTEM");
            name.setFont(hf);
            name.setForeground(Color.WHITE);
            name.setBounds(200,20,600,120);
            heading.add(name);

        //login 
            login = new JPanel();
            login.setLayout(null);   
            login.setBounds(100,200,600,400);
            login.setBackground(new Color(0, 0, 0, 153));
            // login.setBackground(new Color(134,95,60,209));

            emailL=new JLabel("Enter Your Email ");
            //emailL.setFont(lf);
            emailL.setForeground(Color.WHITE);
            passL=new JLabel("Enter Your Password ");
            //passL.setFont(lf);
            passL.setForeground(Color.WHITE);
            emailT=new JTextField(10);
            passT=new JPasswordField(10);
            passT.setEchoChar('*');
            signB=new JButton("Sign UP");
            signB.setBackground(Color.BLACK);
            signB.setForeground(new Color(255,255,255));
            loginB=new JButton("Login");
            loginB.setBackground(Color.BLACK);
            loginB.setForeground(new Color(255,255,255));

            emailL.setBounds(50,30,300,20);
            emailT.setBounds(50,60,300,50);
            passL.setBounds(50,130,300,20);
            passT.setBounds(50,160,300,50);
            signB.setBounds(50,250,120,50);
            loginB.setBounds(200,250,120,50);
    
            ImageIcon img = new ImageIcon("back1.jpg");
            Image newImg = img.getImage();
            Image tempImg = newImg.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
            img = new ImageIcon(tempImg);
            BackImg=new JLabel(" ",img,JLabel.CENTER);
            BackImg.setBounds(0,0,800,800);
            BackImg.add(heading);
            BackImg.add(login);
            BackImg.setLayout(null);
            add(BackImg);


            signB.addActionListener(this);        
            loginB.addActionListener(this);        
            passT.addActionListener(this);    

            Font f=new Font("serif",Font.BOLD,22);
            Font d=new Font("serif",Font.BOLD,25);
            emailL.setFont(f);
            emailT.setFont(d);
            passL.setFont(f);
            passT.setFont(d);
            signB.setFont(f);
            loginB.setFont(f);
            login.add(emailL);
            login.add(emailT);
            login.add(passL);
            login.add(passT);
            login.add(signB);
            login.add(loginB);
            
            setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==signB)
        {
            SignBut obj1=new SignBut(emailT.getText(),passT.getText());
            emailT.setText("");
            passT.setText("");
        }
        else
        {
            LoginBut obj2=new LoginBut(emailT.getText(),passT.getText());
            emailT.setText("");
            passT.setText(""); 
            setVisible(false);          
        }        
    }
    public static void main(String ar[])
    {
        new Main();
    }
}