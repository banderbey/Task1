package model;

import lombok.Data;

@Data
public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String sex;
    private String birth;
    private String phoneNumber;
    private String email;
    private String address;
    private String specialty;

}
