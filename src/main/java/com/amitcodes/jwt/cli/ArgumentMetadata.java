package com.amitcodes.jwt.cli;

public class ArgumentMetadata {
    
    private String name;
    private String defaultValue;
    private String description;
    private boolean mandatory;
    
    public ArgumentMetadata() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDefaultValue() {
        return defaultValue;
    }
    
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isMandatory() {
        return mandatory;
    }
    
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "ArgumentMetadata{" );
        sb.append( "name='" ).append( name ).append( '\'' );
        sb.append( ", defaultValue='" ).append( defaultValue ).append( '\'' );
        sb.append( ", description='" ).append( description ).append( '\'' );
        sb.append( ", mandatory=" ).append( mandatory );
        sb.append( '}' );
        return sb.toString();
    }
}
