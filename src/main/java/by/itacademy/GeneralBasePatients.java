package by.itacademy;

import java.util.Set;

public class GeneralBasePatients implements GeneralBase {
    private Set<Patient> listPatients;
    private OnlineBasePatients onlineBase;
    private OfflineBasePatients offlineBase;

    @Override
    public Set<Patient> getGeneralBase() {
        onlineBase = new OnlineBasePatients();
        offlineBase = new OfflineBasePatients();
        listPatients = onlineBase.getOnlineInfo();
        listPatients.addAll(offlineBase.readInfo());
        return listPatients;
    }
}