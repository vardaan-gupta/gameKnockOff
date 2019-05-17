package com.arena;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= com.arena.GameStarter.class)
public class GameServiceTest {
	@MockBean
	GameInitializer gameInit;
	
	@Test
	public void contextLoads() {
	}
	
	

}
