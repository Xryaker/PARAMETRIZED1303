package emptyEx;

public enum Names {
    NIKOLAY("nikolay"),
    VASILIY("vasiliy");
     private String name;

    Names(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
