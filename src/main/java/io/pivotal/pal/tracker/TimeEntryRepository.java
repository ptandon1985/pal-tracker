package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public List<TimeEntry> list();

    public TimeEntry find(long nonExistentTimeEntryId);

    public TimeEntry update(long eq, TimeEntry any);

    public TimeEntry create(TimeEntry timeEntryToCreate);

    public void delete(long timeEntryId);
}
