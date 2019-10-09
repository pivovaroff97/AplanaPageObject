package pageobject.pages;

public class ProductPage extends BasePage {

    public static int getDigit(String str) {
        StringBuilder digit = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char c : chars)
            if (Character.isDigit(c))
                digit = digit.append(c);
        return Integer.parseInt(digit.toString());
    }
}
