package model;

import lombok.Data;

@Data
public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String sex;
    private String birth;
    private int weight;
    private int height;
    private String phoneNumber;
    private String email;
    private String address;

}
