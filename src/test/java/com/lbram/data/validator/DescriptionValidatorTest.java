package com.lbram.data.validator;

import com.lbram.data.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DescriptionValidatorTest {

    @Test
    public void hasDescriptionRelation() {
        Item item = new Item("bla", "Test Description");
        Set<ConstraintViolation<Item>> violations = validateClass(item);
        Assert.assertEquals(violations.size(), 0);
    }

    public void hasNoDescriptionRelation() {
        Item item = new Item();
        Set<ConstraintViolation<Item>> violations = validateClass(item);
        Assert.assertNotEquals(violations.size(), 0);
    }

    private Set<ConstraintViolation<Item>> validateClass(Item item) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        return violations;
    }

}
