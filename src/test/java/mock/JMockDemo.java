package mock;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huangy on 2020-02-23
 */

public class JMockDemo {

    @Test
    public void mockProcessTest(final @Mocked PersonService target) {

        // 录制预期行为
        new Expectations(){
            {
                target.showName(anyString);
                result = "test1";
                target.showAge(anyInt);
                result = -1;
            }
        };

        // 调用被测试的代码，即回放
        Assert.assertTrue("test1".equals(target.showName("test2")));
        Assert.assertTrue(-1 == target.showAge(12));
        Assert.assertTrue(-1 == target.showAge(12));

        // 验证
        new Verifications(){
            {
                target.showAge(12);
                times = 2; // 检查showAge方法是否执行了2次

                target.showName("test1");
                times = 0; // 检查showName执行了0次。   只有入参和回放的入参一致时，才会计数
            }
        };
    }

}
