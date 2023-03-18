


```shell

docker run --name mysql -p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_HOST=% ibex/debian-mysql-server-5.7

docker exec -it mysql bash 
mysql -uroot -p
// 输入 root 密码后回车

use mysql; 
select host from user where user='root'; 
update user set host = '%' where user ='root'; 
flush privileges;

```