package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenComparatorAscByName() {
        List<Job> jobList = Arrays.asList(new Job("Bug fix", 5),
                new Job("Another job", 2), new Job("Error fix", 7));
        jobList.sort(new JobAscByName());
        List<Job> expected = jobList;
        assertThat(jobList).isEqualTo(expected);
    }

    @Test
    void whenComparatorAscByPriority() {
        List<Job> jobList = Arrays.asList(new Job("Bug fix", 5),
                new Job("Another job", 2), new Job("Error fix", 7));
        jobList.sort(new JobAscByPriority());
        List<Job> expected = jobList;
        assertThat(jobList).isEqualTo(expected);
    }

    @Test
    void whenComparatorDescByName() {
        List<Job> jobList = Arrays.asList(new Job("Bug fix", 5),
                new Job("Another job", 2), new Job("Error fix", 7));
        jobList.sort(new JobDescByName());
        List<Job> expected = jobList;
        assertThat(jobList).isEqualTo(expected);
    }

    @Test
    void whenComparatorDescByPriority() {
        List<Job> jobList = Arrays.asList(new Job("Bug fix", 5),
                new Job("Another job", 2), new Job("Error fix", 7));
        jobList.sort(new JobDescByPriority());
        List<Job> expected = jobList;
        assertThat(jobList).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByAscNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int result = cmpNamePriority.compare(
                new Job("Bug fix", 0),
                new Job("Bug fix", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 8),
                new Job("Impl task", 5)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenComparatorEqualByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int result = cmpNamePriority.compare(
                new Job("Fix bug", 7),
                new Job("Fix bug", 7)
        );
        assertThat(result).isEqualTo(0);
    }
}
