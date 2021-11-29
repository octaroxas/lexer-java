package Parser;

import lexer.Lexer;
import lexer.Tag;
import lexer.Token;

import java.util.Spliterators;

public class Parser {
    private Lexer lexer;
    private Token look;

    public Parser(Lexer lex) {
        lexer = lex;
        move();
    }
    public Token move(){
        Token save = look;
        look = lexer.nextToken();
        return save;
    }

    private void error(String s) {
        System.err.println("Linha " + Lexer.line() + ": " + s);
        System.exit(0);
    }

    private Token match(Tag t) {
        if( look.getTag() == t ) {
            return move();
        }
        error("Simbolo inesperado");
        return null;
    }

    public void parse() {
        program();
    }

    private void program() {
        match(Tag.PROGRAM);
        match(Tag.ID);
        block();
        match(Tag.DOT);
        match(Tag.EOF);
    }

    private void block() {
        match(Tag.BEGIN);
        while ( look.getTag() != Tag.END ) {
            stmt();
            match(Tag.SEMI);
        }
    }

    private void stmt() {
        switch ( look.getTag() ) {
            case BEGIN:
                block();
                break;
            case INT: case REAL: case BOOL:
                decl();
                break;
            case ID:
                assing();
                break;
            case IF:
                return ifStmt();
            default:
                error("Comando inválido (Em: DL.java)");
        }
    }

    private void decl() {
        move();
        match(Tag.ID);
    }

    private void assing(){
        match(Tag.ID);
        match(Tag.ASSING);
        expr();
    }

    private void expr() {
        rel();
        while ( look.getTag() == Tag.OR) {
            move();
            rel();
        }
    }

    private void rel() {
        arith();
        while ( look.getTag() == Tag.LT ||
                look.getTag() == Tag.LE ||
                look.getTag() == Tag.GT) {
            move();
            arith();
        }
    }

    private void arith(){
        term();
        while ( look.getTag() == Tag.SUM ||
                look.getTag() == Tag.SUB ) {
            move();
            term();
        }
    }

    private void term(){
        factor();
        while ( look.getTag() == Tag.MUL) {
            move();
            factor();
        }
    }

    private void factor(){
        switch (look.getTag() ) {
            case LPAREN:
                move();
                expr();
                match(Tag.LPAREN);
                break;
            case LIT_INT:
                move();
                break;
            case LIT_REAL:
                move();
                break;
            case TRUE: case FALSE:
                move();
                break;
            case ID:
                match(Tag.ID);
                break;
            default:
                error("Expressão inválida! (Em: Parser.java)");
        }
    }

    private void ifStmt() {
        match(Tag.IF);
        match(Tag.LPAREN);
        expr();
        match(Tag.RPAREN);
        stmt();
    }

    private void writeStmt() {
        move();
        match(Tag.LPAREN);
        match(Tag.ID);
        match(Tag.RPAREN);
    }

    /*
    * Implementar o while (enqunato) e a divisão
    * */



}
