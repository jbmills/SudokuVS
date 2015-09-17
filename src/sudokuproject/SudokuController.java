/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Brandon
 */
public class SudokuController {

    private SudokuModel theModel;
    private SudokuView theView;
    private SudokuButton tempButton;
    private GameGridButton TempGameButton;
    private GameGridButton currentGameButton;
    //private int [][] sudoku = new int[9][9];

    public SudokuController(SudokuView theView, SudokuModel theModel) {
        this.theModel = theModel;
        this.theView = theView;

        tempButton = new SudokuButton();
        TempGameButton = new GameGridButton();
        currentGameButton = new GameGridButton();
        tempButton.setInactive();
//        theView.setupGame(theModel.getNewGame(1));
        theView.addGameListener(new GameListener());
        theView.addButtonListener(new ButtonListener());
        theView.addNewGameListener(new NewGameListener());
        theView.addResetPuzzleListener(new ResetGameListener());
        theView.addClickOutListener(new OutsideListener());
        theView.addSolvedPuzzleListener(new SolvedPuzzleListener());
        //this.theView.addOutsideListener(new OutsideListener());
    }

    class ResetGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tempButton.setInactive();
            tempButton.setBackground(tempButton.getColor());
            TempGameButton.setInactive();
            TempGameButton.setBackground(TempGameButton.getColor());
            theView.clearGame();
            theView.setupGame(theModel.getResetGame());
        }
    }

    class SolvedPuzzleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            tempButton.setInactive();
            tempButton.setBackground(tempButton.getColor());
            TempGameButton.setInactive();
            TempGameButton.setBackground(TempGameButton.getColor());
            int [][]sudoku = new int[9][9];
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sudoku[i][j] = theView.gameGridButtons[i][j].getButtonAnswer();
                    //System.out.println(sudoku[i][j]);
                }
            }
            boolean isSolved = theModel.isSolved2(sudoku);
            if (isSolved) {
                JOptionPane.showMessageDialog(theView, "Puzzle Solved Correctly!", "You Won", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(theView, "Puzzle Not Solved Correctly!", "You Lost", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class GameListener implements ActionListener {
        public void actionPerformed(ActionEvent GL) {
            String command = GL.getActionCommand();
            Object temp = GL.getSource();
            //Button from array is active and the game grid was clicked
            if(temp instanceof GameGridButton && tempButton.isActive()){
                TempGameButton = (GameGridButton)temp;
                //standard placement of button
                if(TempGameButton.getText() == ""){
                    TempGameButton.setText(tempButton.getText());
                    TempGameButton.setButtonAnswer(Integer.parseInt(tempButton.getText()));
                    tempButton.setInactive();
                    tempButton.decreaseCount();
                    tempButton.setBackground(tempButton.getColor());
                }
                //if the Game Button currently has a number in it
                else {
                    Integer i = Integer.parseInt(TempGameButton.getText());
                    TempGameButton.setText(tempButton.getText());
                    TempGameButton.setButtonAnswer(Integer.parseInt(tempButton.getText()));
                    tempButton.setInactive();
                    tempButton.decreaseCount();
                    tempButton.setBackground(tempButton.getColor());
                    tempButton = theView.getArrayButton(i);
                    tempButton.increaseCount();
                }

            }
            //Button from array is not active
            else if (temp instanceof GameGridButton && !tempButton.isActive()) {
                currentGameButton = (GameGridButton)temp;
                //if the text from the game button has a number and the
                if(currentGameButton.getText() != "" && !TempGameButton.isActive()) {
                    TempGameButton = (GameGridButton)temp;
                    //make sure the current button is not empty
                    TempGameButton.setActive();
                    TempGameButton.setBackground(Color.cyan);

                }
                //if the previous temp game button is not empty and is active
                else if (currentGameButton.getText() == "" && TempGameButton.isActive()) {
                    String gameButtonLabel = TempGameButton.getText();
                    tempButton = theView.getArrayButton(Integer.parseInt(gameButtonLabel));
                    //tempButton.increaseCount();
                    TempGameButton.setInactive();
                    TempGameButton.setBackground(TempGameButton.getColor());
                    TempGameButton.setText("");
                    TempGameButton.setButtonAnswer(0);
                    TempGameButton = (GameGridButton)temp;
                    TempGameButton.setText(gameButtonLabel);
                    TempGameButton.setButtonAnswer(Integer.parseInt(gameButtonLabel));


                }
                else if (currentGameButton.getText() != "" && currentGameButton != TempGameButton) {
                    String gameButtonLabel = TempGameButton.getText();
                    TempGameButton.setInactive();
                    TempGameButton.setBackground(TempGameButton.getColor());
                    TempGameButton.setText("");
                    TempGameButton.setButtonAnswer(0);
                    TempGameButton = (GameGridButton)temp;
                    if(TempGameButton.getText() != "") {
                        String currentGameButtonLabel = TempGameButton.getText();
                        tempButton = theView.getArrayButton(Integer.parseInt(currentGameButtonLabel));
                        tempButton.increaseCount();
                        TempGameButton.setText(gameButtonLabel);
                        TempGameButton.setButtonAnswer(Integer.parseInt(gameButtonLabel));
                    }
                }
                else {
                    TempGameButton.setInactive();
                    TempGameButton.setBackground(TempGameButton.getColor());
                }
            }
            //System.out.println("The " + command + " for this button.");
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent BL) {
            String command = BL.getActionCommand();
            //System.out.println("The " + command + " for this button.");
            Object temp = BL.getSource(); //temporary object for the source of button
            //If a button from the button array is not active and Game Button is not active
            if(temp instanceof SudokuButton && !tempButton.isActive() && !TempGameButton.isActive()){
                tempButton = (SudokuButton)temp; //set the button active
                tempButton.setBackground(Color.CYAN);
                tempButton.setActive();
                return;
            }
            //If a button from the button array is not active and a Game Button is active
            else if(temp instanceof SudokuButton && !tempButton.isActive() && TempGameButton.isActive()) {
                Integer i = TempGameButton.getButtonAnswer();
                TempGameButton.setText("");
                TempGameButton.setButtonAnswer(0);
                TempGameButton.setInactive();
                TempGameButton.setBackground(TempGameButton.getColor());
                tempButton = theView.getArrayButton(i);
                tempButton.increaseCount();
            }
            //If a button from the button array is active
            else if (temp instanceof SudokuButton && tempButton.isActive()) {
                tempButton.setInactive(); // set the active button inactive
                tempButton.setBackground(tempButton.getColor());
                if (tempButton != (SudokuButton) temp) {
                    tempButton = (SudokuButton)temp; //get the new button and set it active
                    tempButton.setBackground(Color.CYAN);
                    tempButton.setActive();
                }
            }
        }
    }

    /**********************************************************
     * This is the class that implements the new game listener
     **********************************************************/
    class NewGameListener implements ActionListener {
        int gameCount = 1;
        public void actionPerformed(ActionEvent e){
//           theView.dispose();
//           theView = new SudokuView();
            tempButton.setInactive();
            tempButton.setBackground(tempButton.getColor());
            TempGameButton.setInactive();
            TempGameButton.setBackground(TempGameButton.getColor());
            theView.clearGame();
            theView.setupGame(theModel.getNewGame(gameCount));
            gameCount++;
            if (gameCount > 2) {
                gameCount = 1;
            }


//           theView.setVisible(true);
        }
    }
    /*************************************************************
     * This is the listener for the panels that can determine    *
     * if a click was made outside of the game grid area and if  *
     * a game grid button is selected.  If it is it places the   *
     * item off of the board and back into the array of buttons  *
     *************************************************************/
    class OutsideListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent OL) {
            //System.out.println("mouse clicked");
            if(TempGameButton.isActive()) {
                Integer i = TempGameButton.getButtonAnswer();
                TempGameButton.setText("");
                TempGameButton.setButtonAnswer(0);
                TempGameButton.setInactive();
                TempGameButton.setBackground(TempGameButton.getColor());
                tempButton = theView.getArrayButton(i);
                tempButton.increaseCount();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent me) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
