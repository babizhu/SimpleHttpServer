package com.bbz.httpserver;

import java.io.*;
import java.util.Properties;

/**
 * user         LIUKUN
 * time         2014-4-7 13:38
 * <p/>
 * 服务器的整体配置文件
 */

public class ServerCfg{

    /**
     * 监听ip
     */
    public static final String IP;

    /**
     * 监听端口
     */
    public static final int PORT;


    /**
     * web的根目录
     */
    public static final String HOME_DIR;

    static{
        Properties prop = new Properties();

//            InputStream in = new BufferedInputStream( new FileInputStream( "resource/server.properties" ) );
//            prop.load( in );
//            in.close();
        try {
//            InputStream in = new BufferedInputStream( new FileInputStream( "resource/path.properties" ) );
//            prop.load( in );
//            in.close();
            File file = new File( "resource/server.properties" );
            FileInputStream inputStream = new FileInputStream( file );
            InputStreamReader streamReader = new InputStreamReader( inputStream );
            prop.load( streamReader );

            inputStream.close();
            streamReader.close();


        } catch( IOException e ) {
            e.printStackTrace();
        }
        IP = prop.getProperty( "ip" ).trim();
        PORT = Integer.parseInt( prop.getProperty( "port" ).trim() );
        HOME_DIR = prop.getProperty( "homeDir" ).trim();

    }

    public static void main( String[] args ){
        System.out.println( ServerCfg.HOME_DIR);
    }
}

