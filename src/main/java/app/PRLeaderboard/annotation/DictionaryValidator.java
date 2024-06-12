package app.PRLeaderboard.annotation;

import app.PRLeaderboard.repository.DictionaryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class DictionaryValidator implements ConstraintValidator<Dictionary, String> {

    private String dictionaryName;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public void initialize(Dictionary constraintAnnotation) {
        this.dictionaryName = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return dictionaryRepository.existsInDictionary(dictionaryName, value);
    }
}