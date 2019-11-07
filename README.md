# SpringBoot4Oracle
在使用navicate对mysql数据库进行可视化管理时，报错，错误编号2059：authentication plugin 'caching_sha2_password'
出现此错误的原因为MySQL8.0之前使用mysql_native_password方式进行加密，现在使用caching_sha2_password版本加密（对！就是报错的那个东西）。所以只需把MySQL的加密方式改回mysql_native_password就可以啦。

输入如下代码，更改加密方式，并设置密码为123456。
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';

mysql -h localhost -u root -p

show databases;

并配置环境变量
