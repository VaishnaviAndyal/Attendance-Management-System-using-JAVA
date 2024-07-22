import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.text.html.*;
import java.util.regex.*;

class SemnSbj extends Dialog implements ActionListener
{
    JComboBox semJ;
    List sbjJ;
    JLabel semL,sbjL;
    JButton next,save;
    String sem[]={"semester 1","semester 2","semester 3","semester 4","semester 5","semester 6"};
    String ema;
    int sem1=0,sem2=0,sem3=0,sem4=0,sem5=0,sem6=0;
    SemnSbj(Frame parent,String title,boolean val,String em)
    {
        super(parent,title,val);
        setSize(300,280);
        setResizable(false);
        setLayout(null);
        setBackground(new Color(10, 17, 32));
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
            }
        });
        semL=new JLabel("Select Semester");
        semL.setForeground(Color.WHITE);
        sbjL=new JLabel("Select Subject :");
        sbjL.setForeground(Color.WHITE);
        semL.setForeground(Color.WHITE);
        sbjL.setForeground(Color.WHITE);
        semJ=new JComboBox(sem);
        semJ.addActionListener(this);
        sbjJ=new List(4,true);
        next=new JButton("<html>N<br>E<br>X<br>T</html>");
        save=new JButton("<html>S<br>A<br>V<br>E</html>");
        next.addActionListener(this);
        save.addActionListener(this);
        sbjJ.add("ENG");
        sbjJ.add("BSC");
        sbjJ.add("BMS");
        sbjJ.add("ICT");
        sbjJ.add("EGE");
        sbjJ.add("WPC");

        Font f=new Font("serif",Font.BOLD,14);
        save.setFont(f);
        next.setFont(f);
        // semL.setBounds(30,40,110,20);
        // semJ.setBounds(30,70,100,20);
        // sbjL.setBounds(30,100,100,20);
        // sbjJ.setBounds(130,100,100,100);
        // next.setBounds(140,230,20,70);
        // save.setBounds(30,230,100,25);
        semL.setBounds(30,40,110,20);
        semJ.setBounds(30,70,100,20);
        sbjL.setBounds(30,100,100,20);
        sbjJ.setBounds(30,120,100,100);
        save.setBounds(140,120,40,90);
        next.setBounds(190,120,40,90);

        add(semL);
        add(semJ);
        add(sbjL);
        add(sbjJ);
        add(next);
        add(save);
        ema=em;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==semJ)
        {
            try
            {
                if(semJ.getSelectedItem().equals("semester 1"))
                {
                    sbjJ.removeAll();
                    sbjJ.add("ENG");
                    sbjJ.add("BSC");
                    sbjJ.add("BMS");
                    sbjJ.add("ICT");
                    sbjJ.add("EGE");
                    sbjJ.add("WPC");
                    
                }             
                if(semJ.getSelectedItem().equals("semester 2"))
                {
                    sbjJ.removeAll();
                    sbjJ.add("AMI");
                    sbjJ.add("EEC");
                    sbjJ.add("BEC");
                    sbjJ.add("BCC");
                    sbjJ.add("CPH");
                    sbjJ.add("WPD");
                    sbjJ.add("PCI");
                }
                if(semJ.getSelectedItem().equals("semester 3"))
                {
                    sbjJ.removeAll();
                    sbjJ.add("OOP");
                    sbjJ.add("DSU");
                    sbjJ.add("CGR");
                    sbjJ.add("DMS");
                    sbjJ.add("DTE");
                }             
                if(semJ.getSelectedItem().equals("semester 4"))
                {                 
                    sbjJ.removeAll();
                    sbjJ.add("JPR");
                    sbjJ.add("SEN");
                    sbjJ.add("DCC");
                    sbjJ.add("MIC");
                    sbjJ.add("GAD");
                }             
                if(semJ.getSelectedItem().equals("semester 5"))
                {                 
                    sbjJ.removeAll();
                    sbjJ.add("EST");
                    sbjJ.add("OSY");
                    sbjJ.add("AJP");
                    sbjJ.add("STE");
                    sbjJ.add("CSS");
                    sbjJ.add("ITR");
                    sbjJ.add("CPP");
                }
                if(semJ.getSelectedItem().equals("semester 6"))
                {
                    sbjJ.removeAll();
                    sbjJ.add("MGT");
                    sbjJ.add("PWP");
                    sbjJ.add("MAD");
                    sbjJ.add("ETI");
                    sbjJ.add("WBP");
                    sbjJ.add("EDE");
                    sbjJ.add("CPE");
                }
            }
            catch(Exception f)
            {
                System.out.println(f);
            }
        }
        if(e.getSource()==next)
        {
            setVisible(false);
        }
        if(e.getSource()==save)
        {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
                Statement stmt = conn.createStatement();
                String s[]=sbjJ.getSelectedItems();
                String q;
                int a=s.length;
                
                if(a==0)
                {
                    JOptionPane.showMessageDialog(this,"Select Minimum 1 Subject");
                }
                else if(a==1)
                {
                    if(sem1==0 && semJ.getSelectedItem().equals("semester 1"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 1"+"','"+s[0]+"','','')";
                        stmt.executeUpdate(q);
                        sem1++;
                    }
                    else if(sem2==0 && semJ.getSelectedItem().equals("semester 2"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 2"+"','"+s[0]+"','','')";
                        stmt.executeUpdate(q);
                        sem2++;
                        
                    }
                    else if(sem3==0 && semJ.getSelectedItem().equals("semester 3"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 3"+"','"+s[0]+"','','')";
                        stmt.executeUpdate(q);
                        sem3++;
                    }
                    else if(sem4==0 && semJ.getSelectedItem().equals("semester 4"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 4"+"','"+s[0]+"','','')";
                        stmt.executeUpdate(q);
                        sem4++;
                    }
                    else if(sem5==0 && semJ.getSelectedItem().equals("semester 5"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 5"+"','"+s[0]+"','','')";
                        stmt.executeUpdate(q);
                        sem5++;
                    }
                    else if(sem6==0 && semJ.getSelectedItem().equals("semester 6"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 6"+"','"+s[0]+"','','')";
                        stmt.executeUpdate(q);
                        sem6++;
                    }
                    else
                    {
                        q="update sems set sbj1='"+s[0]+"' where sem='"+semJ.getSelectedItem()+"' AND email='"+ema+"'";
                        stmt.executeUpdate(q);
                    }

                    JOptionPane.showMessageDialog(this,"Inserted Successful");
                }
                else if(a==2)
                {
                    if(sem1==0 && semJ.getSelectedItem().equals("semester 1"))            
                    {
                        q="insert into sems values('"+ema+"','"+"semester 1"+"','"+s[0]+"','"+s[1]+"','')";;
                        stmt.executeUpdate(q);
                        sem1++;
                    }
                    else if(sem2==0 && semJ.getSelectedItem().equals("semester 2"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 2"+"','"+s[0]+"','"+s[1]+"','')";
                        stmt.executeUpdate(q);
                        sem2++;
                    }
                    else if(sem3==0 && semJ.getSelectedItem().equals("semester 3"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 3"+"','"+s[0]+"','"+s[1]+"','')";
                        stmt.executeUpdate(q);
                        sem3++;
                    }
                    else if(sem4==0 && semJ.getSelectedItem().equals("semester 4"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 4"+"','"+s[0]+"','"+s[1]+"','')";
                        stmt.executeUpdate(q);
                        sem4++;
                    }
                    else if(sem5==0 && semJ.getSelectedItem().equals("semester 5"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 5"+"','"+s[0]+"','"+s[1]+"','')";
                        stmt.executeUpdate(q);
                        sem5++;
                    }
                    else if(sem6==0 && semJ.getSelectedItem().equals("semester 6"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 6"+"','"+s[0]+"','"+s[1]+"','')";
                        stmt.executeUpdate(q);
                        sem6++;
                    }
                    else
                    {
                        q="update sems set sbj1='"+s[0]+"',sbj2='"+s[1]+"' where sem='"+semJ.getSelectedItem()+"' AND email='"+ema+"'";
                        stmt.executeUpdate(q);
                    }
                    JOptionPane.showMessageDialog(this,"Inserted Successful");
                }
                else if(a==3)
                {
                    if(sem1==0 && semJ.getSelectedItem().equals("semester 1"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 1"+"','"+s[0]+"','"+s[1]+"','"+s[2]+"')";
                        stmt.executeUpdate(q);
                        sem1++;
                    }
                    else if(sem2==0 && semJ.getSelectedItem().equals("semester 2"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 2"+"','"+s[0]+"','"+s[1]+"','"+s[2]+"')";
                        stmt.executeUpdate(q);
                        sem2++;
                    }
                    else if(sem3==0 && semJ.getSelectedItem().equals("semester 3"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 3"+"','"+s[0]+"','"+s[1]+"','"+s[2]+"')";
                        stmt.executeUpdate(q);
                        sem3++;
                    }
                    else if(sem4==0 && semJ.getSelectedItem().equals("semester 4"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 4"+"','"+s[0]+"','"+s[1]+"','"+s[2]+"')";
                        stmt.executeUpdate(q);
                        sem4++;
                    }
                    else if(sem5==0 && semJ.getSelectedItem().equals("semester 5"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 5"+"','"+s[0]+"','"+s[1]+"','"+s[2]+"')";
                        stmt.executeUpdate(q);
                        sem5++;
                    }
                    else if(sem6==0 && semJ.getSelectedItem().equals("semester 6"))
                    {
                        q="insert into sems values('"+ema+"','"+"semester 6"+"','"+s[0]+"','"+s[1]+"','"+s[2]+"')";
                        stmt.executeUpdate(q);
                        sem6++;
                    }
                    else
                    {
                        q="update sems set sbj1='"+s[0]+"' ,sbj2='"+s[1]+"' ,sbj3='"+s[2]+"'where sem='"+semJ.getSelectedItem()+"' AND email='"+ema+"'";
                        stmt.executeUpdate(q);
                    }
                    JOptionPane.showMessageDialog(this,"Inserted Successful");
                }
                else
                    JOptionPane.showMessageDialog(this,"Select maximum 3 Subjects");
            }           
            catch(Exception u)
            {
                System.out.println(u);
            }             
        }
        
    }

}

public class SignBut extends Frame
{
    public String Valemail,ema,pas;
    int PassSize;
    SignBut(String str1,String str2)
    {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Valemail=str1;
        pas=str2;
        String regex = "^(.+)@(.+)$";  
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Valemail);
        if(matcher.matches()==true)
        {
            if(pas.length()<4)
            {
                JOptionPane.showMessageDialog(this,"Password must be 6 digits");
            }
            else if(pas.length()>6)
            {
                try
                {
                    String q="insert into log values('"+Valemail+"','"+pas+"')";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q);
                    stmt.close();
                }
                catch(Exception e)
                {}
                JOptionPane.showMessageDialog(this,"Sign up Complete");
                SemnSbj ob=new SemnSbj(this,"Select Semester And Subject",true,str1);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Enter Valid Email");   
        }
    }
    // public static void main(String[] args) {
    //     new SignBut("Sahil@gmail.com", "Sahil@123");
    // }

} 