package ui;


import org.openqa.selenium.By;

public interface ILocator<T extends ILocator> {
    By get();

    T at(int position);
}
