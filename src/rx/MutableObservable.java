package rx;

final public class MutableObservable<T> extends Observable<T> {

    public void setValue(T value) {
        super.setValue(value);
    }
}
