package teddy.customannotations;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonSerializerUnitTest test = new JsonSerializerUnitTest();
		try {
			test.testObjectSerialized();
		} catch (JsonSerializationException ex) {
			System.out.print(ex.getMessage());
		}

	}


}
