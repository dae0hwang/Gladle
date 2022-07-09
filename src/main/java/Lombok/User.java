package Lombok;

import lombok.ToString;

@ToString(exclude = "password")
public class User {
    private Long id;
    private String username;
    private String password;
    private int[] scores;
}