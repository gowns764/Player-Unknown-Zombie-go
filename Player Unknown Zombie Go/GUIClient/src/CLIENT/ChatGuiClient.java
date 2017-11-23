package CLIENT;

//chatGuiClient.java

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatGuiClient extends JFrame implements ActionListener, Runnable
{
    static JTextArea textArea = new JTextArea();
    JScrollPane jp = new JScrollPane(textArea);
    JTextField input_Text = new JTextField();
    Socket sk;
    BufferedReader br;
    static PrintWriter pw; // 다른 메서드에서 사용하기 위해 전역변수로

    public static boolean isName = false;

    public ChatGuiClient()
    {
        super("채팅 창"); //프레임 제목표시줄

        textArea.setBackground(Color.white);
        textArea.setEditable(false);// TextArea 입력하기 비활성화

        add(jp, "Center");
        add(input_Text, "South");
        setSize(400, 500);
        setVisible(true);
        input_Text.requestFocus(); // 실행시 커서 놓기, 화면이 보여진 후 작업해야함

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input_Text.addActionListener(this); //이벤트 등록

    }// 생성자 끝

    /**
     * 서버측에 접속기능 담당하는 메소드 작성
     * */

    public static String name = null;

    public void serverConnection()
    {
        try
        {
            sk = new Socket("127.0.0.1", 7000);
            name = JOptionPane.showInputDialog(this, "닉네임을 입력해주세요.", JOptionPane.INFORMATION_MESSAGE);
            isName = true;

            // 읽기준비
            br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            // 쓰기준비
            pw = new PrintWriter(sk.getOutputStream(), true);
            pw.println(name); // 서버측에 전송하기

            new Thread(this).start();

        }
        catch (Exception e)
        {
            System.out.println(e + "Socket 접속 오류");
        }
    }

    public static void main(String[] args)
    {
        new ChatGuiClient().serverConnection(); // 객체생성과 동시에 메서드 호출
        if (isName)
        {
            Player player = new Player();
        }

    }

    // 쓰레드
    /**
     * 서버가 보내오는 데이터를 읽어서 TextArea에 올리기
     */
    @Override
    public void run()
    {
        String data = null;
        try
        {
            while ((data = br.readLine()) != null)
            {
                textArea.append(data + "\n");

                //textArea박스의 스크롤바의 위치를 입력된 Text길이 만큼 내리기
                textArea.setCaretPosition(textArea.getText().length());
            }
        }
        catch (Exception e)
        {
            System.out.println(e + "--> Client run fail");
        }
}

    // 엔터쳤을때 이벤트 발생
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String data = input_Text.getText();
        pw.println(data); // 서버측에 전송
        input_Text.setText("");
    }
}