public class Banktest {
    public static void main(String[] args) throws InvalidCardNumberException,
            TransferToBlockedCardException, NegativeSummOfTransferException,
            TransferOutOfLimitException {
        BankOnline.send("1111111111111112", 2000.0);
        //BankOnline.send("11111111111a1112", 2000.0);
        //BankOnline.send("1111111111111111111112", 2000.0);
        //BankOnline.send("1111111111111111", 2000.0);
        //BankOnline.send("1111111111111112", -2000.0);
        //BankOnline.send("1111111111111112", 0.0);
        //BankOnline.send("1111111111111112", 200000000.0);
        //BankOnline.send("1111111111111112", null);
        //BankOnline.send(null, -2000.0);
    }
}
