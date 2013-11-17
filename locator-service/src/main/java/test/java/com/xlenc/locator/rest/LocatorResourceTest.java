package test.java.com.xlenc.locator.rest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.ws.rs.core.Response;

import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 8:49 AM
 */
public class LocatorResourceTest extends BaseLocatorTest {

    private LocatorPersistence locatorPersistence;

    @BeforeClass
    public void setUp() {
        this.locatorPersistence = mock(LocatorPersistence.class);
    }

    @Test
    public void testAddLocator() {

        final String locatorId = "1234567890", partyId = "1212312311231";

        final PostalStateImpl postalLocatorState = createPostalLocatorState(locatorId, partyId);
        final LocatorResource locatorResource = createLocatorResource(locatorPersistence);

        when(locatorPersistence.add(postalLocatorState)).thenReturn(postalLocatorState);

        final Response response = locatorResource.addSite(postalLocatorState);

        assertNotNull(response);

        @SuppressWarnings("unchecked")
        final Map<String, Object> responseEntityMap = (Map<String, Object>)response.getEntity();

        assertNotNull(responseEntityMap);

        assertFalse(responseEntityMap.isEmpty());

        assertEquals(responseEntityMap.get("id"), locatorId);
    }

    private LocatorResource createLocatorResource(final LocatorPersistence locatorPersistence) {
        final LocatorResource locatorResource = new LocatorResource();
        final LocatorService locatorService = new LocatorServiceImpl();
        setPrivateField(locatorResource, "locatorService", locatorService);
        setPrivateField(locatorService, "locatorPersistence", locatorPersistence);
        return locatorResource;
    }

    private PostalStateImpl createPostalLocatorState(final String locatorId, final String partyId) {
        final PostalStateImpl postalLocatorState = new PostalStateImpl(locatorId);
        postalLocatorState.setPartyId(partyId);

        final SiteStateImpl site = new SiteStateImpl();
        postalLocatorState.setSiteState(site);
        return postalLocatorState;
    }

}
