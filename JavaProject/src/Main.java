import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java .util.*;
import java.io.File;
import java.io.PrintWriter;
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the digit that correlates with the task that you'd like to accomplish.");
        System.out.println("1 = Search Stock Quote, 2 = Search Crypto/USD, 3 = US Major Indexes, 4 = News On Tickers");
        System.out.println("5 = Most Active Stocks, 6 = Most Gainer Stocks, 7 = Most Loser Stocks, 8 = PnL Tracker");
        switch (scan.nextInt()){
            case 1:
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the Ticker: ");
                String stockTicker = scan1.nextLine();

                URL urlStockSearch = new URL("https://financialmodelingprep.com/api/v3/quote/" +
                        stockTicker + "?apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                        (urlStockSearch.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 2:
                Scanner scan2 = new Scanner(System.in);
                System.out.println("Enter the Crypto/USD Ticker: (***USD) format");
                String cryptoTicker = scan2.nextLine();

                URL urlCryptoSearch = new URL("https://financialmodelingprep.com/api/v3/" +
                        "historical-price-full/crypto/" + cryptoTicker + "?apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                    (urlCryptoSearch.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 3:
                URL indexes = new URL
                        ("https://financialmodelingprep.com/api/v3/quote/" +
                                "%5EGSPC,%5EDJI,%5EIXIC?apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(indexes.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 4:
                Scanner scan4 = new Scanner(System.in);
                System.out.println("Enter the stock ticker you'd like the news of.");
                String newsSearch = scan4.nextLine();
                URL news = new URL("https://financialmodelingprep.com/api/v3/stock_news?tickers=" +
                        newsSearch + "&apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                        (news.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 5:
                URL mostActive = new URL("https://financialmodelingprep.com/api/v3/stock/" +
                        "actives?apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                        (mostActive.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 6:
                URL mostGainers = new URL("https://financialmodelingprep.com/api/v3/stock/" +
                        "gainers?apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                        (mostGainers.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 7:
                URL mostLosers = new URL("https://financialmodelingprep.com/api/v3/stock/" +
                        "losers?apikey=5d11dce3094b70f727797a600a581653");

                try (BufferedReader reader = new BufferedReader(new InputStreamReader
                        (mostLosers.openStream(), "UTF-8"))) {
                    for (String line; (line = reader.readLine()) != null;) {
                        System.out.println(line);
                    }
                }
                break;
            case 8:
                Scanner scan8 = new Scanner(System.in);
                File file = new File("pnl.txt");
                PrintWriter printwriter = new PrintWriter(file);
                System.out.println("This program is to keep track of weekly gains and losses.");
                System.out.println("How many trades for the week?");
                int numOfTrades = scan8.nextInt();
                printwriter.printf("%-6s %-4s %-8s %-8s %-8s %-18s %n","Ticker","Qty","Cost",
                        "Proceeds","Gain","Expiry/Strike");
                for(int i = 1; i < numOfTrades + 1; ++i) {
                    String tickSymbol = "";
                    String doe = "";
                    System.out.println("Ticker Symbol");
                    tickSymbol = scan8.next();
                    System.out.println("Number of shares/options");
                    int quantity = scan8.nextInt();
                    System.out.println("Date of Expiry, and Strike. (NO SPACES ALLOWED)(TYPE 0 IF NOT AN OPTION)");
                    doe = scan8.next();
                    System.out.println("Cost");
                    double cost = scan8.nextDouble();
                    System.out.println("Proceeds");
                    double proceeds = scan8.nextDouble();
                    System.out.println("Gain");
                    double gain = scan8.nextDouble();
                    printwriter.printf("%-6s %-4s %-8s %-8s %-8s %-18s %n", tickSymbol , quantity , cost , proceeds ,
                            gain , doe);
                }
                printwriter.close();
            }
        }
    }
