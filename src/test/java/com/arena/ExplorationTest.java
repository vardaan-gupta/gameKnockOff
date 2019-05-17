package com.arena;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.arena.factory.ExplorationFactory;





@RunWith(SpringRunner.class)
@SpringBootTest
public class ExplorationTest {
	
	@Autowired
	ExplorationFactory factory;
	
	@MockBean
	GameInitializer gameInit;

	@Test
	public void testExplorationFactory() {
		assertEquals(3, factory.exploreWesteros().size());
	}

}
