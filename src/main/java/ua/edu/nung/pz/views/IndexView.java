package ua.edu.nung.pz.views;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexView {

    private String path;
    private static IndexView indexView = new IndexView();

    private IndexView() {

    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHeader(String userName) {
        String html = getHtml("headerPartial");
        if (userName.length() > 0) {
            html = conditionalTextDelete(html, "usernameNotLogin")
                    .replace("<!--###username###-->", userName);
        } else {
            html = conditionalTextDelete(html, "usernameLoginedIn");

        }


        return html;
    }


    public String getPage(String title, String body) {
        return getHtml("emptyPage").replace("##title##", title)
                .replace("##body##", body);

    }


    public String getLoginForm() {
        return getHtml("authForm");
    }

    public static String getBody(String header, String footer, String context) {
        return header + "<div class=\"container\">\n" +
                context +
                "</div>\n" +
                footer;
    }

    public String getFooter(String footer) {
        return getHtml("footerPartial");


    }

    public static IndexView getInstance() {
        return indexView;
    }

    private String getHtml(String filename) {
        StringBuilder sb = new StringBuilder("\n");
        Path path = Paths.get(this.path + filename + ".html");

        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (Exception ex) {

        }
        return sb.toString();
    }

    private String conditionalTextDelete(String html, String markToDelete) {
        String startMarker = "<!--Variable ###" + markToDelete + "###-->";
        String endMarker = "<!--endVariable-->";


        int startIndex = html.indexOf(startMarker);
        if (startIndex == -1) {
            return html;
        }
        int endIndex = html.indexOf(endMarker, startIndex);
        if (endIndex == -1) {
            return html;
        }
        String firstPart = html.substring(0, startIndex);
        String endPart = html.substring(endIndex + endMarker.length());

        return firstPart + endPart;
    }


}
