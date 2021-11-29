package lexer;

public class Token {
    private Tag tag;
    private String lexeme;

    public Token(Tag tag, String lexeme) {
        this.lexeme = lexeme;
        this.tag = tag;
    }

    public Tag getTag() {
        return this.tag;
    }
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString(){
        return "<" + tag +", " + lexeme + " >";
    }
}
