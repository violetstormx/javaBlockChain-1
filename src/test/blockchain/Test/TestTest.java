package test.blockchain.Test; 

import blockchain.Utils.HashUtil;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Test Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 28, 2019</pre> 
* @version 1.0 
*/ 
public class TestTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Test() 
* 
*/ 
@Test
public void testTest() throws Exception {
    byte[] aaa = "aaaaaa".getBytes();
    System.out.println(HashUtil.HashSHA256(aaa));//TODO: Test goes here...
} 


} 
