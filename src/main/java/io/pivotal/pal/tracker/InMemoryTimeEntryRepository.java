package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<>();

    private long id=0L;
    public TimeEntry create(TimeEntry timeEntry) {
        id = id+1;
        timeEntry.setId(id);
        timeEntryMap.put(id, timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (!timeEntryMap.containsKey(id))  return null;
        timeEntry.setId(id);
        timeEntryMap.put(id, timeEntry);
        return timeEntry;
    }

    public void delete(long id) {
        timeEntryMap.remove(id);
    }
}
