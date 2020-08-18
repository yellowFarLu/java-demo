package huangy.head_first.chain_pattern;


/**
 * 具体处理器.
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleRequest() {

        // 当前处理器处理
        System.out.println(this.toString()+"处理器处理");

        // 下一个处理器处理
        if (getNextHandler()!=null){
            getNextHandler().handleRequest();
        }
    }

}