import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class BankOnline {
    public static void send(String cardNumber, Double money) throws InvalidCardNumberException,
            TransferToBlockedCardException, NegativeSummOfTransferException,
            TransferOutOfLimitException {
        if(cardNumber == null || money == null){
            throw new NullArgumentException();
        }
        if(cardNumber.length() != 16){
            throw new InvalidCardNumberException();
        }
        for(int i = 0; i < 16; i++){
            if(cardNumber.charAt(i) < '0' || cardNumber.charAt(i) > '9'){
                throw new InvalidCardNumberException();
            }
        }
        HashSet blockCards = new HashSet();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("blockedCards.txt"));
            while (br.ready()){
                blockCards.add(br.readLine());
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(blockCards.contains(cardNumber)){
            throw new TransferToBlockedCardException();
        }
        if(money <= 0){
            throw new NegativeSummOfTransferException();
        }
        if(money > 50000){
            throw new TransferOutOfLimitException();
        }
        System.out.println("Перевод выполнен");
    }
}
