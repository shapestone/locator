package test.java.com.xlenc.locator.rest;

import java.lang.reflect.Field;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 3:03 PM
 */
public class BaseLocatorTest {

    public void setPrivateField(Object o, String fieldName, Object value) {
        try {
            Class<?> c = o.getClass();
            Field f = c.getDeclaredField(fieldName);
            f.setAccessible(true); // solution
            f.set(o,  value); // IllegalAccessException
            // production code should handle these exceptions more gracefully
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        } catch (IllegalArgumentException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }

}
