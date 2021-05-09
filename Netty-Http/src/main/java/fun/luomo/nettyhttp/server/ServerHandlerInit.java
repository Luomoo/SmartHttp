package fun.luomo.nettyhttp.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.ssl.SslContext;


public class ServerHandlerInit extends ChannelInitializer<SocketChannel> {

    private final SslContext sslCtx;

    public ServerHandlerInit(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline ph = ch.pipeline();
        ph.addLast("decode", new HttpRequestDecoder());
        ph.addLast("encode", new HttpResponseEncoder());
        ph.addLast("aggregator", new HttpObjectAggregator(10 * 1024 * 1024));
        ph.addLast("compressor", new HttpContentCompressor (10 * 1024 * 1024));
    }
}
