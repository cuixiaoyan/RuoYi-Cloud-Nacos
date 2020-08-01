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



## 创建数据表

```mysql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_student
-- ----------------------------
DROP TABLE IF EXISTS `cxy_sys_student`;
CREATE TABLE `cxy_sys_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `student_name` varchar(30) DEFAULT '' COMMENT '学生名称',
  `student_age` int(3) DEFAULT NULL COMMENT '年龄',
  `student_sex` char(1) DEFAULT '0' COMMENT '性别（0男 1女 2未知）',
  `student_status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `student_birthday` datetime DEFAULT NULL COMMENT '生日',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学生信息表';

-- ----------------------------
-- Records of sys_student
-- ----------------------------
BEGIN;
INSERT INTO `sys_student` VALUES (1, '12321', 123, '0', '1', '2020-05-18 00:00:00', NULL);
INSERT INTO `sys_student` VALUES (2, '12', 12, '1', '1', '2020-06-23 00:00:00', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

```

## 代码生成

![image-20200624153654308](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200624153654308.png)

![image-20200624153822766](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200624153822766.png)

![image-20200625113623424](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625113623424.png)

## 增加目录

![image-20200625113728489](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625113728489.png)



## 新的模块创建

#### 父目录

![image-20200629175053107](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200629175053107.png)

#### 子目录

![image-20200625114104538](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625114104538.png)

## 引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>ruoyi-cxy</artifactId>
        <groupId>com.ruoyi</groupId>
        <version>2.0.0</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>school-business</artifactId>

    <description>
        school-business业务逻辑代码
    </description>

    <dependencies>

        <!-- SpringCloud Ailibaba Nacos -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <!-- SpringCloud Ailibaba Nacos Config -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>

        <!-- SpringCloud Ailibaba Sentinel -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>

        <!-- SpringBoot Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Swagger -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${swagger.fox.version}</version>
        </dependency>

        <!-- Quartz -->
        <dependency>
            <groupId>org.quartz-scheduler</groupId>
            <artifactId>quartz</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>com.mchange</groupId>
                    <artifactId>c3p0</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- Mysql Connector -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <!-- Ruoyi Common Security-->
        <dependency>
            <groupId>com.ruoyi</groupId>
            <artifactId>ruoyi-common-security</artifactId>
        </dependency>

        <!-- Ruoyi Common Log -->
        <dependency>
            <groupId>com.ruoyi</groupId>
            <artifactId>ruoyi-common-log</artifactId>
        </dependency>


        <!-- Ruoyi Common Swagger -->
        <dependency>
            <groupId>com.ruoyi</groupId>
            <artifactId>ruoyi-common-swagger</artifactId>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
```

都是直接将文件复制粘贴进去即可。

**后台文件放置**

![image-20200625114402063](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625114402063.png)

**前台文件放置**

![image-20200625114503714](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625114503714.png)

# 常见问题

1. 创建配置文件，端口，和服务名。

![image-20200625114629369](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625114629369.png)

2. nacos中创建，仿照代码生成模块的配置文件。

![image-20200625114756426](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625114756426.png)

![image-20200703100647711](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200703100647711.png)

3. 设置网关

![image-20200625114942609](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625114942609.png)

![image-20200625115033671](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625115033671.png)

4. 增加服务列表

![image-20200625115214924](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625115214924.png)

![image-20200625115154227](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625115154227.png)

# 增加启动类



![image-20200703100912208](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200703100912208.png)

# 最后效果

![image-20200625115634976](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200625115634976.png)

![image-20200703101047914](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200703101047914.png)

![image-20200703101118736](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200703101118736.png)

![image-20200703101229508](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200703101229508.png)

## swagger文档操作

![image-20200717172344988](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200717172344988.png)

登陆成功之后，就可以操作了。

![image-20200717172417701](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200717172417701.png)

![image-20200717172750450](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200717172750450.png)

# 部署服务器

## 启动nacos

这里我使用docker将nacos放到了服务器上。

[docker安装](https://gitee.com/cuixiaoyan/learningDocument/blob/master/docker/%E8%BD%AF%E4%BB%B6%E5%AE%89%E8%A3%85.md)

修改配置文件内，mysql，和redis的连接。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801110614506.png" alt="image-20200801110614506" style="zoom:50%;" />

## 启动sentinel-dashboard

需要注意的点，sentinel-dashboard默认端口为8080，这里我换成了8858，启动的时候注意一下。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801110949818.png" alt="image-20200801110949818" style="zoom:50%;" />

```bash
[root@VM_0_3_centos ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                              NAMES
494fb3e3daba        f293cf61b11c        "java -Djava.securit…"   11 minutes ago      Up 11 minutes       8719/tcp, 0.0.0.0:8858->8858/tcp   cxysentinel
5aeb3c13ad3c        46181cc6d16f        "bin/startup.sh"         24 minutes ago      Up 18 minutes       0.0.0.0:8848->8848/tcp             cxynacos
```

## 数据库配置

地址为服务器上的地址，或者公网可以访问到的地址。好几个位置都有。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801111307324.png" alt="image-20200801111307324" style="zoom:50%;" />

网关配置

![image-20200801111645143](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801111645143.png)

## 本地启动

测试通过。

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801112530873.png" alt="image-20200801112530873" style="zoom:50%;" />

## 后台docker启动

只启动关键三个，我内存太小了。人穷没得办法。不使用docker也一样，直接java -jar

<img src="https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801155130589.png" alt="image-20200801155130589" style="zoom:40%;" />

```bash
# 认证模块
FROM java:8
COPY *.jar /ruoyi-auth-2.0.0.jar
EXPOSE 9200
ENTRYPOINT ["nohup","java","-jar","ruoyi-auth-2.0.0.jar","&"]

docker build -t ruoyi-auth:1.0  .

docker run -d -p 9200:9200 --name ruoyi-auth 282141d39d42

# 网关模块
FROM java:8
COPY *.jar /ruoyi-gateway-2.0.0.jar
EXPOSE 8080
ENTRYPOINT ["nohup","java","-jar","ruoyi-gateway-2.0.0.jar","&"]

docker build -t ruoyi-gateway:1.0  .

docker run -d -p 8080:8080 --name ruoyi-gateway 282141d39d42

# 系统模块 
FROM java:8
COPY *.jar /ruoyi-modules-system-2.0.0.jar
EXPOSE 9201
ENTRYPOINT ["nohup","java","-jar","ruoyi-modules-system-2.0.0.jar","&"]

docker build -t ruoyi-modules-system:1.0  .

docker run -d -p 9201:9201 --name ruoyi-modules-system 41b02a4ea056

```

## 前台修改

换成服务器的地址，打包使用生产打包。

![image-20200801154116540](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801154116540.png)

### nginx修改

==特别提示端口后面的斜杠==

```bash
server {
    listen       80;
    # 如果没有域名，就使用你的ip
    server_name  cuixiaoyan.cn www.cuixiaoyan.cn;
    #charset koi8-r;
    #access_log  /var/log/nginx/host.access.log  main
    location / {
    # 静态文件地址。
        root   /usr/share/nginx/html;
        try_files $uri $uri/ /index.html;
            index  index.html index.htm;
    }
		location /prod-api/{
			proxy_set_header Host  $http_host;
			proxy_set_header X-Real-IP $remote_addr;
			proxy_set_header REMOTE-HOST $remote_addr;
			proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
			proxy_pass http://127.0.0.1:8080/; # 特别提示端口后面的斜杠，本机ip，或者公网都可以。
		}
    #error_page  404              /404.html;
    # redirect server error pages to the static page /50x.html
    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }
}
```

# 完结撒花

![image-20200801154658471](https://gitee.com/cuixiaoyan/uPic/raw/master/uPic/image-20200801154658471.png)

