import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Contact extends ChatbotData {
    private final HashMap<String, List<String>> contact;
    
    public Contact() {
        contact = new HashMap<>();
        contact.put("contact", Arrays.asList("Kyoto's Finest's contact information includes:\n - Telephone number: +81 0123 456 789\n - Email address: kyotosfinest@gmail.com\n - Address: 21 Saiinnakamizucho, Ukyo Ward, Kyoto, 615-0043, Japan\n\nIs there anything else you need?\n> "));
        contact.put("email", Arrays.asList("Kyoto's Finest's email address is: kyotosfinest@gmail.com\n\nIs there anything else you need?\n> "));
        contact.put("address", Arrays.asList("Kyoto's Finest's address is: 21 Saiinnakamizucho, Ukyo Ward, Kyoto, 615-0043, Japan\n\nIs there anything else you need?\n> "));
        contact.put("telephone", Arrays.asList("Kyoto's Finest's telephone number is: +81 0123 456 789\n\nIs there anything else you need?\n> "));
        contact.put("phone", Arrays.asList("Kyoto's Finest's telephone number is: +81 0123 456 789\n\nIs there anything else you need?\n> "));
        contact.put("number", Arrays.asList("Kyoto's Finest's telephone number is: +81 0123 456 789\n\nIs there anything else you need?\n> "));
    }

    @Override
    public String[] getResponsesContent(){
        return contact.keySet().toArray(new String[0]);
    }
}