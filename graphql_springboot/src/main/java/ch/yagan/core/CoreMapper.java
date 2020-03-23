package ch.yagan.core;

public interface CoreMapper<E extends CoreEntity, I> {

    E fromInput(I input);

}
