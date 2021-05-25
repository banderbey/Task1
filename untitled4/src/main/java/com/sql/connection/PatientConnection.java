package com.sql.connection;

import config.DBConfig;
import model.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PatientConnection {
    //???
    private final DBConfig dbConfig;

    public PatientConnection() {
        this.dbConfig = new DBConfig();

    }

    public void connectGetAllPatientColumn() {
        String sqlSelectAllPatient = "SELECT * FROM patient";


        List<Patient> patientList = new ArrayList<>();
        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllPatient);

            while (rs.next()) {
                int id = rs.getInt("id");
                String dob = rs.getString("dob");
                String pn = rs.getString("pn");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String sex = rs.getString("sex");
                int weight = rs.getInt("weight");
                int height = rs.getInt("height");

                Patient patient = new Patient();
                patient.setId(id);

                String lowSex = sex.toLowerCase(Locale.ROOT);
                boolean isCorrectSex = lowSex.equals("male") || lowSex.equals("female");
                patient.setSex(isCorrectSex ? sex : "err");

                boolean isCorrectDOB = (LocalDate.now().isAfter(LocalDate.parse(dob, DateTimeFormatter.ISO_DATE)));
                patient.setBirth(isCorrectDOB ? dob : "err");


                patient.setAddress(address);

                patient.setHeight(height > 0 ? height : null);

                patient.setWeight(weight > 0 ? weight : null);

                boolean isCorrectPN = pn.matches("^\\+(?:[0-9] ?){6,14}[0-9]$");
                patient.setPhoneNumber(isCorrectPN ? pn : "err");

                boolean isCorrectFirstName = (firstName.matches("[aA-zZ ]+$") || firstName.length() >= 3);
                patient.setFirstName(isCorrectFirstName ? firstName : "err");

                boolean isCorrectLastName = (firstName.matches("[aA-zZ ]+$") || firstName.length() >= 3);
                patient.setLastName(isCorrectLastName ? lastName : "err");

                boolean isCorrectEmail = email.matches("^(.+)@(.+)$");
                patient.setEmail(isCorrectEmail ? email : "err");

                patientList.add(patient);


                // do something with the extracted data...
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(patientList);


    }
}

