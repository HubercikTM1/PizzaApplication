package pl.hubert.pizzaapplication.domain.service;

import pl.hubert.pizzaapplication.domain.exception.UnauthorizedException;

public class AuthorizationService {

    public static void checkToken(String token) {
        if(token == null || token.equals("xzv")) {
            throw new UnauthorizedException("Błędny token");
        }
    }
}
