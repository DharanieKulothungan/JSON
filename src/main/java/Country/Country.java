package Country;
import java.util.List;
public class Country
{
    String name;
    List<String> topLevelDomain;
    List<String> callingCodes;
    String capital;
    List<String> altSpellings;
    String population;
    List<Currency> currency;
    List<Language> languages;

}
class Currency
{
    String code;
    String name;
    String symbol;
}
class Language
{
    String iso639_1;
    String iso639_2;
    String name;
    String nativeName;

}
