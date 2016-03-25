package com.bbz.httpserver;

import com.bbz.httpserver.server.HttpStaticFileServer;

/**
 * user         LIUKUN
 * time         2014-12-26 12:39
 */

public class Launcher{
    public static void main( String[] args ) throws Exception{

        System.out.println( "HOME目录：" + ServerCfg.HOME_DIR);
        new HttpStaticFileServer().run( );
    }
}
