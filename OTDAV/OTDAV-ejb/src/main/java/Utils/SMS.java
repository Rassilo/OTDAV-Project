package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMS {

	public static void sendSMS(String numeroTelephone, String message) {

		try {
			// Construct data
			String data = "";
			/*
			 * Note the suggested encoding for certain parameters, notably the username,
			 * password and especially the message. ISO-8859-1 is essentially the character
			 * set that we use for message bodies, with a few exceptions for e.g. Greek
			 * characters. For a full list, see:
			 * http://developer.bulksms.com/eapi/submission/character-encoding/
			 */
			data += "username=" + URLEncoder.encode("xxxxxxxxx", "ISO-8859-1");
			data += "&password=" + URLEncoder.encode("xxxxxxxxxx", "ISO-8859-1");
			data += "&message=" + URLEncoder.encode(message, "ISO-8859-1");
			data += "&want_report=1";
			data += "&msisdn=216" + numeroTelephone;

			// Send data
			// Please see the FAQ regarding HTTPS (port 443) and HTTP (port
			// 80/5567)
			URL url = new URL("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				// Print the response output...
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
