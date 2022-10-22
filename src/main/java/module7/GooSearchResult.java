package module7;

public class GooSearchResult {
    private final String url;

    public GooSearchResult(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String parseDomain() {
        String result = "";

        if (url.contains("https://")) {
            result = url.substring(8, url.length());
        } else {
            result = url.substring(7, url.length());
        }
        if (result.contains("/")) {
            result = result.substring(0, result.indexOf("/"));
        }
        return result;
    }
}

class GooSearchResultTest {
    public static void main(String[] args) {
        //test.com
        System.out.println(new GooSearchResult("https://test.com").parseDomain());

        //apple.in.mars
        System.out.println(new GooSearchResult("http://apple.in.mars").parseDomain());

        //www.edu.goit.global
        System.out.println(new GooSearchResult("https://www.edu.goit.global/ru/learn/6078559/5673446/").parseDomain());
    }
}