package com.amitcodes.jwt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude( Include.NON_NULL)
public class Payload {
    @JsonProperty("iss")
    private String issuer;
    @JsonProperty("sub")
    private String subject;
    @JsonProperty("aud")
    private String audience;
    @JsonProperty("exp")
    private Long expirationTime;
    @JsonProperty("nbf")
    private Long notBefore;
    @JsonProperty("iat")
    private Long issuedAt;
    @JsonProperty("jti")
    private String jwtId;
    
    public Payload() {
    }
    
    public String getIssuer() {
        return issuer;
    }
    
    public Payload setIssuer(String issuer) {
        this.issuer = issuer;
        return this;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public Payload setSubject(String subject) {
        this.subject = subject;
        return this;
    }
    
    public String getAudience() {
        return audience;
    }
    
    public Payload setAudience(String audience) {
        this.audience = audience;
        return this;
    }
    
    public Long getExpirationTime() {
        return expirationTime;
    }
    
    public Payload setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }
    
    public Long getNotBefore() {
        return notBefore;
    }
    
    public Payload setNotBefore(Long notBefore) {
        this.notBefore = notBefore;
        return this;
    }
    
    public Long getIssuedAt() {
        return issuedAt;
    }
    
    public Payload setIssuedAt(Long issuedAt) {
        this.issuedAt = issuedAt;
        return this;
    }
    
    public String getJwtId() {
        return jwtId;
    }
    
    public Payload setJwtId(String jwtId) {
        this.jwtId = jwtId;
        return this;
    }
        
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Payload{" );
        sb.append( "issuer='" ).append( issuer ).append( '\'' );
        sb.append( ", subject='" ).append( subject ).append( '\'' );
        sb.append( ", audience='" ).append( audience ).append( '\'' );
        sb.append( ", expirationTime=" ).append( expirationTime );
        sb.append( ", notBefore=" ).append( notBefore );
        sb.append( ", issuedAt=" ).append( issuedAt );
        sb.append( ", jwtId='" ).append( jwtId ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
