package training.supportbank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

    private String myName;
    private List<Transaction> myIncomingTransactions;
    private List<Transaction> myOutgoingTransactions;

    public Account(String name){
        if ( name == null){
            throw new IllegalArgumentException("name cannot be null");
        }
        myName = name;

        myIncomingTransactions = new ArrayList<Transaction>();
        myOutgoingTransactions = new ArrayList<Transaction>();
    }

    public void addIncomingTransaction(Transaction incoming){
        if (! incoming.getTo().equals(myName)){
            throw new IllegalArgumentException("wrong account for incoming");
        }
        myIncomingTransactions.add(incoming);
    }

    public void addOutgoingTransaction(Transaction outgoing){
        if (! outgoing.getFrom().equals(myName)){
            throw new IllegalArgumentException("wrong account for incoming");
        }
        myOutgoingTransactions.add(outgoing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return myName.equals(account.myName);
    }

    @Override
    public String toString() {
        return "Account{" +
                "myName='" + myName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(myName);
    }
}
