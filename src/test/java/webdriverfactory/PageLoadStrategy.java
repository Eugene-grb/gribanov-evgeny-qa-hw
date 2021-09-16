package webdriverfactory;

public enum PageLoadStrategy {

    NORMAL("normal"),
    EAGER("eager"),
    NONE("none");

    private String pageLoadStrategy;

    private PageLoadStrategy(String pageLoadStrategy) {
        this.pageLoadStrategy = pageLoadStrategy;
    }

    @Override
    public String toString() {
        return String.valueOf(this.pageLoadStrategy);
    }

    // Возврат значения константы по строковому значению
    public static PageLoadStrategy fromString(String pageLoadStrategy) {
        if (pageLoadStrategy != null) {
            for(PageLoadStrategy p : PageLoadStrategy.values()) {
                if (pageLoadStrategy.equalsIgnoreCase(p.pageLoadStrategy)) {
                    return p;
                }
            }
        }
        return null;
    }

    public String getPageLoadStrategy() {
        return this.pageLoadStrategy;
    }
}
