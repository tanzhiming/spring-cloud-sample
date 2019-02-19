1. 授权服务器验证

http://127.0.0.1:8000/oauth/authorize?client_id=test_client&response_type=code&redirect_uri=http://baidu.com


2. 输入账号密码，为实现的 UserDetailsService 要里获取的用户，点击 login,
3. 进入简单授权页面，点击 Authorize,
4. 重定向到 redirect_uri，并带有 code 参数: 

    http://baidu.com?code=rTKETX

5. POST请求获取token

http://localhost:8000/oauth/token

![get-token](./get-token.png)

参数:
* client
* grant_type: authorization_code
* redirect_uri
* code

请求头：

Authorization: 

注意，此处需加 Authorization 请求头，值为 Basic xxx xxx 为 client_id:client_secret 的 base64编码。


密码方式

http://localhost:8000/oauth/token?client_id=test_client&client_secret=123456&grant_type=password&username=tzm01&password=123456

检查token

http://localhost:8000/oauth/check_token?token=4f53731b-15b5-4c66-add0-a322e5a97d22

刷新token
http://localhost:8000/oauth/token?grant_type=refresh_token&refresh_token=fbde81ee-f419-42b1-1234-9191f1f95be9&client_id=demoClientId&client_secret=demoClientSecret


