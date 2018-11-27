******************************************
**天猫研发4面题目**  2018/11/26
*****************************************
**一面**
 1. 常见集合类的区别和适用场景 
 2. 并发容器了解哪些  
  - 并发容器的原理，7大并发容器详解、及使用场景  : http://youzhixueyuan.com/use-of-concurrent-containers.html
  
 3. 如何判断链表是否有环  
 4. ConcurrentHashMap如何实现 
 - ConcurrentHashMap的实现原理(JDK1.7和JDK1.8) : http://youzhixueyuan.com/concurrenthashmap.html
 
 5. 集群服务器如何application共享  
 6. JVM网络编程中：BIO、NIO、AIO的区别和联系  
  - NIO、BIO、AIO的区别，及NIO的应用和框架选型 : http://youzhixueyuan.com/java-nio-introduce.html
 7. JVM内存模型   
  - 深入详解JVM内存模型与JVM参数详细配置 : http://youzhixueyuan.com/jvm-memory-model-and-parameter-configuration.html
 8. Java的垃圾回收，标记算法和复制算法的区别，用在什么场合  
  - JVM的4种垃圾回收算法、垃圾回收机制与总结 : http://youzhixueyuan.com/jvm-garbage-collection-algorithm.html
 9. HTTP和HTTPS的区别，HTTP1.x和HTTP2.x的区别，SSL和TSL的区别 
  - HTTP和HTTPS的区别     
    - **HTTP协议**（HyperTextTransferProtocol，超文本传输协议）:一个基于TCP/IP的通信协议，用来传递数据，属于应用层的面向对象的协议。用于CS架构，浏览器作为HTTP客户端通过URL向HTTP服务器即Web服务器发送所有的请求。Web服务器根据接收到的请求后，向客户端发送响应信息。    
    - **HTTPS**（Secure Hypertext Transfer Protocol,安全超文本传输协议）: 一个安全通信通道，基于HTTP开发，使用安全套接字层（SSL）进行信息交换，是HTTP的安全版。
    - **两者区别**：HTTPS协议需要CA申请证书，且多数证书都需要收费；而HTTP运行在TCP之上，使用明文传输所有内容，HTTPS运行在SSL/TLS之上，SSL/TLS运行在TCP之上，所有的传输内容都是加密的；两者使用的连接方式不同，端口也不同，HTTP是80，HTTPS是443；HTTPS可以有效防止运营商劫持
   
  - HTTP1.0、HTTP1.1和HTTP2.0的区别
    - **HTTP 1.0**（1996）：完成简单的网页上的请求，对延迟和带宽等还没做更多处理和优化
    - **HTTP 1.1**（1999）：在1.0的版本上做了很大优化，是目前应用最为广泛的，主要体现：
      - **缓存处理**：HTTP1.0中使用header的If-Modified-Since,Expires做缓存判断的标准，HTTP1.1 引入了更多缓存控制策略`Entity tag`,`If-Unmodified-Since`,`If-Match`,`If-None-Match`等更多可供选择的缓存头来控制缓存策略。
      - **带宽优化及网络连接的使用**：HTTP1.0中存在一些带宽浪费的现象，而HTTP1.1在请求头引入了`range`，允许只请求资源的某个部分，返回206，方便自由选择以便充分利用带宽和连接。
      - **错误通知的管理**：在HTTP1.1中新增了24个错误状态响应码。
      - **Host头处理**：在HTTP1.0中服务器绑定唯一IP，因此请求的URL中没有传递主机名，而目前情形是一台物理服务器上可以存在多个虚拟主机，且共享一个IP，HTTP1.1的请求消息是响应消息都支持Host头域，且请求消息中没有头域会报告错误400.
      - **长连接**：HTTP1.1支持长连接和请求的流水线处理，在一个TCP连接上可以传送多个HTTP请求和响应，减少了建立和关闭连接的消耗和延迟。
      
      
    - **HTTP 2.0**（2015）新特性：
      - **二进制帧** ： HTTP1.x的解析是基于文本的，文本表现形式多样，简装修扩展性场景更多，HTTP2将传输信息分割为更小的消息和帧，采用二进制编码。相对于HTTP1.x的头部信息封装到HEADER 帧中，相应的Request body封装在DATA frame中，不改动HTTP语义，使用二进制编码，实现方便且健壮。
      - **多路复用** ：所有的请求是通过一个TCP连接并发完成。HTTP1.x虽然通过pipeline也能并发请求，但多个请求之间的响应会被阻塞，而HTTP2使用多路复用，实现真正的并发请求，对于同一域名下的所有请求都是基于流的，不管对同一域名访问多少文件，也都只建立一路连接，还可以设置优先级。
      - **流量控制**：只有Data类型的frame才有flow control的功能，数据的接收方可以告知对方自己的flow window大小，表明自己还能接收多少数据
      - **服务器端推送**： 服务器可以对一个客户端请求发送多个响应，还可以额外向客户端推送资源，而无需客户端明确请求。
      - **首部压缩**：HTTP1.x的header带有大量信息，而且每次都会重复发送，HTTP2.0使用encoder来减少传输的header，在客户端和服务器端使用首部表来跟踪和存储之前发送的键值对，对于相同的数据，不再通过每次请求和响应发送。
      
    - SSL和TSL的区别
      - SSL（Secure Sockets Layer，安全套接字层），
      - TLS（Transport Layer Security，安全传输层协议），该协议由两层组成：TLS记录协议和TLS握手协议。
  
    - HTTP发展历史 
      - HTTP1.0 --- (keep-alive;更多缓存策略；更多的错误处理；Host头；带宽优化) ---> HTTP 1.1 
      - HTTP1.1 --- (降低延迟；设置请求优先级；头部压缩；服务器推送；基于HTTPS加密传输) --> SPDY 
      - SPDY  --- (头部压缩算法不同；支持明文HTTP) ---> HTTP2.0
   
    - Reference 
      - http与https的区别： http://www.cnblogs.com/wxlzhizu/archive/2009/12/09/1620005.html
      - TCP/IP、HTTP、HTTPS、HTTP2.0： https://www.cnblogs.com/w1570631036/p/8119747.html
      - 谈谈HTTP1.0,HTTP1.1和HTTP2.0区别：https://segmentfault.com/a/1190000016496448
      - http的变迁（http1.0-http2.0，https）：https://www.jianshu.com/p/e38f69a0b91b  
 10. GC、G1和ZGC的区别  
 11. B+树和B树的区别，和红黑树的区别  
 12. 内存泄露与内存溢出的区别 
 13. session生命周期是多久
    
**二面**
1. Java CAS原理
2. Java线程池有哪些参数，若涉及一个线程池要考虑哪些问题
3. Java的lock的底层实现
4. MySQL数据库默认存储引擎，有什么优点
5. MySQL的事务隔离级别是什么，分别解决什么问题
6. 四个表，记录成绩，每个大约十万条记录，如何找到成绩最好的同学
7. 常见的均衡负载算法有哪些
8. 如何Redis有1亿的key，使用keys命令是否会影响线上服务
9. Redis的持久化方式，aod和rdb，具体怎么实现，追加日志和备份文件，底层实现的原理了解否

**三面** 
1. 请画一个完整大型网站的分布式服务器集群部署图
2. 多个RPC请求进来，服务器怎么处理并发
3. 讲一下Redis的哨兵机制
4. 数据库分库分表一般数据库多大才需要     
  - 为何要分库分表和读写分离： 
    - 海量的数据的存储和访问称为系统的设计瓶颈
    - 日益增长的业务数据，对数据库造成了很大的负载
    - 对系统的稳定性和扩展性提出很高的要求      
   **分库分表和读写分离可以有效地减小单台数据库的压力**
   
  - 何为分区，分表，分库
    - **分区**：将一张表的数据分成N个区块，在逻辑上看最终是一张表，但底层是由N个物理区块组成的，分区实现比较简单，MySQL，oracle都很容易支持。
    - **分表**：将一张表按一定的规则分解成N个具有独立存储空间的实体表。系统读写时需要根据定义好的规则得到对应的字表明。
    
  - 何时考虑使用分区：一张表的查询速度已经慢到影响使用时
    - sql经过优化
    - 数据量大
    - 表中的数据是分段的
    - 对数据的操作往往只设计一部分数据，而不是所有的数据        
  **分区解决的问题是提升查询效率**
  
  - 何时考虑分表：
    - 一张表的查询速度已经慢到影响使用时
    - sql经过优化
    - 数据量大
    - 当频繁插入或者联合查询时，速度变慢
  - 分表解决的问题
    - 查询一次的时间短了
    - 数据分布在不同的文件，磁盘I/O性能提高
    - 读写锁影响的数据量变小
    - 插入数据库需要重新建立索引的数据减少
    
  - 常见分表、分库常用策略
    - 平均进行分配hash(object)%N，适用于简单架构；
    - 按照权重进行分配且均匀轮询；
    - 按照业务进行分配；
    - 按照一致性hash算法进行分配（适用于集群架构，在集群中节点的添加和删除不会造成数据丢失，方便数据迁移）
    
    https://www.2cto.com/database/201503/380348.html  
    https://blog.csdn.net/liangz/article/details/79352870     
    https://www.jianshu.com/p/89311703b320    
    http://youzhixueyuan.com/the-principle-of-separating-tables-reading-and-writing-and-using-scenarios.html  


5. 如何保证数据库与Redis缓存一致的
6. 项目中消息队列怎么用的，使用哪些具体业务场景
7. JVM相关的分析工具有使用过哪些，具体的性能调优步骤
  - 4大JVM性能分析工具详解，及内存泄漏分析方案 : http://youzhixueyuan.com/jvm-performance-analysis-tool.html
  - JVM性能调优的6大步骤，及关键调优参数详解 : http://youzhixueyuan.com/jvm-performance-optimization.html


8. MySQL的慢sql优化一般如何做，是否还有方法优化
9. 线上的服务器监控指标，哪些最需要关注，原因是什么
10. 如何做压力测试，抗压手段有哪些
11. 秒杀模块怎么设计的

**HR面**
1. 自我介绍
2. 怎么评价之前的面试
3. 怎么看待自己，最大的核心竞争力是什么
4. 未来自己的职业规划
5. 对阿里技术氛围有什么的理解，用过哪些阿里开源库
6. 期望薪资
7. 有什么想要了解的









