package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.*;
import org.junit.Test;
import se.nackademin.librarytest.helpers.Table;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;

public class SelenideTest extends TestBase {

    public SelenideTest() {
    }

    @Test
    public void testUsingTable() {
        page(MenuPage.class).navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.setTitleField("G");
        browseBooksPage.clickSearchBooksButton();
        Table table = new Table($(".v-grid-tablewrapper"));
        System.out.println(table.getColumnCount());
        System.out.println(table.getRowCount());
        System.out.println(table.getCellValue(0, 0));
        System.out.println(table.getCellValue(1, 1));
        table.searchAndClick("American Gods", 0);
        sleep(2000);
    }
}
