
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ChatbotData {
    private final Set<String> yesResponses;
    private final Set<String> noResponses;
    private final HashMap<String, List<String>> responses;
    private final HashMap<String, List<String>> reservations; 
    private final HashMap<String, List<String>> tableCoupleReservation;
    private final Set<String> tablePreference;
    private final HashMap<String, List<String>> tablePartyReservation;
    private int partyAmount;
    private String dateAndTime;
    private String specialRequests;
    private String tablePreferenceString;
    
    private String[] botMessage = new String[10];
    private String username;

    public ChatbotData() {
        yesResponses = new HashSet<>();
        noResponses = new HashSet<>();
        responses = new HashMap<>();
        reservations = new HashMap<>();
        tableCoupleReservation = new HashMap<>();
        tablePreference = new HashSet<>();
        tablePartyReservation = new HashMap<>();

        loadResponses();
        botMessage[0] = "I did not understand what you said. Can you please repeat that?\n> ";
        botMessage[1] = "Would you like a list of things I can assist you with?\n> ";
    }

    private void loadResponses() {
        // YES
        yesResponses.add("sure");
        yesResponses.add("okay");
        yesResponses.add("ok");
        yesResponses.add("hai");
        yesResponses.add("yur");

        // NO
        noResponses.add("no");
        noResponses.add("nah");
        noResponses.add("nope");
        noResponses.add("n");
        noResponses.add("not really");
        yesResponses.add("iie");

        // BASIC RESPONSES
        responses.put("hello", Arrays.asList("Hi! I am BOT Mika. Please check our list by typing list for all of our available choices.\n> ", "Irasshaimase! I am BOT Mika. Please check our list for all available choices.\n> "));
        responses.put("hi", Arrays.asList("Konnichiwa! I am BOT Mika. Please check our list by typing list for all of our available choices.\n> ", "Hello! I am BOT Mika. Please check our list for all available choices.\n> "));
        responses.put("list", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address\n What else do you need?\n"));
        responses.put("features", Arrays.asList("Here's the list of features available!\n> Restaurant description and information\n> Booking a reservation\n * Includes couple and party \n> Opening hours\n> Menu\n> Contact information\n - Telephone number\n - Email address\n - Address"));
        // OPERATING HOURS 
        responses.put("hours", Arrays.asList(""));
        responses.put("operating", Arrays.asList(""));
        // MENU
        responses.put("menu", Arrays.asList(""));
        responses.put("food", Arrays.asList(""));
        // RESERVATIONS
        reservations.put("reserve", Arrays.asList("Sure thing! Let me ask you something first though...", "Alrighty then! Let me ask you something first though..."));
        reservations.put("reservation", Arrays.asList("Sure thing! Let me ask you something first though...", "Alrighty then! Let me ask you something first though..."));
        
        // TABLE PREFERENCE 
        tableCoupleReservation.put("couple", Arrays.asList("Sure thing! Any preferences for your seats?\n", "Of course! Do you have any seating preferences?\n"));
        tablePartyReservation.put("party", Arrays.asList("How many poeple are attending?\n", "How many people are you reserving for?\n"));
        //tableCoupleReservationPref

        // TABLE PREFERENCE
        tablePreference.add("window");
        tablePreference.add("windowed");
        tablePreference.add("aisle");
        tablePreference.add("corner");
        tablePreference.add("booth");
        tablePreference.add("near entrance");
        tablePreference.add("quiet area");

        /*
         * add opening hours, operaitng hours, menu, address, list/features
         */
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getBotMessage(int number) {
        return botMessage[number];
    }

    public String[] getResponsesContent(){
        return responses.keySet().toArray(new String[0]);
    }

    public String[] getReservationsContents(){
        return reservations.keySet().toArray(new String[0]);
    }

    public String[] getYesResponsesContents(){
        return yesResponses.toArray(new String[0]);
    }

    public String[] getNoResponsesContents(){
        return noResponses.toArray(new String[0]);
    }

    public String[] getTableCoupleReservationContents(){
        return tableCoupleReservation.keySet().toArray(new String[0]);
    }

    public String[] getCoupleTablePreferenceContents(){
        return tablePreference.toArray(new String[0]);
    }

    public String[] getTablePartyReservationContents(){
        return tablePartyReservation.keySet().toArray(new String[0]);
    }

    public void setPartyAmount(int amount){
        this.partyAmount = amount;
    }

    public int getPartyAmount(){
        return partyAmount;
    }

    public String getDateAndTime(){
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime){
        this.dateAndTime = dateAndTime;
    }

    public void setSpecialRequests(String specialRequests){
        this.specialRequests = specialRequests;
    }
    
    public String getSpecialRequests(){
        return specialRequests;
    }

    public String getCoupleTablePreference(){
        return tablePreferenceString;
    }

    public String getResponseStart(String userResponse) {
        for (String chatContent : responses.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = responses.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        for (String chatContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatContent)) {
                    List<String> chat = reservations.get(chatContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }
        return botMessage[0];
    }

    public String getReservationResponse(String userResponse){
        for (String chatReservationContent : reservations.keySet()){
            if (userResponse.toLowerCase().contains(chatReservationContent)) {
                    List<String> chat = reservations.get(chatReservationContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public String getTableCoupleReseravationResponse(String userResponse){
        for (String chatTableCoupleContent : tableCoupleReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTableCoupleContent)) {
                    List<String> chat = tableCoupleReservation.get(chatTableCoupleContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }

    public void setCoupleTablePreference(String userRespose){
        for (String preferenceContent : tablePreference){
            if(userRespose.toLowerCase().contains(preferenceContent)){
                this.tablePreferenceString = userRespose;
            }
        }
    }

    public String getTablePartyReseravationResponse(String userResponse){
        for (String chatTablePartyContent : tablePartyReservation.keySet()){
            if (userResponse.toLowerCase().contains(chatTablePartyContent)) {
                    List<String> chat = tablePartyReservation.get(chatTablePartyContent);
                    Random rng = new Random();
                    return chat.get(rng.nextInt(chat.size()));
                }
            }  
        return botMessage[0];
    }
}