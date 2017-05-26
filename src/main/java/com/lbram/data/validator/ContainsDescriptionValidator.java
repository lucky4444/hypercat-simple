package com.lbram.data.validator;

import com.lbram.data.entity.Relation;
import com.lbram.data.entity.StandardRelations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Checks if the list of relations contains exactly one relation of an english description
 * This is defined by the hypercat specification which can be found at
 * http://www.hypercat.io/uploads/1/2/4/4/12443814/hypercat_specification_3.00rc1-2016-02-23.pdf
 */
public class ContainsDescriptionValidator implements ConstraintValidator<ContainsDescription, List<Relation>> {
    @Override
    public void initialize(ContainsDescription containsDescription) {
    }

    @Override
    public boolean isValid(List<Relation> relations, ConstraintValidatorContext constraintValidatorContext) {
        if (relations == null || relations.size() == 0)
            return false;
        Long descriptionsCount = relations.stream().filter(r -> r.getRel().equals(StandardRelations.DESCRIPTION)).count();
        if (descriptionsCount != 1) {
            return false;
        } else {
            return true;
        }
    }
}
