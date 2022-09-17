package se.lexicon.exercise_relational_mapping.extensions;


public class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException(String message) {
        super(message);
    }
}

