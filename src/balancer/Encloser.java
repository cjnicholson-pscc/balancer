/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancer;

/**
 *
 * @author cjnicholson
 */
public class Encloser {
    
    private char ch;
    private int lineNumber;

    public Encloser(char ch, int lineNumber) {
        this.ch = ch;
        this.lineNumber = lineNumber;
    }

    public char getCh() {
        return ch;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public boolean equals(Object obj) {
        Encloser that = (Encloser) obj;
        if(this.ch == '(' && that.ch == ')') return true;
        if(this.ch == '[' && that.ch == ']') return true;
        if(this.ch == '{' && that.ch == '}') return true;
        
        return false;
    }   
}
