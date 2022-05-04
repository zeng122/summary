package zzm.java.jvm.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * spi代码，破坏双亲委派模型
 */
public class ServerLoadDemo {
    public static void main(String [] args){
        ServiceLoader<Idbc> loader = ServiceLoader.load(Idbc.class);
        try {
            Class.forName("zzm.java.jvm.spi.ServerLoadDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Iterator<Idbc> iterator = loader.iterator();
        while (iterator.hasNext()){
            iterator.next().connection();
        }
        for(Idbc idbc : loader){
            idbc.connection();
        }

    }
}
