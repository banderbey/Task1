package com.sql.connection;

import config.DBConfig;
import model.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DoctorConnection {
    //???
    private final DBConfig dbConfig;


    public DoctorConnection() {
        this.dbConfig = new DBConfig();

    }

    public void connectGetAllDoctorsColumn() throws ParseException {

        String sqlSelectAllDoctors = "SELECT * FROM doctors";

        List<Doctor> doctorList = new ArrayList<>();
        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllDoctors);

            while (rs.next()) {
                int id = rs.getInt("id");
                String dob = rs.getString("birth");
                String pn = rs.getString("phoneNumber");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String specialty = rs.getString("specialty");
                String sex = rs.getString("sex");


                Doctor doctor = new Doctor();

                doctor.setId(id);

                String lowSex = sex.toLowerCase(Locale.ROOT);
                boolean isCorrectSex = lowSex.equals("male") || lowSex.equals("female");
                doctor.setSex(isCorrectSex ? lowSex : "err");
                //  LocalDate ldt = LocalDate.parse(dob);

                boolean isCorrectDOB = (LocalDate.now().isAfter(LocalDate.parse(dob, DateTimeFormatter.ISO_DATE)));
                doctor.setBirth(isCorrectDOB ? dob : "err");


                boolean isCorrectPN = pn.matches("^\\+(?:[0-9] ?){6,14}[0-9]$");
                doctor.setPhoneNumber(isCorrectPN ? pn : "err");

                boolean isCorrectFirstName = (firstName.matches("[aA-zZ ]+$") || firstName.length() >= 3);
                doctor.setFirstName(isCorrectFirstName ? firstName : "err");

                boolean isCorrectLastName = (firstName.matches("[aA-zZ ]+$") || firstName.length() >= 3);
                doctor.setLastName(isCorrectLastName ? lastName : "err");

                boolean isCorrectEmail = email.matches("^(.+)@(.+)$");
                doctor.setEmail(isCorrectEmail ? email : "err");

                doctor.setAddress(address);

                doctor.setSpecialty(specialty.length() >= 3 ? specialty : "err");

                doctorList.add(doctor);

                // do something with the extracted data...
            }
            //!!!!!!
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(doctorList);

        //Doctor.builder().lastName(null).firstName().build();
    }
}
