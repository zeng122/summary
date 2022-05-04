package zzm.java.jvm.spi;

public class MySQLDbc implements Idbc{
    @Override
    public void connection() {
        System.out.println("MySQL dbc connection");
    }
}
