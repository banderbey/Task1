package com.sql.connection;

import config.DBConfig;
import model.Hospital;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HospitalConnection {
    //???
    private final DBConfig dbConfig;

    public HospitalConnection() {
        this.dbConfig = new DBConfig();

    }

    public void connectGetAllHospitalColumn() {
        String sqlSelectAllHospitals = "SELECT * FROM hospital";

        List<Hospital> hospitalList = new ArrayList<>();
        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllHospitals);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String headDoctor = rs.getString("headDoctor");
                String phoneNumber = rs.getString("phoneNumber");

                Hospital hospital = new Hospital();
                hospital.setId(id);

                hospital.setName(name.length() >= 3 ? name : "err");

                hospital.setDescription(description);
                hospital.setAddress(address);

                boolean isCorrectEmail = email.matches("^(.+)@(.+)$");
                hospital.setEmail(isCorrectEmail ? email : "err");

                boolean isCorrectHeadDoctor = (headDoctor.matches("[aA-zZ ]+$") || headDoctor.length() >= 3);
                hospital.setHeadDoctor(isCorrectHeadDoctor ? headDoctor : "err");

                boolean isCorrectPN = phoneNumber.matches("^\\+(?:[0-9] ?){6,14}[0-9]$");
                hospital.setPhoneNumber(isCorrectPN ? phoneNumber : "err");

                hospitalList.add(hospital);

                // do something with the extracted data...
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(hospitalList);


    }
}

