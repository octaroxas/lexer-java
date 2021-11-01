package dl;

import lexer.Tag;
import lexer.Token;

public class DL {
    public static void main(String[] args){
        Token t1 = new Token(Tag.ASSING, "=");
        Token t2 = new Token(Tag.LE, "<=");
        System.out.println("token1: "+t1+ " - ttoken2: "+t2);
    }
}
