package shakti.winter.tree;

/**
 * The mind interface. This is what any 'brain' for a Being in Winter must implement.
 */
public interface Mind <T> {

    /**
     * The method called each turn on each Mind in a living Being to see what action the Being will take.
     * @return Value indicating the Mind's decision
     */
    public T decide();

    /**
     * Mind mutate method. Could be called zero to many times after a year, depending on how much
     * extra warmth the Being generated. 
     * @return While any Mind can be returned from this method, modifying the Mind that was successful enough to have its mutate method called seems like a sound evolutionary strategy.
     */
    public Mind<T> mutate();
}
