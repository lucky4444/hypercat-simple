package com.lbram.data.validator;

import com.lbram.data.entity.Relation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by lbram on 26.05.2017.
 */
public class ContainsDescriptionValidator implements ConstraintValidator<ContainsDescription,List<Relation>> {
  @Override
  public void initialize(ContainsDescription containsDescription) {
  }

  @Override
  public boolean isValid(List<Relation> relations, ConstraintValidatorContext constraintValidatorContext) {
    if (relations == null || relations.size() == 0)
      return false;
    Long descriptionsCount = relations.stream().filter( r -> r.getRel().equals(Relation.REL_DESCRIPTION)).count();
    if (descriptionsCount != 1){
      return false;
    }else{
      return true;
    }
  }
}
