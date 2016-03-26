package actions;


public interface IPosition<T> {
    T at(int position);

    T at(String position);
}
