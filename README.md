# hsqldbDemo

Hsql可用于集成测试中数据库的替代。

Hsql可以支持标准sql，同时有兼容模式，可以支持部分sql的特殊语法。

## MySql：
### 使用方式
``` 
sql.syntax_mys=true
```
### 不同的语法
|  语法   | Mysql  | Hsql |
|  ----  | ----  | ----  |
| update/set外键关联的id  | 报错 | 不报错 |
| IGNORE关键字去忽略外键关联报错  | 支持 | 不支持|
| 格式不对的数据： '0000-00-00' 或者 '2001-00-00'  |可以存 | 不能存 |
| trim char value | 支持 | 不支持 |

## stub server
### Karate Netty
依赖：
```
        <dependency>
            <groupId>com.intuit.karate</groupId>
            <artifactId>karate-junit4</artifactId>
            <version>0.9.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.flywaydb.flyway-test-extensions</groupId>
            <artifactId>flyway-spring5-test</artifactId>
            <version>5.0.0</version>
            <scope>test</scope>
        </dependency>
```
demo：[KarateNettyTest](https://github.com/huleTW/hsqldbDemo/blob/master/src/test/java/com/hule/springboot/flyway/flywaytest/KarateNettyTest.java),[user-mock.feature](https://github.com/huleTW/hsqldbDemo/blob/master/src/test/resources/user-mock.feature)


