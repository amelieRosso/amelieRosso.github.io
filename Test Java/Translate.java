import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import org.json.*;

public class Translate {
	private String keyCode;
	public Translate(String keyCode) {
		this.keyCode = keyCode;
	}

	public String translate(String sentence, String language) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
		.header("content-type", "application/x-www-form-urlencoded")
		.header("Accept-Encoding", "application/gzip")
		.header("X-RapidAPI-Key", this.keyCode)
		.header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
		.method("POST", HttpRequest.BodyPublishers.ofString("q=" + URLEncoder.encode(sentence,"UTF-8") + "&target=" + language))
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
		System.out.print(body);
		JSONObject res = new JSONObject(body);
		return res.getJSONObject("data").getJSONArray("translations").getJSONObject(0).getString("translatedText");
	}
}
