package com.amitcodes.jwt.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.BaseEncoding;

public class JWT {
    
    private Header header;
    private Payload payload;
    
    public JWT() {
    }
    
    public JWT(Header header, Payload payload) {
        this.header = header;
        this.payload = payload;
    }
    
    public Header getHeader() {
        return header;
    }
    
    public void setHeader(Header header) {
        this.header = header;
    }
    
    public Payload getPayload() {
        return payload;
    }
    
    public void setPayload(Payload payload) {
        this.payload = payload;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "JWT{" );
        sb.append( "header=" ).append( header );
        sb.append( ", payload=" ).append( payload );
        sb.append( '}' );
        return sb.toString();
    }
}
