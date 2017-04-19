package com.amitcodes;

import com.amitcodes.jwt.model.Header;
import com.amitcodes.jwt.model.JWT;
import com.amitcodes.jwt.model.Payload;
import com.amitcodes.jwt.service.JWTTokenGenerator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest{
    public static void main(String[] args) {
        Header header = new Header().setType( "JWT" ).setAlgorithm( "HS256" );
        Payload payload = new Payload().setSubject( "kofaxuqa1@gmail.com" )
                                       .setJwtId( "57ee11aa77a5643b28075f3c" )
                                       .setIssuedAt( 1492560000L )
                                       .setExpirationTime( 1492596000L );
        JWT jwt = new JWT( header, payload );
        String jwtToken = new JWTTokenGenerator().generateToken( jwt, "accd1234", true );
        System.out.println(jwtToken);
    }
}
