package by.itacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OnlineBasePatients {
    private Set<Patient> listOnline = new LinkedHashSet<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public Set<Patient> getOnlineInfo() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/Zaitsev-95/BasePatient/master/PatientBase.txt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    String[] array = s.split(";");
                    String name = array[0];
                    String secondName = array[1];
                    Date date = sdf.parse(array[2]);
                    boolean healthy = Boolean.valueOf(array[3]);
                    listOnline.add(new Patient(name, secondName, date, healthy));
                }
            } catch (IOException | ParseException exc) {
                System.out.println(exc);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return listOnline;
    }
}