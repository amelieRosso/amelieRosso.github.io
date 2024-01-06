import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;

public class Translate {
	private String keyCode;
	public Translate(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void translate(String sentence) throws Exception {
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
		.header("content-type", "application/x-www-form-urlencoded")
		.header("Accept-Encoding", "application/gzip")
		.header("X-RapidAPI-Key", getKeyCode())
		.header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
		.method("POST", HttpRequest.BodyPublishers.ofString("q=" + URLEncoder.encode(sentence,"UTF-8") + "&target=de"))
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
	}
}
