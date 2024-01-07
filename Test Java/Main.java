import java.util.Properties;
import java.io.FileReader;

public class Main {
    static String sentence = "Hello World!";
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        FileReader reader = new FileReader("translate.properties");
        p.load(reader);
        //Translate t = new Translate(p.getProperty("rapidapi.apikey"));
        GoogleTranslate t = new GoogleTranslate(p.getProperty("google.apikey"));
        System.out.println(t.translate(sentence, "de"));
        //System.out.println(t.translate(sentence, "fr"));
        //System.out.println(t.translate(sentence, "es"));
        //System.out.println(t.translate(sentence, "it"));
    }
}
