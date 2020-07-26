package io.quarkus.backports.model;

import java.util.List;
import java.util.Objects;

public class PullRequest {
    public int number;

    public String url;

    public String title;

    public String createdAt;

    public Milestone milestone;

    public User author;

    public List<Commit> commits;

    public PullRequest(String number) {
        this.number = Integer.parseInt(number);
    }

    public PullRequest() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PullRequest)) return false;
        PullRequest that = (PullRequest) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "PullRequest{" +
                "number=" + number +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", milestone=" + milestone +
                ", author=" + author +
                ", commits=" + commits +
                '}';
    }
}
