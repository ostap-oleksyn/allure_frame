package ui;


public interface ILocator<T extends ILocator> {
    T at(int position);

    T at(String position);

    String getName();

    LocatorType getLocatorType();

    String getRawLocator();

    void resetPosition();

    String getPosition();

}
