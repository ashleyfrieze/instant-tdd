package uk.co.ashleyfrieze.springcontext.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.co.ashleyfrieze.springcontext.configuration.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class CountingServiceTest {
    @Autowired
    private CountingService countingService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextIsOk() {
        assertNotNull(countingService);
        assertNotNull(dataSource);
    }

    @Test
    public void whenNoItemsThenCountIsZero() {
        assertEquals(0, countingService.getCount());
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void whenOneItemThenCountIsOne() {
        dataSource.add("one");

        assertEquals(1, countingService.getCount());
    }
}
