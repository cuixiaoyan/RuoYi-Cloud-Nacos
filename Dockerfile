# 认证模块
FROM java:8
COPY *.jar /ruoyi-auth-2.0.0.jar
EXPOSE 9200
ENTRYPOINT ["nohup","java","-jar","ruoyi-auth-2.0.0.jar","&"]
