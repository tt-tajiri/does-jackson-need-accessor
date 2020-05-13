package tajiri.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class JacksonSerializeTest {

    @Test
    public void jacksonDoesNotNeedAccessorIfPublicField() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        MyAwesomeDto dto = new MyAwesomeDto();

        String dtoAsString = mapper.writeValueAsString(dto);

        assertThat(dtoAsString, not(containsString("privateStringValue")));
        assertThat(dtoAsString, containsString("publicStringValue"));
    }
}
