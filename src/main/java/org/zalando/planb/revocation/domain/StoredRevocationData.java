package org.zalando.planb.revocation.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zalando.planb.revocation.util.UnixTimestamp;

/**
 * TODO: small javadoc
 *
 * @author  <a href="mailto:rodrigo.reis@zalando.de">Rodrigo Reis</a>
 */
@Data
@NoArgsConstructor
public class StoredRevocationData extends RevocationData {

    @JsonProperty("revoked_at")
    private Integer revokedAt = UnixTimestamp.now();

    public StoredRevocationData(RevocationType type, RevokedData data, Integer revokedAt) {
        this.setType(type);
        this.setData(data);
        this.revokedAt = revokedAt;
    }

}
