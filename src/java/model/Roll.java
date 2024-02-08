/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class Roll {
    protected int id;
    protected String roll1;
    protected String roll2;
    protected String roll3;

    public Roll(String roll1, String roll2, String roll3) {
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
    }
    
    

    public Roll(int id, String roll1, String roll2, String roll3) {
        this.id = id;
        this.roll1 = roll1;
        this.roll2 = roll2;
        this.roll3 = roll3;
    }

    public Roll() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoll1() {
        return roll1;
    }

    public void setRoll1(String roll1) {
        this.roll1 = roll1;
    }

    public String getRoll2() {
        return roll2;
    }

    public void setRoll2(String roll2) {
        this.roll2 = roll2;
    }

    public String getRoll3() {
        return roll3;
    }

    public void setRoll3(String roll3) {
        this.roll3 = roll3;
    }
    
    
}
