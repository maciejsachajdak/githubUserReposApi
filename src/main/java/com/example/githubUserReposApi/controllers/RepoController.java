package com.example.githubUserReposApi.controllers;

import com.example.githubUserReposApi.models.Repo;
import com.example.githubUserReposApi.services.RepoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepoController {
    private final RepoService repoService;

    public RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @RequestMapping("/repos/{username}")
    public List<Repo> getAllRepos(@PathVariable("username") String username) {
        return repoService.getAllRepos(username);
    }
}