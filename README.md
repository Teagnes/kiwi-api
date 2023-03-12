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


### elasticsearh
单节点
```shell
docker pull elasticsearch:7.17.7
docker run --name elasticsearch-7 -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -d elasticsearch:7.17.7

```