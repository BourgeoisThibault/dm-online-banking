package esipe.restutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.models.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author BOURGEOIS Thibault
 * Date     04/11/2017
 * Time     22:08
 */
public class RestManagement {

    private static String PARAM_URI_ROOT = "http://localhost";
    private static String PARAM_PORT = ":25003";
    private static String PARAM_PRIMARY = "/data-access/";

    public static ResponseEntity getResponse(String paramEndUri, Long value) throws IOException {

        String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri;

        if(value != null)
            myUri = myUri + value;

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity result = restTemplate.getForEntity(myUri,String.class);
            return result;
        } catch (RestClientResponseException e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getResponseBodyAsString(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }
    }

    public static <T> ResponseEntity postReponse(String paramEndUri, T newObject) throws IOException {
        String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri;

        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity result = restTemplate.postForEntity(myUri,newObject,String.class);
            return result;
        } catch (RestClientResponseException e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getResponseBodyAsString(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }

    public static <T> ResponseEntity putResponse(String paramEndUri, Long id, T newObject) throws IOException {
        String myUri = PARAM_URI_ROOT +
                PARAM_PORT +
                PARAM_PRIMARY +
                paramEndUri;

        if(id != null)
            myUri = myUri + id;

        RestTemplate restTemplate = new RestTemplate();

        try {
            restTemplate.put(myUri,newObject);
            return new ResponseEntity(HttpStatus.OK);
        } catch (RestClientResponseException e) {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorModel errorModel = objectMapper.readValue(e.getResponseBodyAsString(),ErrorModel.class);
            return new ResponseEntity(errorModel,HttpStatus.FORBIDDEN);
        }

    }

}
