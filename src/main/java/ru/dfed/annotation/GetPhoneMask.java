package ru.dfed.annotation;

import java.lang.annotation.Annotation;
import java.util.Set;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class GetPhoneMask implements Condition {

    private final Set<Class<? extends Annotation>> supportedFieldAnnotations;


    public GetPhoneMask(Set<Class<? extends Annotation>> supportedFieldAnnotations) {
        this.supportedFieldAnnotations = supportedFieldAnnotations;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
