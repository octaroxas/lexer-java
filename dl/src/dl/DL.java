package dl;

import lexer.Lexer;
import lexer.Tag;
import lexer.Token;

import java.io.File;

public class DL {
    public static void main(String[] args){
 //      Token t1 = new Token(Tag.ASSING, "=");
//        Token t2 = new Token(Tag.LE, "<=");
//        System.out.println("token1: "+t1+ " - ttoken2: "+t2);

        Lexer l = new Lexer(new File("prog.dl"));
        Token t = l.nextToken();
        while (t.getTag() != Tag.EOF) {
            System.out.println(t);
            t = l.nextToken();
        }

        //continuar do exercicio
    }
}
