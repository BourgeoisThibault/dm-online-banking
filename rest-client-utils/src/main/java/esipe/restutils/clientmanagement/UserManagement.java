package esipe.restutils.clientmanagement;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     04/11/2017
 * Time     22:08
 */
public class UserManagement {

    private static String PARAM_URI_ROOT = "http://localhost";
    private static String PARAM_PORT = ":25003";
    private static String PARAM_PRIMARY = "/data-access/";

    public static <T> T getMethode(String paramEndUri, Long value, Class<T> theClass) {

        final String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri +
                value;

        RestTemplate restTemplate = new RestTemplate();

        try {
            T result = restTemplate.getForObject(myUri,theClass);
            return result;
        } catch (Throwable throwable) {
            return null;
        }
    }

    public static <T> List<T> getListMethode(String paramEndUri) {

        final String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri;

        RestTemplate restTemplate = new RestTemplate();

        try {
            ArrayList<T> result = restTemplate.getForObject(myUri,new ArrayList<T>().getClass());
            return result;
        } catch (Throwable throwable) {
            return new ArrayList<T>();
        }
    }

    public static <T> T postMethode(String paramEndUri, T newObject, Class<T> theClass) {

        final String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri;

        RestTemplate restTemplate = new RestTemplate();

        try {
            T result = restTemplate.postForObject(myUri, newObject, theClass);
            return result;
        } catch (Throwable throwable) {
            return null;
        }
    }

    public static <T> void putMethode(String paramEndUri, Long id, T newObject) {

        String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri;

        if(id != null)
            myUri = myUri + id;

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.put(myUri, newObject);
    }

}
