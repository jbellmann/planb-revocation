package org.zalando.planb.revocation.persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.zalando.planb.revocation.domain.RevocationData;
import org.zalando.planb.revocation.domain.RevocationType;
import org.zalando.planb.revocation.util.UnixTimestamp;

import java.util.Collection;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Implementation class for In Memory store tests.
 *
 * @author  <a href="mailto:rodrigo.reis@zalando.de">Rodrigo Reis</a>
 */
@ActiveProfiles("test")
public class InMemoryRevocationStoreTest extends AbstractStoreTests {

    @Autowired
    RevocationStore revocationStore;

    @Test
    public void testInMemoryStore() throws InterruptedException {
        int timestamp = UnixTimestamp.now();

        revocationStore.storeRevocation(generateRevocation(RevocationType.TOKEN));

        Collection<RevocationData> revocations = revocationStore.getRevocations(timestamp-100);
        assertThat(revocations.size()).isNotZero();
    }
}
