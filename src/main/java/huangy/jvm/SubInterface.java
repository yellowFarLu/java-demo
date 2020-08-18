package huangy.jvm;

/**
 * 子接口
 * @author huangy on 2019-10-20
 */
public interface SubInterface extends SuperInterface {

    /**
     * 使用到父类的final静态常量
     */
    Node2 node2 = SuperInterface.tem;
}
