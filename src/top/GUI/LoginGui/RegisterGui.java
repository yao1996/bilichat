package top.GUI.LoginGui;

import net.miginfocom.swing.MigLayout;
import top.Action.RegisterInRegisterGui;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

/**
 * Created by YaoKeQi on 2017/4/23.
 * commit on 4/24
 */
public class RegisterGui extends JFrame {
    public static JLabel promptInRegisterGui;
    public RegisterGui(Socket socket) {
        setTitle("注册(゜-゜)つロ 干杯~-");
        setResizable(false);
        setLayout(null);
        setSize(280,320);
        //窗口居中
        Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension d2 = getSize();
        setBounds((d1.width - d2.width)/2,(d1.height - d2.height)/2,d2.width,d2.height);
        //替换Java图标
        Image icon = Toolkit.getDefaultToolkit().getImage("src/top/LoginGui/icon1.png");
        setIconImage(icon);

        promptInRegisterGui = new JLabel();
        promptInRegisterGui.setBounds(100,210,100,30);
        add(promptInRegisterGui);
        JPanel textPanel = textPanel(socket);
        textPanel.setBounds(0,0,280,320);
        add(textPanel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private static JPanel textPanel(Socket socket) {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new MigLayout());

        JLabel username = new JLabel("  请输入用户名：");
        JTextField usernameField = new JTextField(15);
        JLabel nickname = new JLabel("  请输入昵称：");
        JTextField nicknameField = new JTextField(15);
        JLabel password = new JLabel("  请输入密码：");
        JPasswordField passwordField = new JPasswordField(15);
        JLabel repeatPassword = new JLabel("  请重复输入密码：");
        JPasswordField repeatPasswordField = new JPasswordField(15);
        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(new RegisterInRegisterGui(usernameField,nicknameField,passwordField,repeatPasswordField,socket));

        textPanel.add(username,"wrap");
        textPanel.add(usernameField,"wrap,gapleft 65,gaptop 3");
        textPanel.add(nickname,"wrap,gaptop 5");
        textPanel.add(nicknameField,"wrap,gapleft 65,gaptop 3");
        textPanel.add(password,"wrap,gaptop 5");
        textPanel.add(passwordField,"wrap,gapleft 65,gaptop 3");
        textPanel.add(repeatPassword,"wrap,gaptop 5");
        textPanel.add(repeatPasswordField,"wrap,gapleft 65,gaptop 3");
        textPanel.add(registerButton,"gapleft 90,gaptop 30");

        return textPanel;
    }
}
