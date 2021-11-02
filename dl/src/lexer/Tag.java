package lexer;

public enum Tag {
    //Palavras reservadas
    PROGRAM("PROGRAM"), BEGIN("BEGIN"),END("END"),
    //Atribuição
    ASSING("ASSING"),
    //Aritméticos
    SUM("SUM"), MUL("MUL"),SUB("SUB"), DIV("DIV"),
    //Lógicos
    OR("OR"),LAND("LAND"),LOR("LOR"),LNOT("LNOT"),
    LT("LT"), LE("LE"), GT("GT"),NE("NE"),GE("GE"),
    //Literais
    LIT_INT("LIT_INT"),LIT_REAL("LIT_REAL"),
    //Identificadores
    ID("ID"),
    //Outros
    EOF("EOF"), UNK("UNK"),LPAREN("LPAREN"), RPAREN("RPAREN"),
    COMMA("COMMA"), SEMI("SEMI");

    private String name;
    Tag(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
