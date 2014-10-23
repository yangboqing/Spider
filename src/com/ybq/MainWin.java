package com.ybq;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneLayout;

/**
 * Project Name:Spider
 * File Name:MainWin.java
 * Package Name:
 * Date:2014-10-22����5:22:15
 * Copyright (c) 2014, boqing@staff.sina.com.cn All Rights Reserved.
 *
 */

/**
 * ClassName:MainWin <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-10-22 ����5:22:15 <br/>
 * @author   ybq
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class MainWin extends JFrame implements ActionListener, MouseListener{
	private JTextField imgFiled;
    private JTextField urlFiled;
    private JTextArea messageArea;
    private JPopupMenu memu;

    public MainWin(String name) {
        super(name);
        init();

    }

    public JTextArea getMessageArea() {
        return messageArea;
    }

    public void setMessageArea(JTextArea messageArea) {
        this.messageArea = messageArea;
    }

    private void init() {
        setSize(500, 400);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

        // ��Ļλ��
        int locationX = ((int) size.getWidth() / 2) - getWidth() / 2;
        int locationY = ((int) size.getHeight() / 2) - getHeight() / 2;
        ;
        setLocation(locationX, locationY);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // �������
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));

        JPanel top1 = new JPanel();
        JLabel urlLabel = new JLabel("��������ַ:");
        urlFiled = new JTextField();
        urlFiled.setColumns(30);
        urlFiled.addMouseListener(this);

        memu = new JPopupMenu();
        // ճ���˵�
        final JMenuItem paste = new JMenuItem("ճ����ַ");
        paste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_MASK));
        paste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 Clipboard clipboard = getToolkit().getSystemClipboard();
                 
                   Transferable content = clipboard.getContents(this);
                   Object s;
                try {
                    s = content.getTransferData(DataFlavor.stringFlavor);
                    if (s instanceof String) {
                        urlFiled.setText(s.toString());
                        }
                } catch (UnsupportedFlavorException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        memu.add(paste);

        JButton fetch = new JButton("ץȡ");

        // ��top1������Ԫ��
        top1.add(urlLabel);
        top1.add(urlFiled);
        top1.add(fetch);

        final JPanel top2 = new JPanel();
        JLabel imgLabel = new JLabel("ͼƬ�洢Ŀ¼:");
        imgFiled = new JTextField();
        imgFiled.setEditable(false);
        imgFiled.setColumns(29);
        JButton choose = new JButton("ѡ��");

        // ��top2������Ԫ��
        top2.add(imgLabel);
        top2.add(imgFiled);
        top2.add(choose);

        // �򶥲�������Ԫ��
        topPanel.add(top2);
        topPanel.add(top1);

        // �в����
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        messageArea.setEditable(false);
        messageArea.setText("��ӭʹ��");

        final JScrollPane textPane = new JScrollPane(messageArea);
        textPane.setLayout(new ScrollPaneLayout());
        textPane.setAutoscrolls(true);

        centerPanel.add(textPane, "Center");

        add(topPanel, "North");
        add(centerPanel, "Center");

        // ����ѡ��Ŀ¼������
        choose.addActionListener(this);

        // ����ץȡ��ť������
        fetch.addActionListener(this);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // ��ѡ�񡱰�ť������
        if (s.equals("ѡ��")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                imgFiled.setText(chooser.getSelectedFile().getPath());
            }

        } else if (s.equals("ץȡ")) {// ��ץȡ����ť������
            if (imgFiled.getText().length() < 1) {
                messageArea.setText("��ѡ��ͼƬ����Ŀ¼��");
            } else if (urlFiled.getText().length() < 1) {
                messageArea.setText("��������ҳ��ַ��");
            }

            else {
                messageArea.setText("��������ַ...");
                this.update(getGraphics());
                try {
                    Controller controller = new ControllerImpl(this);
                    List<File> fileList = controller.fetchImages(urlFiled
                            .getText(), imgFiled.getText());

                } catch (NullPointerException e1) {
                    e1.printStackTrace();
                    messageArea.setText("��ַ����,��ȷ��ʽ:http://www.lovej.tk");
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                    messageArea.setText("��ַ����,��ȷ��ʽ:http://www.lovej.tk");
                } catch (IOException e1) {
                    e1.printStackTrace();
                    messageArea.setText("��ȡʧ��");
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            this.memu.show(this, urlFiled.getLocation().x, urlFiled.getLocation().y);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
