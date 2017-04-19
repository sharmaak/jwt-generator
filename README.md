# jwt-generator
Java uber jar to generate JWT tokens

## Help
    Usage: java -jar jwt-generator.jar <options>
        --sub : Tenant's user-id. Is mandatory.
        --sec : Tenant's secret key. Is mandatory.
        --alg : Encryption algorithm. Is mandatory.
        --exp : Token expiry duration in seconds. Is mandatory.
        --jti : REALDoc tenant id. Is mandatory.
        --verbose : If true, prints detailed information

## Generating JWT token
    $ java -jar jwt-generator.jar --alg HS256 --exp 120  --sub amit.official@gmail.com --sec 0d1201de-c0db-4198-9cfc-10d570cd4282 --jti 507f191e810c19729de860ea
    ewogICJ0eXAiIDogIkpXVCIsCiAgImFsZyIgOiAiSFMyNTYiCn0=.ewogICJzdWIiIDogImFtaXQub2ZmaWNpYWxAZ21haWwuY29tIiwKICAiZXhwIiA6IDE0OTI2MTAxNTgsCiAgImlhdCIgOiAxNDkyNjEwMDM4LAogICJqdGkiIDogIjUwN2YxOTFlODEwYzE5NzI5ZGU4NjBlYSIKfQ==.eHlqcIk/t2pbbcQZSi3x1dMwkPga5zLkegr2zu7M2hw=

## Generating JWT token with additional info
    $ java -jar jwt-generator.jar --alg HS256 --exp 120  --sub amit.official@gmail.com --sec 0d1201de-c0db-4198-9cfc-10d570cd4282 --jti 507f191e810c19729de860ea --verbose true
    Header:
    {
      "typ" : "JWT",
      "alg" : "HS256"
    }
    Payload:
    {
      "sub" : "amit.official@gmail.com",
      "exp" : 1492610187,
      "iat" : 1492610067,
      "jti" : "507f191e810c19729de860ea"
    }
    Signature:
    jf9n0fSrhPJj+EwKZs4GP3Eo4jICNdmafs3wVSdZeDE=

    ewogICJ0eXAiIDogIkpXVCIsCiAgImFsZyIgOiAiSFMyNTYiCn0=.ewogICJzdWIiIDogImFtaXQub2ZmaWNpYWxAZ21haWwuY29tIiwKICAiZXhwIiA6IDE0OTI2MTAxODcsCiAgImlhdCIgOiAxNDkyNjEwMDY3LAogICJqdGkiIDogIjUwN2YxOTFlODEwYzE5NzI5ZGU4NjBlYSIKfQ==.jf9n0fSrhPJj+EwKZs4GP3Eo4jICNdmafs3wVSdZeDE=
