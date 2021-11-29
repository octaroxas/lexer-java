package dl;

import Parser.Parser;
import lexer.Lexer;
import lexer.Tag;
import lexer.Token;

import java.io.File;

public class DL {
    public static void main(String[] args){
        Lexer l = new Lexer(new File("prog.dl"));

        Parser p = new Parser(l);
        p.parse();
        System.out.println("Finalizado");
//        Token t = l.nextToken();
//        while (t.getTag() != Tag.EOF) {
//            System.out.println(t);
//            t = l.nextToken();
//        }
    }
}
