import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;

/**
 * @author: jian wang
 *
 */
public abstract class NaturalNumberTest {
    //protected abstract used to be able to use all naturalnumber3test code
    protected abstract NaturalNumber constructorTest();

    protected abstract NaturalNumber constructorTest(int i);

    protected abstract NaturalNumber constructorTest(String s);

    protected abstract NaturalNumber constructorTest(NaturalNumber n);

    protected abstract NaturalNumber constructorRef();

    protected abstract NaturalNumber constructorRef(int i);

    protected abstract NaturalNumber constructorRef(String s);

    protected abstract NaturalNumber constructorRef(NaturalNumber n);

    //test empty constructor
    @Test
    public void testConstructorEmpty() {
        // Create instances
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef();
        // Assert equality
        assertEquals(n, nExpected);
    }

    //test constructor with pos int
    @Test
    public void testConstructorIntPositive() {
        // Create instances
        int i = 1;
        NaturalNumber n = this.constructorTest(i);
        NaturalNumber nExpected = this.constructorRef(i);
        // Assert equality
        assertEquals(n, nExpected);
    }

    //test constructor with 0
    @Test
    public void testConstructorIntZero() {
        // Create instances
        int i = 0;
        NaturalNumber n = this.constructorTest(i);
        NaturalNumber nExpected = this.constructorRef(i);
        // Assert equality
        assertEquals(n, nExpected);
    }

    //test constructor with max int/edge case
    @Test
    public void testConstructorIntMax() {
        // Create instances
        int i = Integer.MAX_VALUE;
        NaturalNumber n = this.constructorTest(i);
        NaturalNumber nExpected = this.constructorRef(i);
        // Assert equality
        assertEquals(n, nExpected);
    }

    //test constructor with str
    @Test
    public void testConstructorString() {
        // Create instances
        String s = "645";
        NaturalNumber n = this.constructorTest(s);
        NaturalNumber nExpected = this.constructorRef(s);
        // Assert equality
        assertEquals(n, nExpected);
    }

    //test constructor with empty str
    @Test
    public void testConstructorStringEmpty() {
        // Create instances
        String s = "0";
        NaturalNumber n = this.constructorTest(s);
        NaturalNumber nExpected = this.constructorRef(s);
        // Assert equality
        assertEquals(n, nExpected);
    }

    //test constructor with NN
    @Test
    public void testConstructorNN() {
        // Create instances
        String s = "123";
        System.out.println(s);
        NaturalNumber test = this.constructorTest(s);
        System.out.println(test);
        NaturalNumber test2 = this.constructorRef(s); //create a natural number
        System.out.println(test2);

        NaturalNumber n = this.constructorTest(test);
        NaturalNumber nExpected = this.constructorRef(test2); //test NN constructor
        // Assert equality
        assertEquals(n, nExpected);
        assertEquals(test, test2);

    }

    //test constructor with 0 NN
    @Test
    public void testConstructorNNZero() {
        // Create instances
        String s = "0";
        NaturalNumber test = this.constructorTest(s); // Create a natural number
        NaturalNumber test2 = this.constructorRef(s);

        NaturalNumber n = this.constructorTest(test); //test NN constructor
        NaturalNumber nExpected = this.constructorRef(test2);
        // Assert equality
        assertEquals(n, nExpected);
        assertEquals(test, test2);

    }

    //test *10 with empty
    @Test
    public void testMultiplyBy10Empty() {
        // Create instances
        NaturalNumber n = this.constructorTest();
        final int i = 5;
        NaturalNumber nExpected = this.constructorRef(i);
        // Call method
        n.multiplyBy10(i);
        // Assert equality
        assertEquals(nExpected, n);

    }

    //test *10 routine
    @Test
    public void testMultiplyBy10() {
        // Create instances
        NaturalNumber n = this.constructorTest(12);
        final int i = 3;
        NaturalNumber nExpected = this.constructorRef(123);
        // Call method
        n.multiplyBy10(i);
        // Assert equality
        assertEquals(nExpected, n);
    }

    //test /10 with smthing less than 10
    @Test
    public void testDivideBy10() {
        // Create instances
        NaturalNumber n = this.constructorTest(5);
        NaturalNumber nExpected1 = this.constructorRef(0);
        final int nExpected2 = 5;
        // Call method
        int n2 = n.divideBy10();
        // Assert equality
        assertEquals(nExpected1, n);
        assertEquals(nExpected2, n2);

    }

    //test /10 with 0
    @Test
    public void testDivideBy10Zero() {
        // Create instances
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected1 = this.constructorRef(0);
        final int nExpected2 = 0;
        // Call method
        int n2 = n.divideBy10();
        // Assert equality
        assertEquals(nExpected1, n);
        assertEquals(nExpected2, n2);

    }

    //test /10 with remainder at 0
    @Test
    public void testDivideBy10EndZero() {
        // Create instances
        NaturalNumber n = this.constructorTest(120);
        NaturalNumber nExpected1 = this.constructorRef(12);
        final int nExpected2 = 0;
        // Call method
        int n2 = n.divideBy10();
        // Assert equality
        assertEquals(nExpected1, n);
        assertEquals(nExpected2, n2);

    }

    //test /10 with routine test
    @Test
    public void testDivideBy10EndRoutine() {
        // Create instances
        NaturalNumber n = this.constructorTest(123);
        NaturalNumber nExpected1 = this.constructorRef(12);
        final int nExpected2 = 3;
        // Call method
        int n2 = n.divideBy10();
        // Assert equality
        assertEquals(nExpected1, n);
        assertEquals(nExpected2, n2);

    }

    //test is zero when true
    @Test
    public void testIsZeroTrue() {
        // Create instances
        NaturalNumber n = this.constructorTest();
        NaturalNumber nExpected = this.constructorRef();
        // Assert equality/call methods
        assertEquals(n, nExpected);
        assertTrue(n.isZero());
        assertTrue(nExpected.isZero());
    }

    //test is zero when false
    @Test
    public void testIsZeroFalse() {
        // Create instances
        NaturalNumber n = this.constructorTest(6);
        NaturalNumber nExpected = this.constructorRef(6);
        // Assert equality/call methods
        assertEquals(n, nExpected);
        assertTrue(!n.isZero());
        assertTrue(!nExpected.isZero());
    }

}
