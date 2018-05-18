package eu.sii.pl.velka.converters;

public class SsnConverter {
    final static int positionOfFirstDashInSnn = 3;
    final static int positionOfSecondDashInSnn = 7;

    public String convertSsnToFormatAcceptableByAPI(String s) {
        StringBuilder sb = new StringBuilder(s.replace("-", ""));
        sb.insert(positionOfFirstDashInSnn, '-');
        sb.insert(positionOfSecondDashInSnn, '-');
        return sb.toString();
    }
}
