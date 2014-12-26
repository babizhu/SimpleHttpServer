package com.bbz.httpserver;

import com.bbz.httpserver.server.HttpStaticFileServer;

/**
 * user         LIUKUN
 * time         2014-12-26 12:39
 */

public class Lancher{
    public static void main( String[] args ) throws Exception{
        new HttpStaticFileServer().run( );
    }
}
