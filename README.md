# jwt-generator
Java uber jar to generate JWT tokens

    Usage: java -jar jwt-generator.jar <options>
        --sub : Tenant's user-id. Is mandatory.
        --sec : Tenant's secret key. Is mandatory.
        --alg : Encryption algorithm. Is mandatory.
        --exp : Token expiry duration in seconds. Is mandatory.
        --jti : REALDoc tenant id. Is mandatory.
        --verbose : If true, prints detailed information
