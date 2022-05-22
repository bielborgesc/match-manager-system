public class FindMatchUseCase {
    private MatchDAO matchDAO;

    public FindScoreUseCase(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public Optional<Score> findOne(Integer idMatch) {
        if (idMatch == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return matchDAO.findOne(idMatch);
    }

    public List<Score> findAll(){
        return matchDAO.findAll();
    }
}