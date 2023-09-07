package com.imker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

  private Long id;

  private String email;

  private String name;

  private String password;

  private String secretQuestion;

  private String answerSecretQuestion;

  private String plz;

  private String phone;

  private String image;

  private String role;

  private String state;
}

