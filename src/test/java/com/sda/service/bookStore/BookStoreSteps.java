package com.sda.service.bookStore;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BookStoreSteps {
    private Book book;
    private BookStore bookStore;
    private int result;

    @Given("^I instantiate bookstore$")
    public void I_instantiate_bookstore() {
        this.bookStore = new BookStore();
    }

    @And("^I create book$")
    public void iCreateBook(){
        this.book = new Book("Ogniem i mieczem", 222,
                "Henryk Sienkiewicz", "1231-12312-5647-32523");
    }


    @When("^I add book to the bookstore$")
    public void iAddBookToTheBookstore() {
        this.bookStore.add(this.book);
    }

    @And("^I edit title of the book$")
    public void iEditTitleOfTheBook() {
        this.bookStore.updateTitle(book, "Krzyżacy");
    }

    @Then("^Book is present in bookstore$")
    public void bookIsPresentInBookstore() {
        Assert.assertEquals(1, this.bookStore.getBooks().size());
    }

    @Then("^The book title has been changed$")
    public void theBookTitleHasBeenChanged() {
        Assert.assertEquals("Krzyżacy", this.bookStore.getBooks().get(0).getTitle());
    }
}
