********************************************
**db使用中遇到问题的解决方法**  2019/03/27 
********************************************
1. MySQL连接时，mysql的时区错误问题： The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one。    
    > **解决办法**：mysql的连接字符串中添加上&serverTimezone=GMT%2B8

2. Flowable-Modeler使用时，程序初始化时出现错误：Table act_ge_property doesn't exist
    > **解决办法**：mysql的连接字符串中添加上nullCatalogMeansCurrent=true，将schema默认设置为当前连接的schema. 

3. Flowable-Modeler使用时，对于BLOB类型的字段，使用Postgres时出现错误：org.postgresql.util.PSQLException: 不良的类型值 long :...
    > **解决办法** 配置MyBatis的blobType的类型，不同的数据库，jdbcType不同：
    - Postgres :  `<result property="bytes" column="COLUMNBLOB"  jdbcType="BINARY" />`
    - Oracle/MySQL : `<result property="bytes" column="COLUMNBLOB"  jdbcType="BLOB" />`,且 `INSERT INTO X (COLUMNBLOB) VALUES #bytes:BLOB#`

