package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry te = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(te, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry te = timeEntryRepository.find(timeEntryId);
        if (null != te)
            return new ResponseEntity<>(te, HttpStatus.OK);
        else
            return new ResponseEntity<>(te, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry updatedTimeEntry) {
        TimeEntry te = timeEntryRepository.update(timeEntryId, updatedTimeEntry);
        if (null != te)
            return new ResponseEntity<>(te, HttpStatus.OK);
        else
            return new ResponseEntity<>(te, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> teList = timeEntryRepository.list();

        return new ResponseEntity<>(teList, HttpStatus.OK);
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity delete(@PathVariable long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
