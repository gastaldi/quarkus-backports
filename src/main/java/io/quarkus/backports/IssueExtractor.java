package io.quarkus.backports;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IssueExtractor {

    private final Pattern pattern;

    public IssueExtractor(String repository) {
        pattern = Pattern.compile("\\b(?:(?:fix(?:e[sd])?|(?:(?:resolve|close)[sd]?))):?\\s+(?:https?:\\/\\/github.com\\/" + Pattern.quote(repository) + "\\/issues\\/|#)(\\d+)",
                                  Pattern.CASE_INSENSITIVE);
    }

    public Set<Integer> extractIssueNumbers(String content) {
        Set<Integer> result = new TreeSet<>();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            Integer issueNumber = Integer.valueOf(matcher.group(1));
            result.add(issueNumber);
        }
        return result;
    }
}
