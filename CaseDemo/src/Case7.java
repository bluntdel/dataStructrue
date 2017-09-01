import java.util.Stack;

/**
 * Created by blunt on 2017/8/30.
 */

/**
 * 两个栈实现队列
 */
public class Case7 {
    public static void main(String[] args) throws Exception {

        CQueue<Object> p7=new CQueue<>();
        p7.appendTail(1);
        p7.appendTail("2");
        p7.appendTail(3);
        p7.deleteHead();
    }
}

class CQueue<T>{
    private Stack<T> stack1 = new Stack<T>();
    private Stack<T> stack2 = new Stack<T>();

    public void appendTail(T t){
        stack1.push(t);
    }

    public T deleteHead() throws Exception {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()){
            throw new Exception("队列为空!");
        }

        return stack2.pop();
    }
}
