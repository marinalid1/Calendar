import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Calendar {
    // sets userFirstName
    private static String userFirstName = "Matt";
    // creates calendar HashMap
    private static Map<String, String> calendar = new HashMap<>();

    // main method calls startCalendar
    public static void main(String[] args) {
        startCalendar();
    }

    // welcome method
    public static void welcome() throws InterruptedException {
        // print out welcome message
        System.out.println("Hello " + userFirstName);
        // lets user know the calendar program is opening
        System.out.println("Opening Calendar...");
        // sleep for 1 second
        Thread.sleep(1000);

        // dateFormat variable gets date and formats it 
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM dd yy");
        // create new Date object
        Date date = new Date();
        // print out date
        System.out.println("Today is: " + dateFormat.format(date));
        // timeFormat gets time and formats it
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh: mm: ss");
        // print out current time
        System.out.println("Time is: " + timeFormat.format(date));
        // sleep for 1 second
        Thread.sleep(1000);
        // print out asking user what they would like to do
        System.out.println("What would you like to do?");
    }

    public static void startCalendar() {
        try {
           // new scanner to get input
            Scanner scanner = new Scanner(System.in);
            // call welcome method
            welcome();
            // boolean start
            boolean start = true;

            // while start is true
            while (start) {
                // print out menu of choices
                System.out.println("A to Add, U to Update, V to View, D to Delete, X to Exit: ");
                // user_choice variable stores inputed character
                String userChoice = scanner.nextLine();
                // converts user choice character to upper
                userChoice = userChoice.toUpperCase();
                // if user choice is view
                if (userChoice.equals("V")) {
                    // if calendar is less than 1
                    if (calendar.keySet().size() < 1) {
                        // print Calendar is empty
                        System.out.println("Calendar is empty");
                    } 
                    // if calendar is greater or equal to 1
                    else {
                        // print out calendar
                        System.out.println(calendar);
                    }
                }
                // if user_choice is update
                else if (userChoice.equals("U")) {
                    // asks the user what date they wish to modify
                    System.out.println("What date? ");
                    // date gets the date the user whishes to modify
                    String date = scanner.nextLine();
                    // asks the user to add the updated information
                    System.out.println("Enter the update: ");
                    // update gets the update information
                    String update = scanner.nextLine();
                    // calendar.put updates the Calendar HashMap with the updated information
                    calendar.put(date, update);
                    // print confirmation message
                    System.out.println("Update Successful");
                    // print out calendar after update
                    System.out.println(calendar);
                } 
                // if user choice is add
                else if (userChoice.equals("A")) {
                    // prints message asking user to enter event
                    System.out.println("Enter event:");
                    // stores event user entered
                    String event = scanner.nextLine();
                    // prints message asking user to enter date
                    System.out.println("Enter date (MM/DD/YYYY):");
                    // stores date user entered
                    String date = scanner.nextLine();
                    
                    // dateFormatter is date format
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
                    // creates new Date object
                    Date currentDate = new Date();
                    // formats the current date
                    String currentDateString = dateFormatter.format(currentDate);
    
                    // if fate length is greater than ten or if the year the user entered occurs before the current year
                    if (date.length() > 10 || Integer.parseInt(date.substring(6)) < Integer.parseInt(currentDateString.substring(6))) {
                        // prints out invalid date
                        System.out.println("Invalid Date");
                        // asks user if they want to try again
                        System.out.print("Try Again? Y for Yes, N for No: ");
                        // tryAgain stores user response
                        String tryAgain = scanner.nextLine();
                        // convers tryAgain to uppercase
                        tryAgain = tryAgain.toUpperCase();
                        // if user selects Y, they wish to try again
                        if (tryAgain.equals("Y")) {
                            continue;
                        } 
                        // else they do not wish to continue
                        else {
                            // set start to false to backout
                            start = false;
                        }
                    } 
                    // else valid date was selected
                    else {
                        // put date and event in calendar
                        calendar.put(date, event);
                        // print out confirmation message
                        System.out.println("Event was successfully updated");
                    }
    
                } 
                // if user choice is delete
                else if (userChoice.equals("D")) {
                    // if calendar size is less than 1
                    if (calendar.keySet().size() < 1) {
                        // print message that calendar is empty
                        System.out.println("Calendar is empty");
                    } 
                    // else is greater than 0
                    else {
                        // asks user what event they want to delete
                        System.out.println("What event?");
                        // event stores the event to be deleted
                        String event = scanner.nextLine();
                        // fore date in keys
                        for (String date: calendar.keySet()) {
                            // if event is equals to key
                            if (event.equals(calendar.get(date))) {
                                // deletes date from calendar
                                calendar.remove(date);
                                // print out confirmation
                                System.out.println("Event Deleted");
                                // displays calendar after deletion
                                System.out.println(calendar);
                            } else {
                                // prints out if date selected is not in calendar
                                System.out.println("Invalid Date");
                            }
                        }
                    }
                }
                // if user choice is exit
                else if(userChoice.equals("X")) {
                    // set start to false to exit
                    start = false;
                }
                // else invalid command
                else {
                    // prints out message Invalid Command
                    System.out.println("Invalid Command:");
                    // set start to false and exits
                    start = false;
                }
            }

            //close scanner
            scanner.close();
        } 
        // catch an exceptions
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
