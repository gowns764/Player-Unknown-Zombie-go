package SERVER;

//ChatGuiServer.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 멀티 채팅을 위한 서버 구성
 */
public class ChatGuiServer extends JFrame implements ActionListener, Runnable
{
    /**
     *  필요한 Field 선언
     */
    JTextArea textArea = new JTextArea();
    JScrollPane jp = new JScrollPane(textArea);
    JTextField input_Text = new JTextField();

    ServerSocket server;
    Socket sk;
    ArrayList<ServerThread> list = new ArrayList<ServerThread>();
    BufferedReader br;
    PrintWriter pw;

    /*
     * ServerSocket을 생성하여 client 접속 대할 생성자
     */
    public ChatGuiServer()
    { //생성자
        super("Chat GUI Server");
        textArea.setBackground(Color.WHITE);
        textArea.setEditable(false);

        add(jp, "Center");
        add(input_Text, "South");
        setSize(400, 500);
        setVisible(true);
        input_Text.requestFocus(); // 실행시 커서 놓기, 화면이 보여진 후 작업해야함

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        input_Text.addActionListener(this); //이벤트 등록

        try
        {
            server = new ServerSocket(7000);
            while(true)
            {
                textArea.append("\nClient접속이 대기중입니다.\n");
                sk = server.accept(); // 클라이언트 접속 대기중
                textArea.append(sk.getInetAddress()+"의 주소가 연결되었습니다. \n");

                //접속된 클라이언트를 스레드로 만들어 ArrayList에 추가
                ServerThread st = new ServerThread(this);
                addThread(st); //ArrayList 에 추가하기
                st.start(); //쓰레드 시작하기
                break;
            } //while문 끝
        }
        catch (IOException e)
        {
            textArea.append(e + " -> ServerSocket fil\n");
        }
    }//생성자 끝

    public void clientConnection()
    {
        try
        {
            //sk = new Socket("127.0.0.1", 7000);
            String name = "운영자";

            // 읽기준비
            br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            // 쓰기준비
            pw = new PrintWriter(sk.getOutputStream(), true);
            pw.println(name); // 서버측에 전송하기

            new Thread(this).start();

        }
        catch (Exception e)
        {
            textArea.append(e + "Socket 접속 오류");
        }
    }

    /**
     * 접속된 클라이언트를 저장하기
     */
    public void addThread(ServerThread st)
    {
        list.add(st);  //추가
    }

    /**
     * 접속이 끊긴 클라이언트를 ArrayList에 제거하기
     **/
    public void removeThread(ServerThread st)
    {
        list.remove(st); //제거
    }

    /**
     * 접속된 각각의 클라이언트에게 데이터 전송하기.
     */
    public void broadCast(String message)
    {

        for(ServerThread st : list){
            textArea.append(message+"\n");
        }
    }


    public static void main(String[] args)
    {
        new ChatGuiServer().clientConnection();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String data = input_Text.getText();
        pw.println(data); // 서버측에 전송
        input_Text.setText("");
    }

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
            textArea.append(e + "--> Client run fail");
        }
    }
} //클래스 끝

//////////////////////////////////////////////////////////////////////

//각각의 클라이언트를 Trhrea로 구현
class ServerThread extends Thread
{

    ChatGuiServer server;
    PrintWriter pw;
    String name;
    public ServerThread(ChatGuiServer server)
    {
        this.server = server;
    }
    @Override
    public void run()
    {
        try
        {
            //읽기 준비
            BufferedReader br= new BufferedReader
                    (new InputStreamReader(server.sk.getInputStream()));

            //쓰기 준비
            pw = new PrintWriter(server.sk.getOutputStream(),true);

            name = br.readLine(); //대화명 읽기

            server.broadCast("["+name+"]님 입장하셨습니다.");

            String data= null;
            while((data = br.readLine()) != null)
            {
                server.broadCast("[ "+name+" ] "+ data);
            }
        }
        catch (Exception e)
        {
            //현재 쓰레드를 ArrayList에 제거한다.
            server.removeThread(this);
            server.broadCast("[ "+name+" ] 님이 퇴장하셨습니다.");
            System.out.println
                    (server.sk.getInetAddress()+"주소의 ["+name+" ] 님이 퇴장하셨습니다.");
            System.out.println(e + "----> ");
        }
    }
}