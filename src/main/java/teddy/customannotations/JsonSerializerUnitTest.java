package teddy.customannotations;

import static org.junit.Assert.assertEquals;

public class JsonSerializerUnitTest {


    public void testObjectSerialized() throws JsonSerializationException {

        Person person = new Person("teddy", "nguyen", "34");
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        String jsonString = converter.convertToJson(person);
        String expectedString = "{\"personAge\":\"34\",\"firstName\":\"Teddy\",\"lastName\":\"Nguyen\"}";
        assertEquals(expectedString, jsonString);
//        System.out.println(jsonString);
//        System.out.println(expectedString);
    }
}
