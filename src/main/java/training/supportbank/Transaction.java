package training.supportbank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private LocalDate myDate;
    private String myFrom;
    private String myTo;
    private String myNarrative;
    private BigDecimal myAmount;

    @Override
    public String toString() {
        return "Transaction{" +
                "myDate=" + myDate +
                ", myFrom='" + myFrom + '\'' +
                ", myTo='" + myTo + '\'' +
                ", myNarrative='" + myNarrative + '\'' +
                ", myAmount=" + myAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return myDate.equals(that.myDate) && myFrom.equals(that.myFrom) && myTo.equals(that.myTo) && myNarrative.equals(that.myNarrative) && myAmount.equals(that.myAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myDate, myFrom, myTo, myNarrative, myAmount);
    }

    public LocalDate getDate() {
        return myDate;
    }

    public String getFrom() {
        return myFrom;
    }

    public String getTo() {
        return myTo;
    }

    public String getNarrative() {
        return myNarrative;
    }

    public BigDecimal getAmount() {
        return myAmount;
    }

    public Transaction(LocalDate transactionDate,
                       String from,
                       String to,
                       String narrative,
                       BigDecimal amount
                       ){
        myDate = transactionDate;
        myFrom = from;
        myTo = to;
        myNarrative = narrative;
        myAmount = amount;
    }
}
