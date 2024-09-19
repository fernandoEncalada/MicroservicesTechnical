package com.microservice.account_microservice.domain.util;

import java.util.UUID;

public class Util {

    public static String generateAccountNumber() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}
