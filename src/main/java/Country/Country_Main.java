package Country;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Scanner;


public class Country_Main
{
    public String findCountry(String countryCode) throws IOException
    {
        String url = "https://restcountries.eu/rest/v2/alpha/" + countryCode;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        HttpResponse httpresponse = httpclient.execute(httpget);
        HttpEntity httpEntity=httpresponse.getEntity();
        String jsonResponse= EntityUtils.toString(httpEntity);
        Gson gson=new Gson();
        Country country=gson.fromJson(jsonResponse,Country.class);
        return "Country name: "+country.name+" , Capital :"+country.capital+" , Population :"+country.population;
    }
    public static void main(String[] args) throws IOException
    {
        Country_Main countryFinder = new Country_Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the CountryCode :");
        String countryCode=scanner.next();
        System.out.println("Country information :");
        System.out.println(countryFinder.findCountry(countryCode));
    }
}
