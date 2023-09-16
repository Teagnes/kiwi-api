# kiwi-api
后台管理模块


## docker
### mysql 数据库
```shell
# MAC
# 构建镜像
cd docker/db/mac
docker build -t kiwi_mysql:v0.1 .
# 查看镜像
docker images | grep kiwi_mysql
# 创建容器
docker run -itd  --name mysql-rbac -p 3306:3306 -e  TZ=Asia/Shanghai -e  MYSQL_ROOT_PASSWORD=root -d kiwi_mysql:v0.1

```


### elasticsearh
单节点
```shell
docker pull elasticsearch:7.17.7
docker run --name elasticsearch-7 -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -d elasticsearch:7.17.7

```

集成ik分词插件
```shell
apt-get update
apt-get install wget 

cd plugins
mkdir ik 
cd ik
wget https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.17.7/elasticsearch-analysis-ik-7.17.7.zip
unzip elasticsearch-analysis-ik-7.17.7.zip
rm elasticsearch-analysis-ik-7.17.7.zip
```


### elasticsearh-head
```shell

{
    "settings": {
        "index": {
            "number_of_shards": 1,
            "number_of_replicas": 1
        }
    },
    "mappings": {
        "_source": {
            "enabled": true
        },
        "properties": {
            "id": {
                "type": "integer"
            },
            "user_id": {
                "type": "integer"
            },
            "doc_name": {
                "type": "text",
                "analyzer": "ik_max_word",
                "search_analyzer": "ik_max_word"
            },
            "note_name": {
                "type": "text",
                "analyzer": "ik_max_word",
                "search_analyzer": "ik_max_word"
            },
            "doc_uuid": {
                "type": "keyword"
            },
            "version_uuid": {
                "type": "keyword"
            },
            "create_title": {
                "type": "date",
                "format": "yyyy-MM-dd HH:mm:ss||epoch_millis"
            },
            "update_time": {
                "type": "date",
                "format": "yyyy-MM-dd HH:mm:ss||epoch_millis"
            },
            "doc_content": {
                "type": "text",
                "analyzer": "ik_max_word",
                "search_analyzer": "ik_max_word"
            }
        }
    }
}
