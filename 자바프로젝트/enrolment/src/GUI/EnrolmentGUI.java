package GUI;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 

public class EnrolmentGUI extends JFrame{
    public EnrolmentGUI() {
    	JPanel p = new JPanel();
    	Font fonttitle=new Font("12롯데마트드림Bold",Font.BOLD,20);
        Font fontbutton=new Font("12롯데마트드림Medium",Font.BOLD,15);
    	JLabel title= new JLabel("★미림여자정보과학고등학교 수강신청★");
        JButton showlist = new JButton("수업목록보기");
        JButton apply = new JButton("수강신청");
        JButton showmy = new JButton("내 수강목록 보기");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
    	Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\바탕 화면\\\\미림로고.png");
    	
        
    	title.setFont(fonttitle);
		add(title);
        showlist.setBackground(new Color(62,157,55));
        showlist.setForeground(Color.WHITE);
        showlist.setBorderPainted(false);
        showlist.setFocusPainted(false);
        showlist.setFont(fontbutton);
        add(showlist);
        apply.setBackground(new Color(62,157,55));
        apply.setForeground(Color.WHITE);
		apply.setBorderPainted(false);
		apply.setFocusPainted(false);
		apply.setFont(fontbutton);
        add(apply);
        showmy.setBackground(new Color(62,157,55));
        showmy.setForeground(Color.WHITE);
        showmy.setBorderPainted(false);
        showmy.setFocusPainted(false);
        showmy.setFont(fontbutton);
        add(showmy);
        title.setBounds(16,50,400,25);
        showlist.setBounds(110, 130, 150, 30);
        apply.setBounds(110, 180, 150, 30); 
        showmy.setBounds(110, 230, 150, 30); 
        add(p);
        
        setSize(400,400);
        setTitle("수강신청");
        setIconImage(img);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        showlist.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent T) {
    			ShowListGUI slg=new ShowListGUI();	
    		}
    	});
        showmy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowmyGUI smg=new ShowmyGUI();
			}
        	
        });
        apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ApplyGUI a=new ApplyGUI();
			}
        });
}
    public static void main(String args[]) {
    	new EnrolmentGUI();
    }
    }