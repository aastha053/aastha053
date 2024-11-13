import javax.swing.*; //contains JFrame(swing is in java extended package)
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class server extends JFrame implements ActionListener { // for frames JFrame class is used
    JTextField text;
    JPanel TA;
    Box vertical = Box.createVerticalBox();
    public server() {
        setLayout(null);

        JPanel p = new JPanel(); // frame k upr kch krna h toh
        p.setBackground(new Color(8, 45, 90));
        p.setBounds(0,0,450,65); // where to set blue box
        p.setLayout(null);
        add(p); // add frame and blue box

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i1 = i.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel back = new JLabel(i2);
        back.setBounds(10,20,25,25);
        p.add(back);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/photo2.jpg"));
        Image i4 = i3.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel profile = new JLabel(i5);
        profile.setBounds(45,15,35,35);
        p.add(profile);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i7 = i6.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel video = new JLabel(i8);
        video.setBounds(320,20,25,25);
        p.add(video);

        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i10 = i9.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i10);
        JLabel phone = new JLabel(i11);
        phone.setBounds(365,20,25,25);
        p.add(phone);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i13 = i12.getImage().getScaledInstance(7,20,Image.SCALE_DEFAULT);
        ImageIcon i14 = new ImageIcon(i13);
        JLabel ThreeDot = new JLabel(i14);
        ThreeDot.setBounds(410,22,7,20);
        p.add(ThreeDot);

        JLabel name = new JLabel("Aastha");
        name.setBounds(90,-2,100,60);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("San_Serif",Font.BOLD,17));
        p.add(name);

        JLabel status = new JLabel("Active now");
        status.setBounds(90,17,100,60);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("San_Serif",Font.PLAIN,10));
        p.add(status);

        setUndecorated(true);

        TA = new JPanel();
        TA.setBounds(5,70,440,590);
        add(TA);

        text = new JTextField();
        text.setBounds(10,655,350,40);
        text.setFont(new Font("San_Serif",Font.PLAIN,16));
        add(text);

        JButton send = new JButton("Send");
        send.setBounds(360,655,80,40);
        send.setFont(new Font("San_Serif",Font.PLAIN,16));
        send.setForeground(Color.WHITE);
        send.setBackground(new Color(8,45,90));
        send.addActionListener(this);
        add(send);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               System.exit(0);
            }
        });

        setSize(450,700); //frame size
        setLocation(200,50); // where you want to open your frame(by default from left upper corner)
        getContentPane().setBackground(Color.WHITE); // frame background colour

        setVisible(true); // to visible the frame
    }
    public static JPanel FormatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

       JLabel output = new JLabel("<html><p style = \" width : 150px \">" + out + "</p></html>");
        //JLabel output = new JLabel(out);
        output.setForeground(Color.WHITE);
        output.setFont(new Font("San_Serif",Font.PLAIN,16));
        output.setBackground(Color.BLUE);
        output.setOpaque(true);
        panel.add(output);

        output.setBorder(new EmptyBorder(15,15,15,50));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);


        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String out = text.getText();

        JLabel output = new JLabel(out);

        JPanel p2 = FormatLabel(out);

        TA.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);
        Box.createVerticalStrut(10);

        TA.add(vertical,BorderLayout.PAGE_START);
        text.setText("");
        repaint();
        invalidate();
        validate();

    }

    public static void main(String[] args) {
        new server();
    }
}
