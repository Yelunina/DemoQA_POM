package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class DroppablePage extends BasePage {
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        Actions actions = new Actions(driver);
        pause(500);
        actions.dragAndDrop(dragMe, dropHere).perform();

        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }

        return this;
    }

    public DroppablePage actionDragMeBy() {
        Actions actions = new Actions(driver);
        pause(500);
        //find x&y for dragMe
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println(" xOffset1-->" + xOffset1 + " yOffset1--> " + yOffset1);
        //find x&y for dropHere
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println(" xOffset1-->" + xOffset + " yOffset1--> " + yOffset);

        xOffset = (xOffset-xOffset1)+20;
        yOffset = (yOffset-yOffset1)+30;
        actions.dragAndDropBy(dragMe,xOffset,yOffset).perform();

        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("PASS!");
        } else {
            System.out.println("FAIL!");
        }

        return this;
    }
}
