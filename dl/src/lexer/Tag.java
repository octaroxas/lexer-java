package lexer;

public enum Tag {
    ASSING("ASSING"),
    SUM("SUM"), MUL("MUL"),
    OR("OR"),
    LT("LT"), LE("LE"), GT("GT"),
    EOF("EOF"), UNK("UNK");

    private String name;
    Tag(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
