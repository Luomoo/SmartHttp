package fun.luomo.nettyhttp.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;


public class HttpServer {
    //设置服务端端口
    public static final int port = 6789;
    // 通过nio方式来接收连接和处理连接
    private static EventLoopGroup group = new NioEventLoopGroup();
    private static ServerBootstrap b = new ServerBootstrap();
    private static final boolean SSL = false;

    /**
     * Netty创建全部都是实现自AbstractBootstrap。
     * 客户端的是Bootstrap，服务端的则是ServerBootstrap。
     **/
    public static void main(String[] args) throws Exception {
        final SslContext sslCtx = null;
        //TODO
        try {
            b.group(group);
            b.channel(NioServerSocketChannel.class);
            // 设置过滤器
            b.childHandler(new ServerHandlerInit(sslCtx));
            // 服务器绑定端口监听
            ChannelFuture f = b.bind(port).sync();
            System.out.println("服务端启动成功,端口是:" + port);
            // 监听服务器关闭监听
            f.channel().closeFuture().sync();
        } finally {
            //关闭EventLoopGroup，释放掉所有资源包括创建的线程
            group.shutdownGracefully();
        }
    }
}
