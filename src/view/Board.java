package view;

import controller.BoardController;
import model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Board {
    private JPanel panel1;
    private JFrame frame;
    private JButton[] buttons = new JButton[9];
    private JLabel label;

    BoardController controller;

    public Board(){
        controller = new BoardController(new GameModel(),this);
        label= new JLabel("Player 1 turn");

    }

    public void startGame(){

        frame = new JFrame("TicTacToe");
        frame.add(panel1);
        panel1.setLayout(new GridLayout(3,3));


        for(int i=0;i<9;i++){

            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].setForeground(Color.blue);
            clickButton(i);
            panel1.add(buttons[i]);
        }
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void clickButton(int position)
    {
        this.buttons[position].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.markTurn(position);
            }
        });
    }

    public void changeSymbol(char symbol,int position){
        this.buttons[position].setText(String.valueOf(symbol));
    }



    public void resetBoard(){
        for(int i =0;i<9;i++){
            this.buttons[i].setText("");
        }
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    public String getButtonText(int position){
        return buttons[position].getText();
    }


}
