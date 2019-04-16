************************************************
**Http,Https, Http1.x与Http2.x的区别**   2018/12/04
************************************************
 1. **HTTP和HTTPS的区别**     
    - **HTTP协议**（HyperTextTransferProtocol，超文本传输协议）:一个基于TCP/IP的通信协议，用来传递数据，属于应用层的面向对象的协议。用于CS架构，浏览器作为HTTP客户端通过URL向HTTP服务器即Web服务器发送所有的请求。Web服务器根据接收到的请求后，向客户端发送响应信息。    
    - **HTTPS**（Secure Hypertext Transfer Protocol,安全超文本传输协议）: 一个安全通信通道，基于HTTP开发，使用安全套接字层（SSL）进行信息交换，是HTTP的安全版。
    - **两者区别**：HTTPS协议需要CA申请证书，且多数证书都需要收费；而HTTP运行在TCP之上，使用明文传输所有内容，HTTPS运行在SSL/TLS之上，SSL/TLS运行在TCP之上，所有的传输内容都是加密的；两者使用的连接方式不同，端口也不同，HTTP是80，HTTPS是443；HTTPS可以有效防止运营商劫持
   
2. **HTTP1.0、HTTP1.1和HTTP2.0的区别**
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
      
 
 3. **HTTP发展历史** 
      - HTTP1.0 --- (keep-alive;更多缓存策略；更多的错误处理；Host头；带宽优化) ---> HTTP 1.1 
      - HTTP1.1 --- (降低延迟；设置请求优先级；头部压缩；服务器推送；基于HTTPS加密传输) --> SPDY 
      - SPDY  --- (头部压缩算法不同；支持明文HTTP) ---> HTTP2.0
 
4. **SSL和TSL的区别**
      - SSL（Secure Sockets Layer，安全套接字层），
      - TLS（Transport Layer Security，安全传输层协议），该协议由两层组成：TLS记录协议和TLS握手协议。
          
- **Reference**   
  - [http与https的区别](http://www.cnblogs.com/wxlzhizu/archive/2009/12/09/1620005.html)
  - [TCP/IP、HTTP、HTTPS、HTTP2.0](https://www.cnblogs.com/w1570631036/p/8119747.html)
  - [谈谈HTTP1.0,HTTP1.1和HTTP2.0区别](https://segmentfault.com/a/1190000016496448)
  - [http的变迁（http1.0-http2.0，https）](https://www.jianshu.com/p/e38f69a0b91b) 



