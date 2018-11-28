package cn.fortrun.androidtestdemo.course;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertThat;

/**
 * description
 *
 * @author tianyu
 * @create 2018.11.25 08:57
 * @since 1.0.0
 */

public class JunitTest {
    /**
     * 作者：heiheiwanne
     * 链接：https://www.jianshu.com/p/31050cbd8c90
     * 來源：简书
     * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
     * assertTrue 判断是否为true。
     * assertFalse 判断是否为false。
     * assertSame 判断引用地址是否相等。
     * assertNotSame 判断引用地址是否不相等。
     * assertNull 判断是否为null
     * assertNotNull 判断是否不为null
     * assertEquals 判断是否相等
     * assertNotEquals 判断是否不相等
     * assertThat 条件判断断言
     */
    @Test
    public void test() {
        // 判断真假
        Assert.assertTrue(true);
        Assert.assertTrue("it isn't true", true);
        Assert.assertFalse(false);
        Assert.assertFalse("it isn't false", false);

        // 判断引用地址
        Assert.assertSame(this, this);
        Assert.assertNotSame(new Object(), new Object());

        // 判断是否为null
        Assert.assertNull(null);
        Assert.assertNull("it isn't null", null);
        Assert.assertNotNull(new Object());
        Assert.assertNotNull("it is null", new Object());

        // 判断是否相等
        Assert.assertEquals(1, 1);
        Assert.assertEquals(1f, 1f);
        Assert.assertEquals(true, true);
        Assert.assertEquals("ddddd", "ddddd");

        // 条件断言
        // 数值匹配
        assertThat(34, greaterThan(20));
        assertThat(34, greaterThanOrEqualTo(20));
        assertThat(34, lessThan(120));
        assertThat(34, lessThanOrEqualTo(120));


        // 测试所有条件必须成立
        assertThat(78, allOf(greaterThan(50), lessThan(100)));
        // 测试只要有一个条件成立
        assertThat(120, anyOf(greaterThanOrEqualTo(50), lessThanOrEqualTo(100)));
        // 测试无论什么条件成立(还没明白这个到底是什么意思)
        assertThat(34, anything());
        // 测试变量值等于指定值
        assertThat(100, is(100));
        // 测试变量不等于指定值
        assertThat(100, not(50));

        /*字符串匹配**/
        String url = "http://www.taobao.com";
        //测试变量是否包含指定字符
        assertThat(url, containsString("taobao"));
        //测试变量是否已指定字符串开头
        assertThat(url, startsWith("http://"));
        //测试变量是否以指定字符串结尾
        assertThat(url, endsWith(".com"));
        //测试变量是否等于指定字符串
        assertThat(url, equalTo("http://www.taobao.com"));
        //测试变量再忽略大小写的情况下是否等于指定字符串
        assertThat(url, equalToIgnoringCase("http://Www.taobao.com"));
        //测试变量再忽略头尾任意空格的情况下是否等于指定字符串
        assertThat(url, equalToIgnoringWhiteSpace("http://www.taobao.com"));

        /*集合匹配**/
        Object object1 = new Object();
        Object object2 = new Object();
        List<Object> user = new ArrayList<Object>();
        user.add(object1);
        user.add(object2);

        //测试集合中是否还有指定元素
        assertThat(user, hasItem(object1));
        assertThat(user, hasItem(object2));

        /*Map匹配**/
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("object1", object1);
        userMap.put("object2", object2);

        //测试map中是否还有指定键值对
        assertThat(userMap, hasEntry("object1", object1));
        //测试map中是否还有指定键
        assertThat(userMap, hasKey("object2"));
        //测试map中是否还有指定值
        assertThat(userMap, hasValue(object2));

    }
}
