package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 20/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/my-calendar-ii
 */
public class MyCalendarII {
    private List<Event> calendar = new ArrayList<>();

    public MyCalendarII() {

    }

    public boolean book(int start, int end) {
        final Event event = new Event(start, end);
        final List<Event> doubleBooking = new ArrayList<>();
        for (Event e : calendar) {
            if (e.equals(event)) {
                for (Event eD : doubleBooking) {
                    if (eD.equals(e)) {
                        return false;
                    }
                }
                doubleBooking.add(e);
            }
        }
        calendar.add(event);

        return true;
    }

    private static class Event {
        private int start;
        private int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Event event = (Event) o;

            if ((start < event.start && end <= event.start)
                    || (start >= event.end && end >= event.end)
                    || (event.start < start && event.end <= start)
                    || (event.start >= end && event.end >= end)) {
                return false;
            }

            return true;
        }
    }
}
