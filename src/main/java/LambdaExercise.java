import java.util.*;

public class LambdaExercise {
    static List<String> countries = new ArrayList<>();
    static Map<String, String> countryCapitals = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("--list of countries");
        displayCountries();
        System.out.println("--list of countries with their capitals");
        displayCountryCapitals();
        System.out.println("--sorting countries by name");
        sortCountriesByName();
        displayCountries();
        System.out.println("--sorting countries by length followed by alphabetically");
        sortCountriesByLength();
        displayCountries();
        System.out.println("--removing countries");
        removeCountry("Philippines");
        displayCountries();
    }

    static {
        countries.add("China");
        countries.add("Egypt");
        countries.add("France");
        countries.add("Philippines");
        countries.add("India");
        countries.add("Indonesia");
        countryCapitals.put("China", "Beijing");
        countryCapitals.put("Egypt", "Cairo");
        countryCapitals.put("France", "Paris");
        countryCapitals.put("Philippines", "Manila");
        countryCapitals.put("India", "Delhi");
        countryCapitals.put("Indonesia", "Jakarta");
    }

    public static void displayCountries() {
        countries.forEach(country -> System.out.println(country));
    }

    public static void displayCountryCapitals() {
        countryCapitals.forEach((country, capital) -> System.out.println(country + " : " + capital));
    }

    public static void sortCountriesByName() {
        Comparator<String> nameComparatorDesc = (String s1, String s2) -> ((int) s2.compareTo(s1));
        Collections.sort(countries, nameComparatorDesc);
    }

    public static void sortCountriesByLength() {
        Comparator<String> lengthComparatorDesc = (String s1, String s2) -> ((int) s2.length() - s1.length());
        Comparator<String> nameComparator = (String s1, String s2) -> ((int) s1.compareTo(s2));

        Collections.sort(countries, lengthComparatorDesc.thenComparing(nameComparator));
    }

    public static void removeCountry(String name) {
        countries.removeIf(country -> country.equals(name) && country.length()>6);
    }

}
