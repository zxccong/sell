# sell


 https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index

1.微信公众平台测试号，设置域名


vi /opt/code/sell_fe_buyer/config/index.js 

cd /opt/code/sell_fe_buyer/

npm run build

cp -r dist/* /opt/data/wwwroot/sell/


2.虚拟机设置前端域名

application-dev.yml

F:\sell\src\main\resources\templates\order\list.ftl

F:\sell\src\main\resources\templates\index.html

3.修改配置文件

vi /usr/local/nginx/conf/nginx.conf

nginx -s reload

4.修改nginx配置


natapp -authtoken=78e2e98a3d0684a0

5.配置natapp
