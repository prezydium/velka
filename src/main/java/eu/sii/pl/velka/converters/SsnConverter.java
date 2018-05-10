package eu.sii.pl.velka.converters;

public class SsnConverter {

    public String convertSsnToFormatAcceptableByAPI(String s) {
        StringBuilder sb = new StringBuilder(s.replace("-",""));
        sb.insert(3, '-');
        sb.insert(7, '-');
        return sb.toString();
    }
}
