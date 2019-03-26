package rx;

public interface Observer<T>{
    void onValueChanged(T newVal);
}
