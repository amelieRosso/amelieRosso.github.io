public class Main {
    static String sentence = "English is hard but detectably so";
    public static void main(String[] args) throws Exception {
        Translate t = new Translate("5101febe8fmsh8b54e70c5bb9063p14f603jsnbb16dbf0213b");
        t.translate(sentence);
    }
}
