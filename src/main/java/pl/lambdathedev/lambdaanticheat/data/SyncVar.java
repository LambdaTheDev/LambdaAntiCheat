package pl.lambdathedev.lambdaanticheat.data;

import java.util.HashSet;
import java.util.Set;

public class SyncVar<T>
{
    private final Set<SyncVarListener<T>> listeners = new HashSet<>();
    private T value;

    public SyncVar(final T defaultVal)
    {
        value = defaultVal;
    }

    public T getValue()
    {
        return value;
    }

    public void setValue(final T newValue)
    {
        final T oldValue = value;
        value = newValue;

        for(SyncVarListener<T> listener : listeners)
        {
            listener.update(oldValue, newValue);
        }
    }

    public SyncVarListener<T> listen(final SyncVarListener<T> onUpdate)
    {
        listeners.add(onUpdate);
        return onUpdate;
    }

    public void stopListening(final SyncVarListener<T> onUpdate)
    {
        listeners.remove(onUpdate);
    }

    @FunctionalInterface
    public interface SyncVarListener<T>
    {
        void update(final T oldVal, final T newVal);
    }
}
