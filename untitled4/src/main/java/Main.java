import com.sql.connection.DoctorConnection;
import com.sql.connection.HospitalConnection;
import com.sql.connection.LabConnection;
import com.sql.connection.PatientConnection;
import com.sql.connection.listData.ListDoctorLabs;
import com.sql.connection.listData.ListHospitalLabs;
import com.sql.connection.listData.ListSomethingBySomething;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

        DoctorConnection doctorConnection = new DoctorConnection();

        doctorConnection.connectGetAllDoctorsColumn();

        HospitalConnection hospitalConnection = new HospitalConnection();
        hospitalConnection.connectGetAllHospitalColumn();

        PatientConnection patientConnection = new PatientConnection();
        patientConnection.connectGetAllPatientColumn();

        LabConnection procedureConnection = new LabConnection();
        procedureConnection.connectGetAllLabColumn();

        ListSomethingBySomething somethingBySomething = new ListSomethingBySomething();
        somethingBySomething.listSomethingBySomething();

        ListDoctorLabs doctorLabs = new ListDoctorLabs();
        doctorLabs.listDoctorsLabs();

        ListHospitalLabs hospitalLabs = new ListHospitalLabs();
        hospitalLabs.listHospitalLabs();
    }
}
