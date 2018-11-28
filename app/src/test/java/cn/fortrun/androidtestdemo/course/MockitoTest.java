package cn.fortrun.androidtestdemo.course;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * description
 * https://static.javadoc.io/org.mockito/mockito-core/2.23.4/org/mockito/Mockito.html
 * @author tianyu
 * @create 2018.06.29 下午2:21
 * @since a.0.0
 */
public class MockitoTest {

    List mockedList;

    @Before
    public void before() {
        mockedList = mock(List.class);
    }

    @Test
    public void test() {
        // 验证行为
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();

        // 测试桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 参数匹配器，If you are using argument matchers, all arguments have to be provided by matchers.
        when(mockedList.get(anyInt())).thenReturn("element");


        // 验证确切的调用次数
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");

        // 为返回值为void的函数通过Stub抛出异常

        doThrow(new RuntimeException()).when(mockedList).clear();
//        mockedList.clear();


        // A. 验证mock一个对象的函数执行顺序
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        // 为该mock对象创建一个inOrder对象
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that insert is first called with "was added first, then with "was added second"
        // 确保add函数首先执行的是add("was added first"),然后才是add("was added second")
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        // B .验证多个mock对象的函数执行顺序
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        // 为这两个Mock对象创建inOrder对象
        inOrder = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        // 验证它们的执行顺序
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");


        // 7. 确保交互(interaction)操作不会执行在mock对象上

        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);
        List mockThree = mock(List.class);
        //using mocks - only mockOne is interacted
        // 使用Mock对象
        mockOne.add("one");

        //ordinary verification
        // 普通验证
        verify(mockOne).add("one");

        //verify that method was never called on a mock
        // 验证某个交互是否从未被执行
        verify(mockOne, never()).add("two");

        //verify that other mocks were not interacted
        // 验证mock对象没有交互过
        verifyZeroInteractions(mockTwo, mockThree);


        // 8. 查找冗余的调用

        //using mocks
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");

        //following verification will fail
        // 下面的验证将会失败
        verifyNoMoreInteractions(mockedList);


    // 9. 简化mock对象的创建
    //    使用@Mock注解

//    @Mock private ArticleCalculator calculator;
//    @Mock private ArticleDatabase database;
//    @Mock private UserProvider userProvider;

    // 10. 为连续的调用做测试桩 (stub)

//        when(mock.someMethod("some arg"))
//                .thenThrow(new RuntimeException())
//                .thenReturn("foo");
//
//        //First call: throws runtime exception:
//        // 第一次调用 : 抛出运行时异常
//        mock.someMethod("some arg");
//
//        //Second call: prints "foo"
//        // 第二次调用 : 输出"foo"
//        System.out.println(mock.someMethod("some arg"));
//
//        //Any consecutive call: prints "foo" as well (last stubbing wins).
//        // 后续调用 : 也是输出"foo"
//        System.out.println(mock.someMethod("some arg"));

        // 对返回结果进行拦截

//        when(mock.someMethod(anyString())).thenAnswer(
//                new Answer() {
//                    public Object answer(InvocationOnMock invocation) {
//                        Object[] args = invocation.getArguments();
//                        Object mock = invocation.getMock();
//                        return "called with arguments: " + Arrays.toString(args);
//                    }
//                });
//
//        //Following prints "called with arguments: [foo]"
//        System.out.println(mock.someMethod("foo"));

        // 暗中调用真实对象
        List list = new LinkedList();
        List spy = spy(list);
//optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);
//using the spy calls *real* methods
        spy.add("one");
        spy.add("two");
//prints "one" - the first element of a list
        System.out.println(spy.get(0));
//size() method was stubbed - 100 is printed
        System.out.println(spy.size());
//optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");

//        Foo mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);
//        Foo mockTwo = mock(Foo.class, new YourOwnAnswer());

    }
}
