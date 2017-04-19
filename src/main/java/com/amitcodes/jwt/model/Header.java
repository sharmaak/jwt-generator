package com.amitcodes.jwt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Header {
    
    @JsonProperty("typ")
    private String type;
    @JsonProperty("alg")
    private String algorithm;
    
    public Header() {
    }
    
    public String getType() {
        return type;
    }
    
    public Header setType(String type) {
        this.type = type;
        return this;
    }
    
    public String getAlgorithm() {
        return algorithm;
    }
    
    public Header setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Header{" );
        sb.append( "type='" ).append( type ).append( '\'' );
        sb.append( ", algorithm='" ).append( algorithm ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
