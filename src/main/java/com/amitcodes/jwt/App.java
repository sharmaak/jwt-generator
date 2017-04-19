package com.amitcodes.jwt;


import com.amitcodes.jwt.cli.Parser;
import com.amitcodes.jwt.model.Header;
import com.amitcodes.jwt.model.JWT;
import com.amitcodes.jwt.model.Payload;
import com.amitcodes.jwt.service.JWTTokenGenerator;

import java.util.Map;

public class App {
    
    public static void main(String[] args) {
        Parser parser = new Parser( args );
        if( !parser.validateMandatoryArgs() ) {
            System.out.println( "Usage: java -jar jwt-generator.jar <options>" + parser.getArgsForHelp() );
            System.exit( -1 );
        }
        new App().launch( parser.getArgs() );
    }
    
    private void launch(Map< String, String > args) {
        Header header = new Header().setAlgorithm( args.get( "--alg" ) ).setType( "JWT" );
        
        long issueTimeSecs = System.currentTimeMillis() / 1000L;
        long expiryTimeSecs = issueTimeSecs + Long.parseLong( args.get( "--exp" ) );
        Payload payload = new Payload().setIssuedAt( issueTimeSecs )
                                       .setExpirationTime( expiryTimeSecs )
                                       .setJwtId( args.get( "--jti" ) )
                                       .setSubject( args.get( "--sub" ) );
    
    
        JWT jwt = new JWT(header, payload);
        boolean verbose = Boolean.parseBoolean( args.get( "--verbose" ) );
        String secretKey = args.get( "--sec" );
        String token = new JWTTokenGenerator().generateToken( jwt, secretKey, verbose );
        System.out.print(token);
    }
    
    
}
