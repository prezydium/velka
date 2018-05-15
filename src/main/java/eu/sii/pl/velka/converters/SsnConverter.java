package eu.sii.pl.velka.converters;

public class SsnConverter {

    public String convertSsnToFormatAcceptableByAPI(String s) {
        int positionOfFirstDashInSnn = 3;
        int positionOfSecondDashInSnn = 7;
        StringBuilder sb = new StringBuilder(s.replace("-", ""));
        sb.insert(positionOfFirstDashInSnn, '-');
        sb.insert(positionOfSecondDashInSnn, '-');
        return sb.toString();
    }
}
