// JsonFetcher.java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonFetcher {

    // Fallback URLs
    private static final String PRIMARY_URL = "https://latest.currency-api.pages.dev/v1/currencies/eur.json";
    private static final String FALLBACK_URL = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/eur.json";

    // Method to fetch JSON data from a given URL
    public static String fetchJsonData(String url) {
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Create the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check if response is successful
            if (response.statusCode() == 200) {
                return response.body();  // Return the JSON response body
            } else {
                System.out.println("Failed to fetch data from URL: " + url);
                return null;  // Return null if status code is not 200 (success)
            }

        } catch (Exception e) {
            System.out.println("Error fetching data from URL: " + url);
            e.printStackTrace();
            return null;  // Return null if there's an exception (e.g., network error, invalid URL)
        }
    }

    // Method to attempt fetching from the primary URL, fallback to secondary if needed
    public static String fetchJsonWithFallback() {
        String jsonResponse = fetchJsonData(PRIMARY_URL);  // Try the primary URL

        // If fetching from the primary URL fails, try the fallback URL
        if (jsonResponse == null) {
            System.out.println("Primary URL failed. Trying fallback...");
            jsonResponse = fetchJsonData(FALLBACK_URL);
        }

        // Return the result (may be null if both fail)
        return jsonResponse;
    }
}
