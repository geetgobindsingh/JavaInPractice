package gfg.amazonprep.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxFreeTime {
    public static void main(String[] args) {
//        String[] ar = new String[]{"12:15PM-02:00PM", "09:00AM-10:00AM", "10:30AM-12:00PM"};
//        System.out.println(finsMaxFreeTime(ar));
        String[] aar = new String[]{"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};
        System.out.println(finsMaxFreeTime(aar));
    }

    static class Time {
        int hours;
        int minutes;
        String AMPM;
        int totalMinutes;
        Time endTime;
    }

    public static Time parseTime(String raw) {
        Time time1 = new Time();
        String[] time = raw.split(":");
        time1.hours = Integer.parseInt(time[0]);
        time1.minutes = Integer.parseInt((time[1].substring(0, 2)));
        time1.AMPM = time[1].substring(2).toUpperCase();
        time1.totalMinutes = time1.hours * 60 + time1.minutes;
        if (time1.AMPM.equals("PM") && time1.hours < 12) {
            time1.totalMinutes += 12 * 60;
        }
        return time1;
    }

    private static String finsMaxFreeTime(String[] ar) {
        List<Time> list = new ArrayList<>();
        for (String range : ar) {
            String[] startEnd = range.split("-");
            Time start = parseTime(startEnd[0]);
            start.endTime = parseTime(startEnd[1]);
            list.add(start);
        }
        list.sort(new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return Integer.compare(o1.totalMinutes, o2.totalMinutes);
            }
        });

        int mostDiff = 0;
        for (int i = 0; i < (list.size() - 1); i++) {
            Time endTimeOfEvent = list.get(i).endTime;
            Time startTimeOfNextEvent = list.get(i + 1);
            int diff = startTimeOfNextEvent.totalMinutes - endTimeOfEvent.totalMinutes;
            if (diff > mostDiff) {
                mostDiff = diff;
            }
        }

        String output;
        if (mostDiff < 60)
            output = "00:" + formatTime(mostDiff);
        else {
            int hours = mostDiff / 60;
            int minutes = mostDiff % 60;
            output = formatTime(hours) + ':' + formatTime(minutes);
        }
        return output;
    }

    private static String formatTime(int time) {
        return (time < 10) ? "0" + time : "" + time;
    }
}
