package com.amitcodes.jwt.cli;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    private Map< String, String > args = new HashMap< String, String >();
    private Map< String, ArgumentMetadata > argsDefinitions = null;
    
    public Parser(String[] args) {
        if( args == null ) {
            return;
        }
        
        // load the args.json from classpath
        loadArgDefinitionFromJson();
        
        String current, next;
        for( int i = 0; i < args.length; i = i + 2 ) {
            current = args[i];
            next = i + 1 < args.length ? args[i + 1] : null;
            
            if( argsDefinitions.containsKey( current ) && next != null ) {
                this.args.put( current, next );
            }
        }
    }
    
    private void loadArgDefinitionFromJson() {
        InputStream in = null;
        ArgumentMetadata[] result = null;
        try {
            in = this.getClass().getClassLoader().getResourceAsStream( "args.json" );
            ObjectMapper mapper = new ObjectMapper();
            //noinspection unchecked
            result = mapper.readValue( in, ArgumentMetadata[].class );
        } catch( IOException e ) {
            throw new InitializationException( "Failed to initialize cli", e );
        } finally {
            if( in != null ) {
                try {
                    in.close();
                } catch( IOException e ) {
                    // muffle
                }
            }
        }
        
        
        argsDefinitions = new HashMap< String, ArgumentMetadata >();
        for( ArgumentMetadata m : result ) {
            argsDefinitions.put( m.getName(), m );
        }
    }
    
    public boolean validateMandatoryArgs() {
        // At least one mandatory param should be missing
        for( String argName : argsDefinitions.keySet() ) {
            if( argsDefinitions.get( argName ).isMandatory() && !args.containsKey( argName ) ) {
                return false;
            }
        }
        
        return true;
    }
    
    public String getArgsForHelp() {
        StringBuilder b = new StringBuilder("\n");
        ArgumentMetadata definition;
        for( String argName : argsDefinitions.keySet() ) {
            definition = argsDefinitions.get( argName );
            
            b.append( argName ).append( " : " ).append( definition.getDescription() );
            if( definition.isMandatory() ) {
                b.append( ". Is mandatory." );
            }
            b.append( "\n" );
        }
        
        return b.toString();
    }
    
    public Map< String, String > getArgs() {
        return this.args;
    }
}
