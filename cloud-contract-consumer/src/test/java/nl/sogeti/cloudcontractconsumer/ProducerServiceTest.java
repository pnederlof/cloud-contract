package nl.sogeti.cloudcontractconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.NONE)
@AutoConfigureStubRunner(ids = {"nl.sogeti:cloud-contract-producer:+:stubs:6565"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ProducerServiceTest {

    @Autowired
    RestTemplateBuilder testRestTemplate;

    @Test
    public void testResponseFromStub(){
        ProducerService producerService = new ProducerService(testRestTemplate);

        String actual = producerService.getGreetingFromProducer();

        assertThat(actual,is("Hello Consumer"));
    }

}
