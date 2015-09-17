/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Brandon
 */
public class SudokuView extends JFrame {
    private static Insets insets = new Insets(0, 0, 0, 0);
    private static Insets wideInsets = new Insets(1, 1, 1, 1);
    private SudokuButton selectableButtons;
    private GameGridButton newGameButton;
    private SudokuButton [] sudokuArrayButtons = new SudokuButton [9];
    protected GameGridButton [][] gameGridButtons = new GameGridButton[9][9];
    private JButton resetGameButton = new JButton("Reset Game");
    private JButton newGame = new JButton("New Game");
    private JButton solvePuzzleButton = new JButton("Solve Puzzle");
    private JPanel smallSquareGamePanels;
    private JPanel mainPanel;
    private JPanel selectableButtonPanel;
    //public ClickOutOfGameAreaPanel mainPanel;
    private int [][] sudoku = new int [9][9];
//    private int numberOf_1 = 9, numberOf_2 = 9, numberOf_3 = 9, numberOf_4 = 9;
//    private int numberOf_5 = 9, numberOf_6 = 9, numberOf_7 = 9, numberOf_8 = 9;
//    private int numberOf_9 = 9;
    //ActionListener listenForThisButton;

    SudokuView(){
        this.setTitle("Sudoku Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        //mainPanel = new ClickOutOfGameAreaPanel();
        mainPanel = new JPanel();
        //ClickOutOfGameAreaPanel selectableButtonPanel = new ClickOutOfGameAreaPanel();
        selectableButtonPanel = new JPanel();
        //LayoutManager SelectableButtonLayout = new BoxLayout(selectableButtonPanel, BoxLayout.Y_AXIS);
        //selectableButtonPanel.setLayout(SelectableButtonLayout);
        selectableButtonPanel.setLayout(new GridBagLayout());
        //selectableButtonPanel.setLayout(new GridLayout(0, 1));
        //selectableButtonPanel.setLayout(new GridLayout(9, 1, 0, 1));
        JPanel clickablePanel = new JPanel();
        clickablePanel.setLayout(new GridBagLayout());
        addLightComponent(clickablePanel, selectableButtonPanel, 1, 0, 1, 9, GridBagConstraints.EAST, GridBagConstraints.BOTH);
        JPanel westPanel = new JPanel();
        westPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel eastPanel = new JPanel();
        eastPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        addHeavyWidthComponent(clickablePanel, westPanel, 0, 0, 1, 9, GridBagConstraints.WEST, GridBagConstraints.BOTH);
        addHeavyWidthComponent(clickablePanel, eastPanel, 2, 0, 1, 9, GridBagConstraints.EAST, GridBagConstraints.BOTH);
        JPanel mainGamePanel = new JPanel();
        mainGamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainGamePanel.setLayout(new GridLayout(3, 3));


        // selectable buttons for game
        for(Integer i = 9; i > 0; i--) {
            String buttonLabel = i.toString();
            selectableButtons = new SudokuButton(buttonLabel);
            sudokuArrayButtons[i-1] = selectableButtons;
            //selectableButtonPanel.add(selectableButtons);
            addLightComponent(selectableButtonPanel, selectableButtons, 0, i, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        }
        int i = 0, j = 0;
        for(int m = 0; m < 3; m++) {
            for(int n = 0; n < 3; n++) {
                JPanel smallGamePanel = new JPanel();
                smallGamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
                smallGamePanel.setLayout(new GridLayout(3, 3));
                if(m == 0 && n ==0) {
                    for(i = 0; i < 3; i++){
                        for (j = 0; j < 3; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 1 && n == 0) {
                    for(i = 3; i < 6; i++){
                        for (j = 0; j < 3; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 2 && n ==0) {
                    for(i = 6; i < 9; i++){
                        for (j = 0; j < 3; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 0 && n ==1) {
                    for(i = 0; i < 3; i++){
                        for (j = 3; j < 6; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 1 && n ==1) {
                    for(i = 3; i < 6; i++){
                        for (j = 3; j < 6; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 2 && n ==1) {
                    for(i = 6; i < 9; i++){
                        for (j = 3; j < 6; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 0 && n == 2) {
                    for(i = 0; i < 3; i++){
                        for (j = 6; j < 9; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 1 && n == 2) {
                    for(i = 3; i < 6; i++){
                        for (j = 6; j < 9; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
                if(m == 2 && n == 2) {
                    for(i = 6; i < 9; i++){
                        for (j = 6; j < 9; j++){
                            newGameButton = new GameGridButton();
                            gameGridButtons[i][j] = newGameButton;
                            smallGamePanel.add(newGameButton);
                        }
                    }
                    mainGamePanel.add(smallGamePanel);
                }
            }
        }


        JPanel lowerButtonPanel = new JPanel();
        lowerButtonPanel.setLayout(new GridBagLayout());
        addComponent(lowerButtonPanel, newGame, 0, 0, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE);
        addComponent(lowerButtonPanel, resetGameButton, 1, 0, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE);
        addComponent(lowerButtonPanel, solvePuzzleButton, 2, 0, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.NONE);


        mainPanel.setLayout(new GridBagLayout());
        addComponent(mainPanel, selectableButtonPanel, 0, 0, 1, 5, GridBagConstraints.WEST,
                GridBagConstraints.BOTH);
        addComponent(mainPanel, mainGamePanel, 1, 0, 4, 4, GridBagConstraints.EAST,
                GridBagConstraints.BOTH);
        addLightComponent(mainPanel, lowerButtonPanel, 1, 4, 4, 1, GridBagConstraints.SOUTHEAST,
                GridBagConstraints.BOTH);
        //mainPanel.add(mainGamePanel);
        this.add(mainPanel);
    }

    private static void addComponent(Container container, Component component,
                                     int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                     int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
                gridheight, 1.0, 1.0, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private static void addLightComponent(Container container, Component component,
                                          int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                          int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
                gridheight, 0.2, 0.2, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    private static void addHeavyWidthComponent(Container container, Component component,
                                               int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                               int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
                gridheight, 2.0, 1.0, anchor, fill, wideInsets, 0, 0);
        container.add(component, gbc);
    }
    /***********************************************************/
    //Method to create the sudoku puzzle on the game board
    /***********************************************************/
    void setupGame(int [][]Sudoku) {
        this.sudoku = Sudoku;
        Integer temp = -1;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                temp = sudoku[i][j];
                if(temp != -1) {
                    // Create and place the game button with a number and disable it
                    String buttonName = temp.toString();
                    newGameButton = gameGridButtons[i][j];
                    newGameButton.setButtonAnswer(temp);
                    newGameButton.setText(buttonName);
                    newGameButton.setEnabled(false);
                    //gameGridButtons[i][j] = newGameButton;
                    // Decrease the count on the assoiciated selectable button
                    selectableButtons = sudokuArrayButtons[temp-1];
                    selectableButtons.decreaseCount();
                }
            }
        }

    }

    void clearGame() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                gameGridButtons[i][j].setButtonAnswer(0);
                gameGridButtons[i][j].setText("");
                gameGridButtons[i][j].setEnabled(true);
            }
        }

        for(int i = 0; i < 9; i++) {
            sudokuArrayButtons[i].setCount(9);
            sudokuArrayButtons[i].setEnabled(true);
        }
    }

    SudokuButton getArrayButton(int i){
        selectableButtons = sudokuArrayButtons[i-1];
        return selectableButtons;
    }

    boolean solvePuzzle() {
        boolean solved = false;
        return solved;
    }


    /***********************************************************/
    //Method to add listeners for the selectable buttons
    /***********************************************************/
    void addButtonListener(ActionListener listenForThisButton) {
        for(int i = 9; i > 0; i--) {
            selectableButtons = sudokuArrayButtons[i-1];
            selectableButtons.addActionListener(listenForThisButton);
        }
    }
    /***********************************************************/
    //Method to add listeners for the game grid buttons
    /***********************************************************/
    void addGameListener(ActionListener listenForGameButton) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                newGameButton = gameGridButtons[i][j];
                newGameButton.addActionListener(listenForGameButton);

            }
        }
    }

    void addNewGameListener(ActionListener listenForNewGameButton) {
        newGame.addActionListener(listenForNewGameButton);
    }

    void addSolvedPuzzleListener(ActionListener listenForSolvedGameButton) {
        solvePuzzleButton.addActionListener(listenForSolvedGameButton);
    }

    void addResetPuzzleListener(ActionListener listenForResetGameButton) {
        resetGameButton.addActionListener(listenForResetGameButton);
    }


    void addClickOutListener(MouseListener listenForOutsideClick) {
        selectableButtonPanel.addMouseListener(listenForOutsideClick);
        for(int i = 9; i > 0; i--) {
            selectableButtons = sudokuArrayButtons[i-1];
            selectableButtons.addMouseListener(listenForOutsideClick);
        }
    }
}