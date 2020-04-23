package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

		public class start extends JFrame{
			public start(){
				JPanel p = new JPanel();
				JLabel mirim=new JLabel(new ImageIcon("C:\\Users\\s2019\\OneDrive\\바탕 화면\\미림로고.png"));
				Font fonttitle=new Font("12롯데마트드림Bold",Font.BOLD,30);
				Font fontbutton=new Font("12롯데마트드림Medium",Font.BOLD,15);
				JLabel title=new JLabel("미림여자정보과학고등학교");
				JButton Login = new JButton("로그인"); // 버튼 초기화
				JButton Join = new JButton("회원가입"); // 버튼 초기화
				Toolkit toolkit = Toolkit.getDefaultToolkit();
		    	Image img = toolkit.getImage("C:\\\\Users\\\\s2019\\\\OneDrive\\\\바탕 화면\\\\미림로고.png");
				
		    	add(mirim);
				title.setFont(fonttitle);
				add(title);
				Join.setBackground(new Color(62,157,55));
				Join.setForeground(Color.WHITE);
				Join.setBorderPainted(false);
				Join.setFocusPainted(false);
				Join.setFont(fontbutton);
				add(Join);
				Login.setBackground(new Color(62,157,55));
				Login.setForeground(Color.white);
				Login.setBorderPainted(false);
				Login.setFocusPainted(false);
				Login.setFont(fontbutton);
				add(Login);
				mirim.setBounds(90,0,280,280);
				title.setBounds(80,50,500,500);
				Join.setBounds(100,350,90,40);
				Login.setBounds(280,350,90,40);
				add(p);
				
				setSize(500,500); // 윈도우의 크기 가로x세로
				setTitle("미림여자정보과학고등학교 수강신청페이지");
				setVisible(true); // 창을 보여줄떄 true, 숨길때 false
				setIconImage(img);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼을 눌렀을때 종료
				
				Join.addActionListener((ActionListener) new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						JoinGUI j=new JoinGUI();
					}
				});
			
				Login.addActionListener((ActionListener) new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						LoginGUI lv=new LoginGUI();	
				}
			});
		}
			public static void main(String[] args){
				start s=new start();
			} 
	}
