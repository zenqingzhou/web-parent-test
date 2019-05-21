package test.com.bidewu.web.controller;

import com.bidewu.web.WebApplicationServer;
import com.bidewu.web.TestService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* TestControllerTests Tester. 
* 
* @author <Authors name> 
* @since <pre>May 9, 2019</pre> 
* @version 1.0 
*/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplicationServer.class)
public class TestControllerTestsTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TestService testService;

@Before
public void before() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: testService() 
* 
*/ 
@Test
public void testTestService() throws Exception { 
//TODO: Test goes here...
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn();
    int status = mvcResult.getResponse().getStatus();
    String contentAsString = mvcResult.getResponse().getContentAsString();
    Assert.assertEquals("请求错误",200,status);
    Assert.assertEquals("返回结果不一致","success: nice",contentAsString);
} 
}
