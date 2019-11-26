# hsqldbDemo

Hsql可用于集成测试中数据库的替代。

Hsql可以支持标准sql，同时有兼容模式，可以支持部分sql的特殊语法。

## MySql：
### 使用方式
``` 
sql.syntax_mys=true
```
### 不同的语法
|  语法   | Mysql  | Hsql ｜
|  ----  | ----  | ----  |
| update/set外键关联的id  | 报错 | 不报错 ｜
| IGNORE关键字去忽略外键关联报错  | 支持 | 不支持｜ 
