package com.amitcodes.jwt.service;

import com.amitcodes.jwt.model.Alg;
import com.amitcodes.jwt.model.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;

import java.io.UnsupportedEncodingException;

public class JWTTokenGenerator {
    
    public JWTTokenGenerator() {
    }
    
    public String generateToken(JWT jwt, String secret, boolean printJSONs) {
        final ObjectMapper mapper = new ObjectMapper().configure( SerializationFeature.INDENT_OUTPUT, true );
        
        String payloadBase64Encoded;
        String signatureBase64Encoded;
        String headerBase64Encoded;
        try {
            String headerJson = mapper.writeValueAsString( jwt.getHeader() );
            String payloadJson = mapper.writeValueAsString( jwt.getPayload() );
            headerBase64Encoded = BaseEncoding.base64().encode( headerJson.getBytes( "UTF-8" ) );
            payloadBase64Encoded = BaseEncoding.base64().encode( payloadJson.getBytes( "UTF-8" ) );
            Alg alg = Alg.fromValue( jwt.getHeader().getAlgorithm() );
            byte[] signature = generateSignature( alg, headerBase64Encoded + "." + payloadBase64Encoded, secret );
            signatureBase64Encoded = BaseEncoding.base64().encode( signature );
            
            if(printJSONs) {
                System.out.println(String.format( "Header:\n%s\nPayload:\n%s\nSignature:\n%s\n",
                                                  headerJson, payloadJson, signatureBase64Encoded));
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate token", e);
        }
        return headerBase64Encoded + "." + payloadBase64Encoded + "." + signatureBase64Encoded;
    }
    
    private byte[] generateSignature(Alg alg, String msg, String secret) throws UnsupportedEncodingException {
        
        switch( alg ) {
            case NONE:
                return "".getBytes( "UTF-8" ); // Empty string, if alg = NONE.
            case HS256:
                return Hashing.hmacSha256( secret.getBytes( "UTF-8" ) ).hashBytes( msg.getBytes( "UTF-8" ) ).asBytes();
            case ES256:
            case RS256:
            default:
                throw new UnsupportedAlgorithmException("Algorithm not implemented: " + alg.getValue());
        }
        
    }
}
