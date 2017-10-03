package geekbrains.oop;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // Construct data
            String data = "lang=ru-en&key=trnsl.1.1.20171003T125746Z.d9d155d60493b199.680f5b1d70acf9618012a2f7c31f40cee1cce4f6&" +
                    "text=Вся хвала тебе, Бог!";
//            String data = URLEncoder.encode("lang", "UTF-8") + "=" + URLEncoder.encode("ru-en", "UTF-8");
//            data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("trnsl.1.1.20171003T125746Z.d9d155d60493b199.680f5b1d70acf9618012a2f7c31f40cee1cce4f6", "UTF-8");
//            data += "&" + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode("Алиллуйя!", "UTF-8");
            // Send data
            URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?");
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
        }
    }
    }