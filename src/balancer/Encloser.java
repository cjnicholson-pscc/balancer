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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Encloser other = (Encloser) obj;
        if (this.ch != other.ch) {
            return false;
        }
        return true;
    }   
}
