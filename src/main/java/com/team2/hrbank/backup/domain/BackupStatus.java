package com.team2.hrbank.backup.domain;

public enum BackupStatus {
    IN_PROGRESS("진행중"),
    COMPLETED("완료"),
    FAILED("실패"),
    SKIPPED("건너뜀");

    private final String label;

    BackupStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
