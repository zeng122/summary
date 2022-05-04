package zzm.java.jvm.spi;


public class OracleDbc implements Idbc{
    @Override
    public void connection() {
        System.out.println("OracleDbc connection");
    }
}
