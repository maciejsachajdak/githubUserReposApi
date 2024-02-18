package com.example.githubUserReposApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class Repo {
    String repositoryName;
    String login;
    List<Map<String,String>> branches;
    @JsonIgnore
    Boolean fork;
}