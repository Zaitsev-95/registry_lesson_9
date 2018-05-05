package by.itacademy;

import java.io.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class OfflineBasePatients {
    private Set<Patient> listPatients = new LinkedHashSet<>();
    private String localFile = "base.dat";

    public void writeInfo(Set<Patient> listPatients) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(localFile, false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            for (Patient patient : listPatients) {
                dataOutputStream.writeUTF(patient.getName());
                dataOutputStream.writeUTF(patient.getSecondName());
                dataOutputStream.writeLong(patient.getBirthday().getTime());
                dataOutputStream.writeBoolean(patient.isHealthy());
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public Set<Patient> readInfo() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(localFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            while (dataInputStream.available() > 0) {
                String name = dataInputStream.readUTF();
                String secondName = dataInputStream.readUTF();
                Date birthday = new Date(dataInputStream.readLong());
                boolean healthy = dataInputStream.readBoolean();
                listPatients.add(new Patient(name, secondName, birthday, healthy));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return listPatients;
    }
}