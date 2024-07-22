import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Attend extends Frame implements ActionListener
{
    JTextField dateT,rollnoT;
    JLabel dateL,rollnoL;
    JButton insert,addstd;
    JPanel p;
    int row=0;
    JScrollPane js;
    JTable jb;
    Connection conn;
    //Statement stmt;
    PreparedStatement ps;
    int tab=0;
    String tablename;
    Attend(String em,String se,String sb,String pas)
    {
        setSize(1050,730);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(60,60,60));
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e) {
                //System.exit(0);
                setVisible(false);
                LoginBut obj2=new LoginBut(em,pas);
            }
        });

        tablename=em.substring(0,4)+se.substring(0,3)+se.substring(se.length()-1)+sb;

        dateL=new JLabel("Enter Date :");
        rollnoL=new JLabel("Enter Absent Roll No:");
        dateL.setForeground(Color.WHITE);
        rollnoL.setForeground(Color.WHITE);
        dateT=new JTextField();
        rollnoT=new JTextField(30);
        insert=new JButton("Insert");
        addstd=new JButton("Add To Students");
        p=new JPanel();
        p.setLayout(new BorderLayout());
        jb=new JTable();
        // jb.setBackground(Color.YELLOW);
        //js.setBackground(Color.YELLOW);
        jb.setBackground(new Color(205,165,255,75));
        js=new JScrollPane(jb);
        p.add(js);
        insert.addActionListener(this);
        addstd.addActionListener(this);
        rollnoT.addActionListener(this);

        try
        {
            //create table if not exists demo(name varchar(10));
            String crtab="create table if not exists "+tablename+"(roll_no int,name varchar(30))";
            String q="select * from "+tablename+" ";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
            ps = conn.prepareStatement(crtab);
            ps.executeUpdate();

            ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            DefaultTableModel model=(DefaultTableModel) jb.getModel();
            int cols=rsmd.getColumnCount();
            String[] ColName=new String[cols];
            for(int i=0;i<cols;i++)
                ColName[i]=rsmd.getColumnName(i+1);
            model.setColumnIdentifiers(ColName);
            String coldata[];
            coldata =new String[cols];
            int x=1;
            while(rs.next())
            {
                x=1;
                for(int g=0;g<cols;g++)
                {
                    coldata[g]=rs.getString(x);
                    x++;
                }
                model.addRow(coldata);
                row++;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        Font f=new Font("serif",Font.BOLD,22);
        dateL.setFont(f);
        dateT.setFont(f);
        rollnoL.setFont(f);
        rollnoT.setFont(f);
        addstd.setFont(f);
        insert.setFont(f);
        dateL.setBounds(50,50,120,40);
        dateT.setBounds(180,50,200,40);
        rollnoL.setBounds(400,50,230,40);
        rollnoT.setBounds(630,50,300,40);
        insert.setBounds(900,120,100,50);
        addstd.setBounds(30,120,200,50);
        p.setBounds(30, 200,1000,500);
        p.setBackground(Color.RED);
        
        add(p);
        add(dateL);
        add(addstd);
        add(dateT);
        add(rollnoL);
        add(rollnoT);
        add(insert);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addstd)
        {
            AddToStd obj=new AddToStd(tablename); 
            remove(p);
            p=new JPanel();
            p.setLayout(new BorderLayout());
            jb=new JTable();
            js=new JScrollPane(jb);
            p.add(js);   
            try
            {
                //create table if not exists demo(name varchar(10));
                String q="select * from "+tablename+" ";
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
                ps = conn.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsmd=rs.getMetaData();
                DefaultTableModel model=(DefaultTableModel) jb.getModel();
                int cols=rsmd.getColumnCount();
                String[] ColName=new String[cols];
                for(int i=0;i<cols;i++)
                    ColName[i]=rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(ColName);
                String coldata[];
                coldata =new String[cols];
                int x=1;
                while(rs.next())
                {
                    x=1;
                    for(int g=0;g<cols;g++)
                    {
                        coldata[g]=rs.getString(x);
                        x++;
                    }
                    model.addRow(coldata);
                    row++;
                }
            }
            catch(Exception a)
            {
                System.out.println(a);
            }

            p.setBounds(30, 200,1000,500);
            add(p);    
            setVisible(true);    
        }
        if(e.getSource()==rollnoT || e.getSource()==insert)
        {
            remove(p);
            p=new JPanel();
            p.setLayout(new BorderLayout());
            jb=new JTable();
            js=new JScrollPane(jb);
            p.add(js);
            try{               
                String date=dateT.getText();
                String q="alter table "+tablename+" add "+date+" varchar(20) DEFAULT 'present';";
                //String q="alter table "+tablename+" add Today varchar(20);";
                //System.out.println(q);
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
                ps = conn.prepareStatement(q);
                ps.executeUpdate();
                //System.out.println("ok");
                String str=rollnoT.getText();
                String[] rollnos = str.split(" ");
                int rollnu[],rollnoa[];
                int p=0;
                rollnu=new int[rollnos.length];
                rollnoa=new int[row];
                for(int i=0;i<rollnos.length;i++)
                {
                    rollnu[i]=Integer.parseInt(rollnos[i]);
                    System.out.println(rollnu[i]);
                }
                String a="select roll_no from "+tablename+" ";
                ps = conn.prepareStatement(a);
                ResultSet rs = ps.executeQuery();
                int b=0;
                while(rs.next())
                {
                    rollnoa[b]=rs.getInt(1);
                    b++;
                    System.out.println(rollnoa[b]);
                }

                for(int j=0;j<rollnoa.length;j++)
                {
                    for(int i=0;i<rollnu.length;i++)
                    {
                        if(rollnoa[j]==rollnu[i])
                        {
                            //ab
                            String d="update "+tablename+" set "+dateT.getText()+"='absent' where roll_no="+rollnu[i];
                            ps = conn.prepareStatement(d);
                            System.out.println(rollnu[i]);
                            ps.executeUpdate(d);
                        }
                    } 
                }
            }
            catch(Exception d)
            {
                System.out.println(d);
            }
            
            try
            {
                //create table if not exists demo(name varchar(10));
                String q="select * from "+tablename+" ";
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_test","root","N@vi0404");
                ps = conn.prepareStatement(q);
                ResultSet rs = ps.executeQuery();
                ResultSetMetaData rsmd=rs.getMetaData();
                DefaultTableModel model=(DefaultTableModel) jb.getModel();
                int cols=rsmd.getColumnCount();
                String[] ColName=new String[cols];
                for(int i=0;i<cols;i++)
                    ColName[i]=rsmd.getColumnName(i+1);
                model.setColumnIdentifiers(ColName);
                String coldata[];
                coldata =new String[cols];
                int x=1;
                while(rs.next())
                {
                    x=1;
                    for(int g=0;g<cols;g++)
                    {
                        coldata[g]=rs.getString(x);
                        x++;
                    }
                    model.addRow(coldata);
                    row++;
                }
            }
            catch(Exception a)
            {
                System.out.println(a);
            }

            p.setBounds(30, 200,1000,500);
            add(p);    
            setVisible(true);        
        }
    }

    // public static void main(String[] args) {
    //     new Attend("djtrigule@gmail.com", "semester 5", "ajp","djt2022.23");
    // }
}