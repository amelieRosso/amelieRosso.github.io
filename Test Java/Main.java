//import java.util.Properties;
//import java.io.FileReader;
import java.awt.EventQueue;

public class Main {
    static String sentence = "Hello World!";
    public static void main(String[] args) throws Exception {
        //registerComboBoxListener(cb);
        EventQueue.invokeLater(() -> new Login().createAndDisplayGui());
        //Properties p = new Properties();
        //FileReader reader = new FileReader("translate.properties");
        //p.load(reader);
        //Translate t = new Translate(p.getProperty("rapidapi.apikey"));
        //System.out.println(t.translate(sentence, "de"));
        //System.out.println(t.translate(sentence, "fr"));
        //System.out.println(t.translate(sentence, "es"));
        //System.out.println(t.translate(sentence, "it"));
       
    }
}
