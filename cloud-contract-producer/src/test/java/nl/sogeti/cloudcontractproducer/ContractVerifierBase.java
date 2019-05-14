package nl.sogeti.cloudcontractproducer;


import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class ContractVerifierBase {

    @Autowired
    private ProducerController producerController;

    @Before
    public void setup() {
        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(producerController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@DirtiesContext
//@AutoConfigureMessageVerifier
//public class ContractVerifierBase {
//
//    @Autowired
//    private EvenOddController evenOddController;
//
//    @Before
//    public void setup() {
//        StandaloneMockMvcBuilder standaloneMockMvcBuilder
//                = MockMvcBuilders.standaloneSetup(evenOddController);
//        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
//    }
//}