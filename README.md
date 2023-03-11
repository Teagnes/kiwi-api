# kiwi-api
后台管理模块


## docker
### mysql 数据库
```shell
# 构建镜像
docker build -t init_mysql:v0.1 .

# 查看镜像
docker images | grep init_mysql

# 创建容器
docker run -itd  --name mysql-rbac -p 3306:3306 -e  TZ=Asia/Shanghai -e  MYSQL_ROOT_PASSWORD=root -d init_mysql:v0.1
```