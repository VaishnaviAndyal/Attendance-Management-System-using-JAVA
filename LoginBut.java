import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class sbjandsem extends Dialog implements ActionListener
{
    JComboBox semJ,sbjJ;
    JLabel semL,sbjL;
    JButton next;
    ResultSet rs;
    String s1[],s2[],s3[],em[],sbjs[],se[],sem[];
    String emails,ps;
    
    sbjandsem(Frame parent,String title,boolean val,String ai,String pa)
    {
        super(parent,title,val);
        emails=ai;
        ps=pa;
        setSize(300,300);
        setLayout(null);
        setBackground(new Color(10, 17, 32));
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
                Main ab=new Main();
            }
        });
        s1 =new String[10];
        s2 =new String[10];
        s3 =new String[10];
        em =new String[10];
        sbjs =new String[10];
        se =new String[10];
        sem =new String[10];
        try
        {
            String q="select * from sems where email='"+emails+"'";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            int i=0;
            while(rs.next()) 
            {
                se[i]=rs.getString(2);
                s1[i]=rs.getString(3);
                s2[i]=rs.getString(4);
                s3[i]=rs.getString(5);
                i++;
            }
        }
        catch(Exception e)
        {
            //System.out.println(e);
        }        
        semL=new JLabel("Select Semester :");
        semL.setForeground(Color.WHITE);
        sbjL=new JLabel("Select Subject :");
        sbjL.setForeground(Color.WHITE);
        semJ=new JComboBox();
        for(int z=0;z<se.length;z++)
            semJ.addItem(se[z]);
        sbjJ=new JComboBox();
        next=new JButton("Next ");
        next.addActionListener(this);
        semJ.addActionListener(this);
        semL.setBounds(70,70,100,20);
        semJ.setBounds(170,70,100,20);
        sbjL.setBounds(70,120,100,20);
        sbjJ.setBounds(170,120,100,20);
        next.setBounds(190,260,100,20);
        add(semL);
        add(semJ);
        add(sbjL);
        add(sbjJ);
        add(next);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) 
    {        
        if(e.getSource()==semJ)
        {            
          
            //sbjJ.removeAll();
            if(semJ.getSelectedItem().equals("semester 1"))
            {
                String op;
                sbjJ.removeAllItems();
                for(int n=0;n<se.length;n++)
                {
                    if(se[n].equals("semester 1"))
                    {
                        op=s1[n];
                        sbjJ.addItem(op);
                        op=s2[n];
                        sbjJ.addItem(op);
                        op=s3[n];
                        sbjJ.addItem(op);
                        break;
                    }
                }
            }
            if(semJ.getSelectedItem().equals("semester 2"))
            {
                String op;
                sbjJ.removeAllItems();
                for(int n=0;n<se.length;n++)
                {
                    if(se[n].equals("semester 2"))
                    {
                        op=s1[n];
                        sbjJ.addItem(op);
                        op=s2[n];
                        sbjJ.addItem(op);
                        op=s3[n];
                        sbjJ.addItem(op);
                        break;
                    }
                }
            }
            if(semJ.getSelectedItem().equals("semester 3"))
            {
                String op;
                sbjJ.removeAllItems();
                for(int n=0;n<se.length;n++)
                {
                    if(se[n].equals("semester 3"))
                    {
                        op=s1[n];
                        sbjJ.addItem(op);
                        op=s2[n];
                        sbjJ.addItem(op);
                        op=s3[n];
                        sbjJ.addItem(op);
                        break;
                    }
                }
            }
            if(semJ.getSelectedItem().equals("semester 4"))
            {
                String op;
                sbjJ.removeAllItems();
                for(int n=0;n<se.length;n++)
                {
                    if(se[n].equals("semester 4"))
                    {
                        op=s1[n];
                        sbjJ.addItem(op);
                        op=s2[n];
                        sbjJ.addItem(op);
                        op=s3[n];
                        sbjJ.addItem(op);
                        break;
                    }
                }
            }
            if(semJ.getSelectedItem().equals("semester 5"))
            {
                String op;
                sbjJ.removeAllItems();
                for(int n=0;n<se.length;n++)
                {
                    if(se[n].equals("semester 5"))
                    {
                        op=s1[n];
                        sbjJ.addItem(op);
                        op=s2[n];
                        sbjJ.addItem(op);
                        op=s3[n];
                        sbjJ.addItem(op);
                        break;
                    }
                }
            }
            if(semJ.getSelectedItem().equals("semester 6"))
            {
                String op;
                sbjJ.removeAllItems();
                for(int n=0;n<se.length;n++)
                {
                    if(se[n].equals("semester 6"))
                    {
                        op=s1[n];
                        sbjJ.addItem(op);
                        op=s2[n];
                        sbjJ.addItem(op);
                        op=s3[n];
                        sbjJ.addItem(op);
                        break;
                    }
                }
            }
        }
        if(e.getSource()==next)
        {
            setVisible(false);
            String op=semJ.getSelectedItem().toString();
            String po=sbjJ.getSelectedItem().toString();
            Attend obj=new Attend(emails,op,po,ps);
        }
    }
}
public class LoginBut extends Frame
{
    public String ema,pas;
    int PassSize;
    Boolean em,ps;
    LoginBut(String str1,String str2)
    {
        ema=str1;
        pas=str2;
        try{
            String q="select * from log";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){
                if(ema.equals(rs.getString(1)))
                {
                    em=true;
                    if(pas.equals(rs.getString(2)))
                    {  
                        em=true;
                        ps=true;
                        break;
                    }
                    else
                    {
                        em=true;
                        ps=false;
                        break;
                    }
                }
                else
                {
                    em=false;
                }
            }
            if(em==true)
            {
                if(ps==true)
                {
                    JOptionPane.showMessageDialog(this,"Login Successful");
                    sbjandsem ob=new sbjandsem(this,"Select Semester And Subject",true,str1,str2);
                }
                else
                    JOptionPane.showMessageDialog(this,"Wrong Password");
            }
            else
                JOptionPane.showMessageDialog(this,"Incorrect Email OR Password ");
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
} 