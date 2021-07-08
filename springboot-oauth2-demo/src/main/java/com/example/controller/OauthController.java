package com.example.controller;

import com.example.config.GithubConfig;
import com.example.service.GitHubOauthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhougaojun
 * @since 2021/7/8
 */
@Controller
@AllArgsConstructor
public class OauthController {

    private final GitHubOauthService gitHubOauthService;
    private final GithubConfig githubConfig;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 重定向 GitHub登录
     *
     * @return
     */
    @RequestMapping("/login-to-github")
    public String loginToGithub() {
        String loginUrl = "https://github.com/login/oauth/authorize?"
                + "client_id=" + githubConfig.getClientId()
                + "&redirect_uri=" + githubConfig.getRedirectUri();
        return "redirect:" + loginUrl;
    }

    /**
     * github 回调地址
     *
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/oauth/redirect")
    public String oauthRedirect(String code) {
        // 根据授权码换取 AccessToken
        String accessToken = gitHubOauthService.getAccessToken(code);
        // 根据 accessToken 获取用户信息
        String userInfo = gitHubOauthService.getUserInfos(accessToken);
        return userInfo;
    }
}
