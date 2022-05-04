package zzm.java.jvm.spi;

/**
 *
 * 在classPath 的META-INF/services目录下放置一个于接口同名的文本文件
 * 文本的内容为接口实现类
 * 多个实现类用换行符分割
 * 这个类被Application ClassLoader加载
 * 实现类什么时候加载？
 * 加载serviceLoader,这个系统类，应该是由Boot ClassLoader加载的
 * 但是serviceLoader去加载MysqlDbc并没有先自己加载，而是直接通过调用Application 加载的
 * 这里引入了LazyIterator
 * LazyIterator 在使用hasNext才会创建下一个
 *
 *
 */
public interface Idbc {

    void connection();
}
