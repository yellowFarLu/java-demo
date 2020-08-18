package huangy.hyinterface;

/**
 * @author huangy on 2019-04-06
 */
public class SimpleHolder {

    private Object obj;

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.setObj("item");
        String s = (String)holder.getObj();
    }
}
