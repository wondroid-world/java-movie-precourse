package movie.domain.screening;

import java.util.ArrayList;
import java.util.List;

public class Screenings {
    private static final String ERROR_OVERLAPPED = "이미 존재하는 상영과 시간이 겹칩니다.";

    private final List<Screening> screenings = new ArrayList<>();

    public void add(Screening screening) {
        for (Screening existing : screenings) {
            if (isOverlapped(existing, screening)) {
                throw new IllegalArgumentException(ERROR_OVERLAPPED);
            }
        }
        screenings.add(screening);
    }

    private boolean isOverlapped(Screening a, Screening b) {
        return a.getStartTime().isBefore(b.getEndTime())
                && b.getStartTime().isBefore(a.getEndTime());
    }

    public List<Screening> getScreenings() {
        return List.copyOf(screenings);
    }
}
