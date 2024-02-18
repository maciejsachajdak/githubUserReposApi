package com.example.githubUserReposApi.services;

import com.example.githubUserReposApi.models.Repo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class RepoService {
    public List<Repo> getAllRepos(String username) {
        String apiUrl = "https://api.github.com/users/" + username + "/repos";
        RestTemplate rest = new RestTemplate();
        String result = rest.getForObject(apiUrl, String.class);
        List<Repo> repos = new ArrayList<>();
        JSONArray jsonAllRepos = new JSONArray(result);
        for (int i = 0; i < jsonAllRepos.length(); i++) {
            JSONObject repo = jsonAllRepos.getJSONObject(i);
            String repositoryName = repo.getString("name");
            Boolean fork = repo.getBoolean("fork");
            JSONObject ownerObject = repo.getJSONObject("owner");
            String url = repo.getString("branches_url");
            String branchesUrl = url.substring(0, url.lastIndexOf('{'));
            String branchesString = rest.getForObject(branchesUrl, String.class);
            JSONArray jsonAllBranches = new JSONArray(branchesString);
            List<Map<String, String>> branches = new ArrayList<>();
            for (int j = 0; j < jsonAllBranches.length(); j++) {
                JSONObject branchJsonObject = jsonAllBranches.getJSONObject(j);
                HashMap<String, String> branch = new LinkedHashMap<>();
                branch.put("branchName", branchJsonObject.getString("name"));
                branch.put("branchLastSha", branchJsonObject.getJSONObject("commit").getString("sha"));
                branches.add(branch);
            }
            repos.add(new Repo(repositoryName, ownerObject.getString("login"), branches, fork));
        }

        return repos.stream().filter(repo -> !repo.getFork()).toList();
    }
}