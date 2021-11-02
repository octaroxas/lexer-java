package lexer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Lexer {
    private static final char EOF_CHAR = (char) -1;
    private static int line = 1;
    private BufferedReader reader;
    private char peek;

    public Lexer(File file){
        try {
            this.reader = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.peek = ' ';
    }

    // Métodos
    public static int line() {
        return line;
    }

    private char nexChar() {
        // Se o último caractere lido for uma quebra de linha o  numero de linhas é acrescentado
        if( peek == '\n') line++;
        try {
            peek = (char)reader.read();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return peek;
    }

    private static boolean isWhiteSpace(int c) {
        switch (c) {
            case ' ': case '\t': case'\n':
                return true;
            default:
                return false;
        }
    }

    public Token nextToken() {
        while (isWhiteSpace(peek)) nexChar();
        switch (peek) {
            case '=':
                nexChar();
                return new Token(Tag.ASSING, "=");
            case '+':
                nexChar();
                return new Token(Tag.SUM,"+");
            case '-':
                nexChar();
                return new Token(Tag.SUB,"-");
            case '*':
                nexChar();
                return new Token(Tag.MUL,"*");
            case '/':
                nexChar();
                return new Token(Tag.DIV,"/");
            case '|':
                nexChar();
                return new Token(Tag.OR,"|");
            case '<':
                nexChar();
                if(peek == '=') {
                    return new Token(Tag.LE,"<=");
                }
                return new Token(Tag.LT,"<");
            case '>':
                nexChar();
                if (peek == '=') {
                    return new Token(Tag.GE,">=");
                }
                return new Token(Tag.GT,">");
            case '!':
                nexChar();
                if(peek == '='){
                    return new Token(Tag.NE,"!=");
                }
                return new Token(Tag.LNOT,"!");
            case '&':
                nexChar();
                return new Token(Tag.LAND,"&");
            case '(':
                nexChar();
                return new Token(Tag.LPAREN,"(");
            case ')':
                nexChar();
                return new Token(Tag.RPAREN,")");
            case ',':
                nexChar();
                return new Token(Tag.COMMA,",");
            case ';':
                nexChar();
                return new Token(Tag.SEMI,";");
            case EOF_CHAR:
                return new Token(Tag.EOF,"");
            default:
                if(Character.isDigit(peek)){
                    //Se cocaractere atual (peek) for um dígito, faça:
                    String num = "";
                    do {
                        num += peek;
                        nexChar();
                    } while (Character.isDigit(peek));
                    //Ao se deparar com um . é verificado se o proximo caractere é um digito.
                    //Se sim, concatena com . e segue
                    //Se não, retorna um token LIT_INT
                    if(peek == '.' && Character.isDigit(nexChar())) {
                        num += '.';

                        while (Character.isDigit(peek)) {
                            num += peek;
                            System.out.println(num);
                            nexChar();
                        }
                        return new Token(Tag.LIT_REAL, num);
                    } else {
                        return new Token(Tag.LIT_INT, num);
                    }
                }
        }
        String unk = String.valueOf(peek);
        nexChar();
        return new Token(Tag.UNK, unk);
    }
}
