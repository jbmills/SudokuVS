/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuproject;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Brandon
 */
public class SudokuButton extends JButton {
    private int Count;
    private boolean active;
    private Color originalColor;

    public SudokuButton() {
        Count = 9;
        active = false;
        originalColor = this.getBackground();
    }

    public Color getColor(){
        return originalColor;
    }

    public SudokuButton(String in) {
        this.setText(in);
        Count = 9;
    }

    public void setCount(int countSet){
        this.Count = countSet;
    }

    public int getCount(){
        return Count;
    }

    public void decreaseCount(){
        this.Count--;
        if(Count == 0){
            this.setEnabled(false);
            //this.setVisible(false);
        }
    }

    public void increaseCount(){
        this.Count++;
        if(!this.isEnabled()){
            this.setEnabled(true);
            //this.setVisible(true);
        }
    }

    public void setActive(){
        active = true;
    }

    public void setInactive(){
        active = false;
    }

    public boolean isActive(){
        return active;
    }
}
