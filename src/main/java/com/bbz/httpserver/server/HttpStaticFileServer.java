package com.bbz.httpserver.server;

/**
 * user         LIUKUN
 * time         2014-7-21 18:41
 */

import com.bbz.httpserver.ServerCfg;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
//import io.netty.handler.ssl.SslContext;
//import io.netty.handler.ssl.SslProvider;
//import io.netty.handler.ssl.util.SelfSignedCertificate;

public final class HttpStaticFileServer{

    static final boolean SSL = System.getProperty( "ssl" ) != null;

    public void run(  ) throws Exception{
        // Configure SSL.
        //final SslContext sslCtx;
//        if (SSL) {
//            SelfSignedCertificate ssc = new SelfSignedCertificate();
//            sslCtx = SslContext.newServerContext(SslProvider.JDK, ssc.certificate(), ssc.privateKey());
//        } else {
//            sslCtx = null;
//        }


        EventLoopGroup bossGroup = new NioEventLoopGroup( 1 );
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group( bossGroup, workerGroup )
                    .channel( NioServerSocketChannel.class )
                    .handler( new LoggingHandler( LogLevel.INFO ) )
                    .childHandler( new HttpStaticFileServerInitializer() );

            Channel ch = b.bind( ServerCfg.PORT ).sync().channel();

            System.err.println( "Open your web browser and navigate to " +
                    (SSL ? "https" : "http") + "://127.0.0.1:" + ServerCfg.PORT + '/' );

            ChannelFuture future = ch.closeFuture();
            future.sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}