
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.ParcelSize;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/getParcelSize")
public class RestService {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getParcelSize(String input){

        ObjectMapper objectMapper = new ObjectMapper();
        ParcelSize parcelSize = new ParcelSize();
        try {
            parcelSize = objectMapper.readValue(input, ParcelSize.class);
        } catch (IOException e){
            e.printStackTrace();
        }

        parcelSize.setHeight(2);
        parcelSize.setWidth(2);
        parcelSize.setLength(3);
        parcelSize.setCategory("");

        dbHandler my_db = new dbHandler();
        parcelSize.setCategory(my_db.getSize(parcelSize.calculateGurtmas()));

        String result = null;
        try {
            result = objectMapper.writeValueAsString(parcelSize);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

}