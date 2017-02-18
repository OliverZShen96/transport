import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class Main {
	
	
	public static void main(String argc[]) throws Exception {
		getData();
	}
	
	private static void getData() throws Exception {
	
		HttpClient client = new DefaultHttpClient();
		
		HttpGet httpget = new HttpGet("https://api.transport.nsw.gov.au/v1/gtfs/vehiclepos/buses?debug=true");
		httpget.addHeader("Authorization: ", "apikey FV1GBaRZ0GNSCrcuQfyRMPjwjYCayFmBBQ4z");
		
		HttpResponse response = client.execute(httpget);
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		String data = "";
		String line = "";
		while ((line = rd.readLine()) != null) {
			data = data + line;
			System.out.println(line);
		}
	}
}
