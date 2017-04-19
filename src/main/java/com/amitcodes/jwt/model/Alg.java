package com.amitcodes.jwt.model;


import com.amitcodes.jwt.service.UnsupportedAlgorithmException;

public enum Alg {
    // Refer to: https://tools.ietf.org/html/rfc7519#section-8
    NONE( "NONE" ),    // none
    HS256( "HS256" ),  // HMAC SHA-256
    RS256( "RS256" ),  // RSASSA-PKCS1-v1_5 with SHA-256 hash
    ES256( "ES256" );  // ECDSA using the P-256 curve with SHA-256 hash
    
    private String value;
    
    private Alg(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    public static Alg fromValue(String value) {
        for( Alg alg : Alg.values() ) {
            if( alg.value.equalsIgnoreCase( value ) ) {
                return alg;
            }
        }
        
        throw new UnsupportedAlgorithmException( "Unknown algorithm: " + value );
    }
}
