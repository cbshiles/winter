package shakti.winter.winter;

/**
 * The mind interface. This is what any 'brain' for a Being in Winter must implement.
 */
public interface Mind {

    /**
     * The method called each turn on each Mind in a living Being to see what action the Being will take. The question that is being
     * decided is 'Am I going to pick up a hot potato this turn? So if this method returns true, the Being will pick up a potato, otherwise the Being will huddle.
     * @param potatoes The number of potatoes this being has before the decision.
     * @param turnsLeft The number of turns before Winter, not including the current one.
     * @return True for pick up potatoe, false for huddle.
     */
    public boolean decide(int potatoes, int turnsLeft);

    /**
     * Mind mutate method. Could be called zero to many times after a year, depending on how much
     * extra warmth the Being generated. 
     * @return While any Mind can be returned from this method, modifying the Mind that was successful enough to have its mutate method called seems like a sound evolutionary strategy.
     */
    public Mind mutate();
}
