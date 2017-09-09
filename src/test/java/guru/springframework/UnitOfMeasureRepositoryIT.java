package guru.springframework;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Before
	public void setUp(){
		
	}
	@Test
	public void findByDescription() throws Exception{
		Optional<UnitOfMeasure> findByDescription = unitOfMeasureRepository.findByDescription("Teaspoon");
	    Assert.assertEquals("Teaspoon", findByDescription.get().getDescription());
	}
	@Test
	public void findByDescriptionCup() throws Exception{
		Optional<UnitOfMeasure> findByDescription = unitOfMeasureRepository.findByDescription("Cup");
	    Assert.assertEquals("Cup", findByDescription.get().getDescription());
	}
}
