package christmas.domain.event;

public enum EventBadge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NOTHING("없음", 0);

    public final String badgeName;
    public final Integer threshold;

    EventBadge(String badgeName, Integer threshold) {
        this.badgeName = badgeName;
        this.threshold = threshold;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
