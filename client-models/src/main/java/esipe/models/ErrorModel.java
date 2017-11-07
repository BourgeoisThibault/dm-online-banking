package esipe.models;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author BOURGEOIS Thibault
 * Date     06/11/2017
 * Time     17:57
 */
@Data
@ToString
public class ErrorModel {
    private String errorTitle;

    public ErrorModel(String errorTitle) {
        this.errorTitle=errorTitle;
    }
    public ErrorModel() {

    }
}
