package huangy.head_first.chain_pattern;

/**
 * 测试
 */
public class Client {

    public static void main(String[] args) {

        Handler h1 = new ConcreteHandler();
        Handler h2 = new ConcreteHandler();
        // h1的下一个处理器是h2
        h1.setNextHandler(h2);

        h1.handleRequest();
    }
}
