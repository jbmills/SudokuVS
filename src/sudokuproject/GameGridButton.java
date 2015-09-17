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
public class GameGridButton extends JButton {
    private Integer answer;
    private boolean active;
    private Color originalColor;

    GameGridButton(){
        answer = 0;
        active = false;
        originalColor = this.getBackground();
    }

    GameGridButton(String in){
        this.setText(in);
        active = false;
        originalColor = this.getBackground();
    }

    public Color getColor(){
        return originalColor;
    }

    public int getButtonAnswer(){
        return answer;
    }

    public void setButtonAnswer(Integer in){
        this.answer = in;
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

