package rx;

public class Observable<T> {

    private T value;
    private Observer<T> observer;

    public Observable() {
    }

    public T getValue() {
        return value;
    }

    protected void setValue(T value) {
        this.value = value;
        if(observer != null){
            observer.onValueChanged(value);
        }
    }

    public void observe(Observer<T> observer){
        this.observer = observer;
        observer.onValueChanged(this.value);
    }

    public void stopObserving(){
        observer = null;
    }



}
