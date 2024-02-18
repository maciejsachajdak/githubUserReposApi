package com.example.githubUserReposApi.errors;

import lombok.Value;

import java.util.Date;
@Value
public class UserNotFoundError {
    int status;
    String message;
    Date date;
}
