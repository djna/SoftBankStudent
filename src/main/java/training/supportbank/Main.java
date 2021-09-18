package training.supportbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance();
    private static final Pattern COMMAND_PATTERN = Pattern.compile("^List (.*)$"
                          , Pattern.CASE_INSENSITIVE);
    private static Map<String, Account> theAccounts;
    private static final Logger LOGGER = LogManager.getLogger("SupportBank");

    public static void main(String args[]) throws IOException {

        LOGGER.error("Test Error" );
        LOGGER.warn("Test Warn" );
        LOGGER.info("Started " );
        LOGGER.debug("debug " );
        theAccounts =  TransactionsProcessor.buildAccountsFromCsv("Transactions2014.csv");

        printBanner();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            parseAndExecuteCommand(command);
        }
    }

    private static void printBanner() {
        System.out.println("Welcome to SupportBank!");
        System.out.println("=======================");
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("  List All - list all account balances");
        System.out.println("  List [Account] - list transactions for the specified account");
        System.out.println();
    }

    private static void parseAndExecuteCommand(String command) {
        if (command.equalsIgnoreCase("quit")) {
            System.out.println("Goodbye.");
            System.exit(0);
        }
        Matcher matcher = COMMAND_PATTERN.matcher(command);

        if (matcher.find()) {
            String accountName = matcher.group(1);

            if (accountName.equalsIgnoreCase("all")) {
                listAllAccounts();
            } else {
                listSingleAccount(accountName);
            }
        } else {
            System.out.println("invalid command");
        }
    }

    static private void listAllAccounts(){
        System.out.println("request List All");
        System.out.printf("we have %d",  theAccounts.size());
        for (Account account : theAccounts.values()) {
            //BigDecimal balance = account.calculateBalance();
            //String owingMessage = balance.compareTo(BigDecimal.ZERO) < 0 ? "owes" : "is owed";
            //String balanceString = CURRENCY_FORMAT.format(balance.abs());
            //System.out.println("  " + account.getOwner() + " " + owingMessage + " " + balanceString);
            System.out.println("  " + account.toString() );
        }

        System.out.println();

    }

    static private void listSingleAccount(String name){
        System.out.printf("List %s", name);
    }

}
