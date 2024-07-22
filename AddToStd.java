import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class AddToStd extends Frame implements ActionListener
{
    TextField nameT,rollnoT;
    Label nameL,rollnoL;
    Button addstd,back;
    String tabname;
    int atab;
    AddToStd(String tablename)
    {
        setSize(300,300);
        setLayout(null);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        tabname=tablename;
        nameL=new Label("Enter Name :");
        rollnoL=new Label("Enter Roll No:");
        nameT=new TextField(20);
        rollnoT=new TextField(20);
        rollnoT.addActionListener(this);
        addstd=new Button("Add a Students");
        back=new Button("Back");
        addstd.addActionListener(this);
        back.addActionListener(this);
        addComponentListener(new ComponentAdapter()
        {
            
            public void componentResized(ComponentEvent e) 
            {
                rollnoL.setBounds(50,50,80,20);
                rollnoT.setBounds(140,50,100,20);
                nameL.setBounds(50,80,80,20);
                nameT.setBounds(140,80,100,20);
                addstd.setBounds(140,200,100,30);
                back.setBounds(140,250,100,30);
                
                add(nameL);
                add(addstd);
                add(nameT);
                add(rollnoL);
                add(back);
                add(rollnoT);
            }
        });
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addstd || e.getSource()==rollnoT)
        {
            try
            {
                String q="insert into "+tabname+" values ('"+rollnoT.getText()+"','"+nameT.getText()+"')";
                //System.out.println(q);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(this,"Student added Successful");
            }
            catch(Exception b)
            {
                System.out.println(b);
            }    
            
            rollnoT.setText("");
            nameT.setText("");
        }
        if(e.getSource()==back)
        {
            setVisible(false);
            atab=0;
        }
    }

    // public static void main(String[] args) {
    //     AddToStd obj =new AddToStd("abcdsem1ict");   
    // }
}
