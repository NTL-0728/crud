package com.example.demo.predicatebuilder;

import com.example.demo.document.QStudent;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class TeacherPredicatebuilder {
    public static Predicate search(String search) {

        QStudent qStudent = QStudent.student;
        BooleanExpression booleanExpression = qStudent.id.isNotNull();
        if(search != null)
        {
            booleanExpression = booleanExpression.and(qStudent.name.containsIgnoreCase(search));
        }
        return  booleanExpression;
    }
}
