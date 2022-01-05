package ip_address_finder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;                 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IP_Address extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JLabel l;                       
    JTextField TextF,TextF2;       
    JButton btn,btn2;             
    
    // GUI
    IP_Address()
    {
        super("IP Finder -19SW24");          
       
        // label
        l = new JLabel("Enter URL:");       
        l.setBounds(100,120,180,45);       
        
        //TextField
        TextF = new JTextField();
        TextF.setBounds(100,150,300,50);  
        TextF.setForeground(Color.WHITE);
        TextF.setBackground(Color.BLACK);
        
        //creating Button
        btn = new JButton("Find IP Address");
        btn.setBounds(100,220,125,50);    
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.BLACK);
       
        // implement the ActionListener on the button
        btn.addActionListener(this);


        //adding textField, label and button in frame
        add(l);                                      //add label
        add(TextF);                                 // add textField
        add(btn);                                  //adding button


        //Frame visibility setting
        setSize(600,600);                          // set the Frame Size width and height
        setLayout(null);                          //hide default layout of frame
        setVisible(true);                        //set the visisbility of frame
        setBackground(Color.GRAY);               //set background color of frame
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String url=TextF.getText();  // taking URL in textfield
        try
        {
             InetAddress iname = InetAddress.getByName(url);  
            String ipadd = iname.getHostAddress();
            JOptionPane.showMessageDialog(this,ipadd);
        }
        catch(UnknownHostException excpt)
        {
            JOptionPane.showMessageDialog( this, excpt.getMessage() );
        }
    }


    public static void main(String args[])
    {
    	IP_Address obj = new IP_Address();
    }
}