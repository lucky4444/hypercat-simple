package com.lbram.data.validator;

import com.lbram.data.entity.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by lbram on 26.05.2017.
 */
public class DescriptionValidatorTest {

  private Item item;

  @Before
  public void setup(){
    item = new Item();
  }

  @Test
  public void hasDescriptionRelation(){
    Set<ConstraintViolation<Item>> violations = validateClass(item);
    Assert.assertEquals(violations.size(), 0);
  }

  private Set<ConstraintViolation<Item>> validateClass(Item item) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<Item>> violations = validator.validate(item);
    return violations;
  }

}
