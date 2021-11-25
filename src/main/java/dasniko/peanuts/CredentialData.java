package dasniko.peanuts;

import lombok.Value;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Value
public class CredentialData {
    // password = test
    String value = "/bVkHA4G/VOskjaCgNYyTz1BhgD+9X8bxCNEPGGpnDCJbWHDXIW0G8IlSBhDdJsXTjrXt/7yQguBwJ3sxSmSKA==";
    String salt = "lZtleWv1DeEcNIr8MTzdeg==";
    String algorithm = "pbkdf2-sha256";
    Integer iterations = 27500;
    String type = "password";
}
