package com.abhinav.sunbase.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(UUID id) {
        super("Could not find customer "+ id);
    }
}
