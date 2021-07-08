# springboot-oauth2-demo
# 步骤
- A 网站让用户跳转到 GitHub。
- GitHub 要求用户登录，然后询问"A 网站要求获得 xx 权限，你是否同意？"
- 用户同意，GitHub 就会重定向回 A 网站，同时发回一个授权码。
- A 网站使用授权码，向 GitHub 请求令牌。
- GitHub 返回令牌.
- A 网站使用令牌，向 GitHub 请求用户数据。

