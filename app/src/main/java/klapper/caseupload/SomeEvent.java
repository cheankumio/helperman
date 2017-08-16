package klapper.caseupload;

/**
 * Created by c1103304 on 2017/8/16.
 */

public class SomeEvent {
    private String message;

    public SomeEvent(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
