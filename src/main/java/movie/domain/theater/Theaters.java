package movie.domain.theater;

import java.util.ArrayList;
import java.util.List;

public class Theaters {
    private final List<Theater> theaters = new ArrayList<>();

    public void add(Theater newTheater) {
        if (!theaters.contains(newTheater)) {
            theaters.add(newTheater);
        }
    }

    public void remove(Theater theater) {
        theaters.remove(theater);
    }

    public List<Theater> getAllTheaters() {
        return theaters;
    }
}
