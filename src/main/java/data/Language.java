package data;

public enum Language {
    EN("en"),
    UK("uk"),
    FR("fr");
//    RU("ru"),
//    ES("es"),
//    DE("de");

   private String lang;

    Language(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
