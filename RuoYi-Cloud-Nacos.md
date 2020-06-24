# 下载Nacos

## 下载地址

[下载nacos地址](https://nacos.io/zh-cn/docs/quick-start.html)

## 修改配置

配置nacos持久化，修改conf/application.properties文件，增加支持mysql数据源配置

nacos的数据库驱动不支持8版本

```xml
# db mysql
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://localhost:3306/ry-config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=root
db.password=password
```

## 启动

```bash
sh startup.sh -m standalone
```

## 停止

```bash
sh shutdown.sh
```

![](https://i.loli.net/2020/06/12/vGVLUI6mBwjFaly.png)





# 进入nacos

http://127.0.0.1:8848/nacos/index.html

账号和密码都是nacos

## 修改配置

![image-20200612125142016](https://i.loli.net/2020/06/12/OY759itamjLANCH.png)



# 修改代码

![image-20200612131243560](https://i.loli.net/2020/06/12/V17ZtmoUSGqMDzI.png)

全局搜索 /home/ruoyi/ 修改日志路径。

# 前台启动

```bash
# 安装依赖
npm install --registry=https://registry.npm.taobao.org
# 启动项目
npm run dev

```

# 后台启动

![image-20200612132926078](https://i.loli.net/2020/06/12/jB7iXVAvnN25EWz.png)

## RunDashboard

如果没有的话，全局搜索 workspace.xml，在RunDashboard增加。

```xml
<option name="configurationTypes">
  <set>
    <option value="SpringBootApplicationConfigurationType" />
  </set>
</option>
```

# Sentinel

http://127.0.0.1:8718/#/dashboard/metric/sentinel-dashboard

账号密码都是 sentinel

```shell
java -Dserver.port=8718 -Dcsp.sentinel.dashboard.server=localhost:8718 -Dproject.name=sentinel-dashboard -jar                                        -Dsentinel.dashboard.auth.username=sentinel -Dsentinel.dashboard.auth.password=123456 sentinel-dashboard-1.7.2.jar

# 群友版本
java -Dserver.port=8718 -Dcsp.sentinel.dashboard.server=localhost:8718 -Dproject.name=sentinel-dashboard -Dcsp.sentinel.api.port=8719 -jar sentinel-dashboard-1.7.2.jar
```

![image-20200618134329972](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200618134329972.png)

# 代码入门



