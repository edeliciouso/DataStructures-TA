import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class TicTacToe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] button = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean player1;

    // making the layout and grid for the game
    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(0,0,0));
        textField.setForeground(new Color(255,255,255));
        textField.setFont(new Font("Sans_Serif", Font.BOLD, 60));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(255, 255, 255));

        for(int i = 0; i < 9; i++) {
            button[i] = new JButton();
            buttonPanel.add(button[i]);
            button[i].setFont(new Font("Sans_Serif", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
            button[i].setBackground(Color.white);
        }

        textPanel.add(textField);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        startGame();
    }

    // decide the first player
    public void startGame() {
        int chance = random.nextInt(10);

        if(chance % 2 == 0)
        {
            player1 = true;
            textField.setText("Player X turn");
        }
        else
        {
            player1 = false;
            textField.setText("Player O turn");
        }
    }

    // win conditions
    public void checkWins() {
        if((button[0].getText().equals("X")) && (button[1].getText().equals("X")) && (button[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        else if((button[0].getText().equals("X")) && (button[4].getText().equals("X")) && (button[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        else if((button[0].getText().equals("X")) && (button[3].getText().equals("X")) && (button[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        else if((button[1].getText().equals("X")) && (button[4].getText().equals("X")) && (button[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        else if((button[2].getText().equals("X")) && (button[4].getText().equals("X")) && (button[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }
        else if((button[2].getText().equals("X")) && (button[5].getText().equals("X")) && (button[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        else if((button[3].getText().equals("X")) && (button[4].getText().equals("X")) && (button[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        else if((button[6].getText().equals("X")) && (button[7].getText().equals("X")) && (button[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        else if((button[0].getText().equals("O")) && (button[1].getText().equals("O")) && (button[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        else if((button[0].getText().equals("O")) && (button[3].getText().equals("O")) && (button[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        else if((button[0].getText().equals("O")) && (button[4].getText().equals("O")) && (button[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        else if((button[1].getText().equals("O")) && (button[4].getText().equals("O")) && (button[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        else if((button[2].getText().equals("O")) && (button[4].getText().equals("O")) && (button[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }
        else if((button[2].getText().equals("O")) && (button[5].getText().equals("O")) && (button[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        else if((button[3].getText().equals("O")) && (button[4].getText().equals("O")) && (button[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        else if((button[6].getText().equals("O")) && (button[7].getText().equals("O")) && (button[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        else if(chance_flag == 9 ){
            for(int i = 0; i < 9; i++) {
                button[i].setEnabled(false);
            }
            textField.setText("Game Draw!!");
        }
    }

    // if player X wins
    public void xWins(int x1, int x2, int x3) {

        button[x1].setBackground(Color.green);
        button[x2].setBackground(Color.green);
        button[x3].setBackground(Color.green);

        for(int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }

        textField.setText("Player X wins");
    }

    // if player O wins
    public void oWins(int x1, int x2, int x3) {

        button[x1].setBackground(Color.green);
        button[x2].setBackground(Color.green);
        button[x3].setBackground(Color.green);

        for(int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }

        textField.setText("Player O Wins");
    }

    // performing action after every turn
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++){
            if(e.getSource() == button[i]){
                if(player1) {
                    if (button[i].getText().equals("")){
                        button[i].setForeground(new Color(0, 0, 0));
                        button[i].setText("X");
                        player1 = false;
                        textField.setText("O turn");
                        chance_flag++;
                        checkWins();
                    }
                }
                else {
                    if(button[i].getText().equals("")){
                        button[i].setForeground(new Color(0, 0, 0));
                        button[i].setText("O");
                        player1 = true;
                        textField.setText("X turn");
                        chance_flag++;
                        checkWins();
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new TicTacToe();
    }
}
